package com.moma.sample.retrofit2.helper;

import org.springframework.util.ObjectUtils;

/**
 * ObjectHelper
 *
 * <p>Object Helper
 *
 * @see <a href="https://github.com/moma-tech/m64/tree/master/m64-core">M64-CORE</a>
 * @author ivan
 * @version 1.0 Created by ivan at 11/20/20.
 */
public class ObjectHelper {

  /**
   * If Object null or content is empty {@link ObjectUtils#isEmpty(Object)}
   *
   * @author Created by ivan on 1:39 PM 11/23/20.
   * @param obj : Object
   * @return boolean
   */
  public static boolean isEmpty(Object obj) {
    return ObjectUtils.isEmpty(obj);
  }
  /**
   * If Object not null and content is not empty {@link ObjectUtils#isEmpty(Object)} c
   *
   * @author Created by ivan on 1:39 PM 11/23/20.
   * @param obj : Object
   * @return boolean
   */
  public static boolean isNotEmpty(Object obj) {
    return !isEmpty(obj);
  }

  /**
   * Cast Object to String,return "null" or ""
   *
   * @author Created by ivan on 11:12 AM 11/25/20.
   * @param object : object
   * @return java.lang.String
   */
  public static String toString(Object object) {
    return ObjectUtils.nullSafeToString(object);
  }
}
