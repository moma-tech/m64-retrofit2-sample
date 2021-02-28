package com.moma.sample.retrofit2.model.params.fund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * FundPositionParams
 *
 * <p>//获取基金持仓详情
 *
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
@Data
@Builder
@AllArgsConstructor
public class FundPositionParams implements java.io.Serializable {
  private static final long serialVersionUID = -3430029330463850460L;
  /** 基金代码(必填) */
  private String code;
}
