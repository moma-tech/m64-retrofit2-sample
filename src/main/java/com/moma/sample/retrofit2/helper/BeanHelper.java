package com.moma.sample.retrofit2.helper;

import org.springframework.cglib.beans.BeanMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * BeanHelper
 *
 * @see <a href="https://github.com/moma-tech/m64/tree/master/m64-core">M64-CORE</a>
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
public class BeanHelper {
  /**
   * @param bean :
   * @return java.util.Map<java.lang.String , java.lang.String>
   * @author Created by ivan on 3:04 PM 12/27/18.
   *     <p>bean To <String,String> Map
   *     <p>ignor null value
   */
  public static <T> Map<String, String> beanToStringMap(T bean) {
    Map<String, String> map = Collections.emptyMap();
    if (null != bean) {
      BeanMap beanMap = BeanMap.create(bean);
      map = new HashMap<>(beanMap.keySet().size());
      for (Object key : beanMap.keySet()) {
        if (Objects.nonNull(beanMap.get(key))) {
          map.put(String.valueOf(key), StringHelper.toString(beanMap.get(key)));
        }
      }
    }
    return map;
  }
}
