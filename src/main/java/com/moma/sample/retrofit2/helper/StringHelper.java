package com.moma.sample.retrofit2.helper;

import java.nio.ByteBuffer;

/**
 * StringHelper
 *
 * <p>String Helper
 *
 * @see <a href="https://github.com/moma-tech/m64/tree/master/m64-core">M64-CORE</a>
 * @author ivan
 * @version 1.0 Created by ivan at 11/20/20.
 */
public class StringHelper {
  /**
   * cast Object toString, or null
   *
   * @author Created by ivan on 5:10 PM 11/23/20.
   * @param object : given Object
   * @return java.lang.String
   */
  public static String toString(Object object) {
    return toString(object, null);
  }
  /**
   * ast Object toString, or default value
   *
   * @author Created by ivan on 10:43 AM 11/25/20.
   * @param object :
   * @param defaultValue :
   * @return java.lang.String
   */
  public static String toString(Object object, String defaultValue) {
    return toString(object, defaultValue, null);
  }

  /**
   * cast Object to toString, or default value, consider charset for byte
   *
   * @author Created by ivan on 10:18 AM 11/25/20.
   * @param object : given Object
   * @param defaultValue : default Value
   * @return java.lang.String
   */
  public static String toString(Object object, String defaultValue, String charset) {
    if (null == object) {
      return defaultValue;
    }
    if (object instanceof String) {
      return (String) object;
    } else if (object instanceof byte[] || object instanceof Byte[]) {
      return toString((byte[]) object, charset);
    } else if (object instanceof ByteBuffer) {
      return toString((ByteBuffer) object, charset);
    } else {
      return ObjectHelper.toString(object);
    }
  }
  /**
   * Test If two Char Sequences are equals;
   *
   * @author Created by ivan on 5:36 PM 11/30/20.
   * @param cs1 : Char Sequence 1
   * @param cs2 : Char Sequence 2
   * @return boolean
   */
  public static boolean equals(CharSequence cs1, CharSequence cs2) {
    if (cs1 == cs2) {
      return true;
    } else if (cs1 != null && cs2 != null) {
      return cs1 instanceof String && cs2 instanceof String
          ? cs1.equals(cs2)
          : regionMatches(cs1, false, 0, cs2, 0, Math.max(cs1.length(), cs2.length()));
    } else {
      return false;
    }
  }
  /**
   * CharSequence Region Match given char sequence
   *
   * @author Created by ivan on 5:13 PM 11/30/20.
   * @param cs : Source Char Sequence
   * @param ignoreCase : if ignore case
   * @param thisStart : Start indexer of source string
   * @param substring : Given Char Sequence
   * @param start : Start indexer of given string
   * @param length : Length of Given Char Sequence
   * @return boolean
   */
  public static boolean regionMatches(
      CharSequence cs,
      boolean ignoreCase,
      int thisStart,
      CharSequence substring,
      int start,
      int length) {
    if (cs instanceof String && substring instanceof String) {
      return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
    } else {
      int index1 = thisStart;
      int index2 = start;
      int totalLength = length;

      while (totalLength-- > 0) {
        char c1 = cs.charAt(index1++);
        char c2 = substring.charAt(index2++);
        if (c1 != c2) {
          if (!ignoreCase) {
            return false;
          }

          if (Character.toUpperCase(c1) != Character.toUpperCase(c2)
              && Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
            return false;
          }
        }
      }

      return true;
    }
  }
}
