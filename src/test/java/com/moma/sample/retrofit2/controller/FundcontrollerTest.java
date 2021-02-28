package com.moma.sample.retrofit2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FundcontrollerTest {
  @LocalServerPort private int port;

  @Autowired private TestRestTemplate restTemplate;

  @Test
  void getFundAllResponse() {
    String result =
        this.restTemplate.getForObject("http://127.0.0.1:" + port + "/m64/fund/all", String.class);
    System.out.println(result);
  }

  @Test
  void getFundHotResponse() {}

  @Test
  void getFundInfoResponse() {
    String result =
            this.restTemplate.getForObject("http://127.0.0.1:" + port + "/m64/fund/info?code=000001", String.class);
    System.out.println(result);
  }

  @Test
  void getFundPositionResponse() {}

  @Test
  void getFundRankResponse() {}

  @Test
  void getMonetaryFundDetailResponse() {}

  @Test
  void getNonMonetaryFundDetailResponse() {}
}
