package com.moma.sample.retrofit2.controller;

import com.moma.sample.retrofit2.model.params.fund.*;
import com.moma.sample.retrofit2.model.response.fund.*;
import com.moma.sample.retrofit2.service.fund.FundApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fundcontroller
 *
 * @author Ivan
 * @version 1.0 Created by Ivan at 2021/2/28.
 */
@RestController
@RequestMapping("/fund")
public class Fundcontroller {
  @Autowired FundApiService fundApiService;

  /** 获取所有基金 */
  @GetMapping(value = "/all")
  FundAllResponse getFundAllResponse(FundAllParams fundAllParams) {
    return fundApiService.getFundAllResponse(fundAllParams);
  }
  /** 获取热门基金 */
  @GetMapping(value = "/hot")
  FundHotResponse getFundHotResponse(FundHotParams fundHotParams) {
    return fundApiService.getFundHotResponse(fundHotParams);
  }
  /** 获取基金基础信息 */
  @GetMapping(value = "/info")
  FundInfoResponse getFundInfoResponse(FundInfoParams fundInfoParams) {
    return fundApiService.getFundInfoResponse(fundInfoParams);
  }
  /** 获取基金持仓详情 */
  @GetMapping(value = "/postion")
  FundPositionResponse getFundPositionResponse(FundPositionParams fundPositionParams) {
    return fundApiService.getFundPositionResponse(fundPositionParams);
  }
  /** 获取基金排行 */
  @GetMapping(value = "/rank")
  FundRankResponse getFundRankResponse(FundRankParams fundRankParams) {
    return fundApiService.getFundRankResponse(fundRankParams);
  }
  /** 获取基金详情(货币) */
  @GetMapping(value = "/monerary")
  MonetaryFundDetailResponse getMonetaryFundDetailResponse(FundDetailParams fundDetailParams) {
    return fundApiService.getMonetaryFundDetailResponse(fundDetailParams);
  }
  /** 获取基金详情(非货币) */
  @GetMapping(value = "/nonmonetary")
  NonMonetaryFundDetailResponse getNonMonetaryFundDetailResponse(
      FundDetailParams fundDetailParams) {
    return fundApiService.getNonMonetaryFundDetailResponse(fundDetailParams);
  }
}
