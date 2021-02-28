package com.moma.sample.retrofit2.service.fund;

import com.moma.sample.retrofit2.caller.HttpMethodConstants;
import com.moma.sample.retrofit2.caller.fund.ApiURIConstants;
import com.moma.sample.retrofit2.caller.fund.FundApiCaller;
import com.moma.sample.retrofit2.model.params.fund.*;
import com.moma.sample.retrofit2.model.response.fund.*;
import org.springframework.stereotype.Service;

/**
 * FundApiServiceImpl
 *
 * <p>Use caller to do request
 *
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
@Service
public class FundApiServiceImpl implements FundApiService {

  @Override
  public FundAllResponse getFundAllResponse(FundAllParams fundAllParams) {
    FundAllResponse fundAllResponse = null;
    try {
      fundAllResponse =
          FundApiCaller.getResponse(
              HttpMethodConstants.GET,
              ApiURIConstants.FUND_ALL,
              fundAllParams,
              FundAllResponse.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fundAllResponse;
  }

  @Override
  public FundHotResponse getFundHotResponse(FundHotParams fundHotParams) {
    FundHotResponse fundHotResponse = null;
    try {
      fundHotResponse =
          FundApiCaller.getResponse(
              HttpMethodConstants.GET,
              ApiURIConstants.FUND_HOT,
              fundHotParams,
              FundHotResponse.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fundHotResponse;
  }

  @Override
  public FundInfoResponse getFundInfoResponse(FundInfoParams fundInfoParams) {
    FundInfoResponse fundInfoResponse = null;
    try {
      fundInfoResponse =
          FundApiCaller.getResponse(
              HttpMethodConstants.GET,
              ApiURIConstants.FUND_INFO,
              fundInfoParams,
              FundInfoResponse.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fundInfoResponse;
  }

  @Override
  public FundPositionResponse getFundPositionResponse(FundPositionParams fundPositionParams) {
    FundPositionResponse fundPositionResponse = null;
    try {
      fundPositionResponse =
          FundApiCaller.getResponse(
              HttpMethodConstants.GET,
              ApiURIConstants.FUND_POSITION,
              fundPositionParams,
              FundPositionResponse.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fundPositionResponse;
  }

  @Override
  public FundRankResponse getFundRankResponse(FundRankParams fundRankParams) {
    FundRankResponse fundRankResponse = null;
    try {
      fundRankResponse =
          FundApiCaller.getResponse(
              HttpMethodConstants.GET,
              ApiURIConstants.FUND_RANK,
              fundRankParams,
              FundRankResponse.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fundRankResponse;
  }

  @Override
  public MonetaryFundDetailResponse getMonetaryFundDetailResponse(
      FundDetailParams fundDetailParams) {
    MonetaryFundDetailResponse monetaryFundDetailResponse = null;
    try {
      monetaryFundDetailResponse =
          FundApiCaller.getResponse(
              HttpMethodConstants.GET,
              ApiURIConstants.FUND_DETAIL,
              fundDetailParams,
              MonetaryFundDetailResponse.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return monetaryFundDetailResponse;
  }

  @Override
  public NonMonetaryFundDetailResponse getNonMonetaryFundDetailResponse(
      FundDetailParams fundDetailParams) {
    NonMonetaryFundDetailResponse nonMonetaryFundDetailResponse = null;
    try {
      nonMonetaryFundDetailResponse =
          FundApiCaller.getResponse(
              HttpMethodConstants.GET,
              ApiURIConstants.FUND_DETAIL,
              fundDetailParams,
              NonMonetaryFundDetailResponse.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nonMonetaryFundDetailResponse;
  }
}
