package com.moma.sample.retrofit2.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.moma.sample.retrofit2.helper.constants.DateTimePatterns;
import com.moma.sample.retrofit2.helper.constants.JsonNamingStrategyEnum;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * JsonHelper
 *
 * <p>Base on Jackson Json
 *
 * @see <a href="https://github.com/moma-tech/m64/tree/master/m64-core">M64-CORE</a>
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
public class JsonHelper {
  private static ObjectMapper objectMapper;

  static {
    objectMapper = getObjectMapper(new ObjectMapper());
  }
  /**
   * getObjectMapper
   *
   * <p>return static Object Mapper
   *
   * @author Created by ivan at 下午4:25 2020/1/10.
   * @return com.fasterxml.jackson.databind.ObjectMapper
   */
  public static ObjectMapper getObjectMapper() {
    return Objects.isNull(objectMapper) ? getObjectMapper(null) : objectMapper;
  }

  /**
   * getObjectMapper
   *
   * <p>return static Object Mapper base on third Mapper
   *
   * @author Created by ivan at 下午4:25 2020/1/10.
   * @return com.fasterxml.jackson.databind.ObjectMapper
   */
  public static ObjectMapper getObjectMapper(ObjectMapper thirdMapper) {
    if (Objects.isNull(thirdMapper)) {
      return getObjectMapper(new ObjectMapper());
    }
    return configureObjectMapper(thirdMapper);
  }

  /**
   * setLowCamelCaseMapper
   *
   * <p>Set JacksonHelper as LowCamelCase
   *
   * @author Created by ivan at 下午4:26 2020/1/10.
   */
  public static void setLowCamelCaseMapper() {
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
  }

  /**
   * setSnakeCaseMapper
   *
   * <p>Set JacksonHelper as SnakeCase
   *
   * @author Created by ivan at 下午4:29 2020/1/10.
   */
  public static void setSnakeCaseMapper() {
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
  }

  /**
   * configureObjectMapper
   *
   * <p>Configure Object Mapper
   *
   * @see <a href=
   *     "https://github.com/FasterXML/jackson-databind/wiki/Deserialization-Features">Deserialization
   *     Features</a>
   * @see <a href=
   *     "https://github.com/FasterXML/jackson-databind/wiki/Serialization-Features">Serialization
   *     features</a>
   * @see <a href="https://github.com/FasterXML/jackson-databind/wiki/Mapper-Features">Mapper
   *     Features</a>
   * @author Created by ivan at 上午10:47 2020/1/10.
   * @return com.fasterxml.jackson.databind.ObjectMapper
   */
  static ObjectMapper configureObjectMapper(ObjectMapper objectMapper) {
    // Set Naming Strategy
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
    // Set Feature
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    objectMapper.enable(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
    objectMapper.enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature());
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    // registerNullSerializer(objectMapper);
    // Handle Java Time & JSR310
    registerJavaTime(objectMapper);

    // Handler Long 2 String
    registerLongSerializer(objectMapper);

    return objectMapper;
  }

  /**
   * @author Created by Ivan at 2020/6/3.
   *     <p>Handle NUll to ""
   * @param objectMapper :
   * @return void
   */
  public static void registerNullSerializer(ObjectMapper objectMapper) {
    objectMapper
        .getSerializerProvider()
        .setNullValueSerializer(
            new JsonSerializer<Object>() {
              @Override
              public void serialize(
                  Object paramT,
                  JsonGenerator paramJsonGenerator,
                  SerializerProvider paramSerializerProvider)
                  throws IOException {
                // 设置返回null转为 空字符串""
                paramJsonGenerator.writeString("");
              }
            });
  }

  /**
   * registerJavaTime
   *
   * <p>Handle Time Format to JSR310
   *
   * @author Created by ivan at 下午2:52 2020/1/10.
   * @return com.fasterxml.jackson.databind.ObjectMapper
   */
  public static void registerJavaTime(ObjectMapper objectMapper) {
    // Handle Java Time
    objectMapper.registerModule(new JavaTimeModule());

    // Handle JSR310 Time
    SimpleModule jsr310Module = new SimpleModule();
    jsr310Module.addSerializer(
        LocalDateTime.class,
        new LocalDateTimeSerializer(
            DateTimeFormatter.ofPattern(DateTimePatterns.DEFAULT_DATETIME_PATTERN)));
    jsr310Module.addSerializer(
        LocalDate.class,
        new LocalDateSerializer(
            DateTimeFormatter.ofPattern(DateTimePatterns.DEFAULT_DATE_PATTERN)));
    jsr310Module.addSerializer(
        LocalTime.class,
        new LocalTimeSerializer(
            DateTimeFormatter.ofPattern(DateTimePatterns.DEFAULT_TIME_PATTERN)));
    jsr310Module.addDeserializer(
        LocalDateTime.class,
        new LocalDateTimeDeserializer(
            DateTimeFormatter.ofPattern(DateTimePatterns.DEFAULT_DATETIME_PATTERN)));
    jsr310Module.addDeserializer(
        LocalDate.class,
        new LocalDateDeserializer(
            DateTimeFormatter.ofPattern(DateTimePatterns.DEFAULT_DATE_PATTERN)));
    jsr310Module.addDeserializer(
        LocalTime.class,
        new LocalTimeDeserializer(
            DateTimeFormatter.ofPattern(DateTimePatterns.DEFAULT_TIME_PATTERN)));
    objectMapper.registerModule(jsr310Module);
  }

