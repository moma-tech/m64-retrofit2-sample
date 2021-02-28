package com.moma.sample.retrofit2.model.response.fund;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * FundAllResponse
 *
 * <p>//获取所有基金
 *
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
@NoArgsConstructor
@Data
public class FundAllResponse {
  /**
   * code : 200 message : 操作成功 data :
   * [["000001","HXCZHH","华夏成长混合","混合型","HUAXIACHENGZHANGHUNHE"],["000003","ZHKZZZQA","中海可转债债券A","债券型","ZHONGHAIKEZHUANZHAIZHAIQUANA"]]
   */
  private Integer code;

  private String message;
  private List<List<String>> data;
}
