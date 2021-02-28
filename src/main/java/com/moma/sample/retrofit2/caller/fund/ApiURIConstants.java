package com.moma.sample.retrofit2.caller.fund;

/**
 * UrlConstants
 *
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
public interface ApiURIConstants {
  String BASE_URL = "https://api.doctorxiong.club";
  /** 获取基金基础信息 */
  String FUND_INFO = "/v1/fund";
  /** 获取基金持仓详情 */
  String FUND_POSITION = "/v1/fund/position";
  /** 获取基金排行 */
  String FUND_RANK = "/v1/fund/rank";
  /** 获取基金详情 */
  String FUND_DETAIL = "/v1/fund/detail";
  /** 获取所有基金 */
  String FUND_ALL = "/v1/fund/all";
  /** 获取热门基金 */
  String FUND_HOT = "/v1/fund/hot";
}