  /**
   * registerLongSerializer
   *
   * <p>Handle Long Format to String
   *
   * @author Created by ivan at 下午2:53 2020/1/10.
   */
  public static void registerLongSerializer(ObjectMapper objectMapper) {
    SimpleModule long2StringModule = new SimpleModule();
    // Handle long
    long2StringModule.addSerializer(Long.class, ToStringSerializer.instance);
  }

  /**
   * parse
   *
   * <p>read String to Object
   *
   * @author Created by ivan at 下午4:30 2020/1/10.
   * @return java.lang.Object
   */
  public static Object readValue(String jsonString) {
    Object object = null;
    try {
      object = getObjectMapper().readValue(jsonString, Object.class);
    } catch (Exception ignore) {
    }
    return object;
  }

  /**
   * parse
   *
   * <p>read String to Object as specified Name Strategy
   *
   * @author Created by ivan at 下午5:09 2020/1/10.
   * @return java.lang.Object
   */
  public static Object readValue(String jsonString, JsonNamingStrategyEnum jsonNameStrategy) {
    Object object = null;
    if (JsonNamingStrategyEnum.LOWER_CAMEL_CASE.equals(jsonNameStrategy)) {
      object = readValue(jsonString);
    } else if (JsonNamingStrategyEnum.SNAKE_CASE.equals(jsonNameStrategy)) {
      setSnakeCaseMapper();
      object = readValue(jsonString);
      setLowCamelCaseMapper();
    }
    return object;
  }

  /**
   * readValue
   *
   * <p>read json into simple class
   *
   * @author Created by ivan at 下午5:54 2020/1/10.
   * @return T
   */
  public static <T> T readValue(String json, Class<T> clazz) {
    T t = null;
    try {
      t = getObjectMapper().readValue(json, clazz);
    } catch (Exception ignore) {
      throw new RuntimeException("Unable to read JSON value: " + json, ignore);
    }
    return t;
  }

  /**
   * readValue
   *
   * <p>read json into simple class as specified Name Strategy
   *
   * @author Created by Ivan at 上午11:57:41 2020年1月12日
   * @return T
   */
  public static <T> T readValue(
      String json, Class<T> clazz, JsonNamingStrategyEnum jsonNameStrategy) {
    T t = null;
    try {
      if (JsonNamingStrategyEnum.LOWER_CAMEL_CASE.equals(jsonNameStrategy)) {
        t = readValue(json, clazz);
      } else if (JsonNamingStrategyEnum.SNAKE_CASE.equals(jsonNameStrategy)) {
        setSnakeCaseMapper();
        t = readValue(json, clazz);
        setLowCamelCaseMapper();
      }
    } catch (Exception ignore) {
      throw new RuntimeException(ignore);
    }
    return t;
  }

  /**
   * readValue
   *
   * <p>read json into complex class
   *
   * @author Created by ivan at 下午5:55 2020/1/10.
   * @return T
   */
  public static <T> T readValue(String json, TypeReference<T> valueTypeRef) {
    T t;
    try {
      t = getObjectMapper().readValue(json, valueTypeRef);
    } catch (Exception ignore) {
      throw new RuntimeException(ignore);
    }
    return t;
  }

  /**
   * readValue
   *
   * <p>read json into complex class as specified Name Strategy
   *
   * @author Created by Ivan at 下午12:11:13 2020年1月12日
   * @return T
   */
  public static <T> T readValue(
      String json, TypeReference<T> valueTypeRef, JsonNamingStrategyEnum jsonNameStrategy) {
    T t = null;
    try {
      if (JsonNamingStrategyEnum.LOWER_CAMEL_CASE.equals(jsonNameStrategy)) {
        t = readValue(json, valueTypeRef);
      } else if (JsonNamingStrategyEnum.SNAKE_CASE.equals(jsonNameStrategy)) {
        setSnakeCaseMapper();
        t = readValue(json, valueTypeRef);
        setLowCamelCaseMapper();
      }
    } catch (Exception ignore) {
      // TODO maybe ignored
      throw new RuntimeException(ignore);
    }
    return t;
  }

  /**
   * toJson
   *
   * <p>read object into json
   *
   * @author Created by ivan at 下午5:59 2020/1/10.
   * @return java.lang.String
   */
  public static String toJson(Object object) {
    if (Objects.nonNull(object) && CharSequence.class.isAssignableFrom(object.getClass())) {
      return object.toString();
    }
    try {
      return getObjectMapper().writeValueAsString(object);
    } catch (JsonProcessingException ignore) {
      // TODO maybe ignored
      throw new RuntimeException(ignore);
    }
  }
}
