package com.moma.sample.retrofit2.service.fund;

import com.moma.sample.retrofit2.model.params.fund.*;
import com.moma.sample.retrofit2.model.response.fund.*;

/**
 * FundApiService
 *
 * <p>Service
 *
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
public interface FundApiService {
  /** 获取所有基金 */
  FundAllResponse getFundAllResponse(FundAllParams fundAllParams);
  /** 获取热门基金 */
  FundHotResponse getFundHotResponse(FundHotParams fundHotParams);
  /** 获取基金基础信息 */
  FundInfoResponse getFundInfoResponse(FundInfoParams fundInfoParams);
  /** 获取基金持仓详情 */
  FundPositionResponse getFundPositionResponse(FundPositionParams fundPositionParams);
  /** 获取基金排行 */
  FundRankResponse getFundRankResponse(FundRankParams fundRankParams);
  /** 获取基金详情(货币) */
  MonetaryFundDetailResponse getMonetaryFundDetailResponse(FundDetailParams fundDetailParams);
  /** 获取基金详情(非货币) */
  NonMonetaryFundDetailResponse getNonMonetaryFundDetailResponse(FundDetailParams fundDetailParams);
}
