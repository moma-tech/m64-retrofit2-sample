package com.moma.sample.retrofit2.model.params.fund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * FundInfoParams
 *
 * <p>获取基金基础信息 Param
 *
 * @version 1.0
 * @author Created by Ivan at 2021/2/28.
 */
@Data
@Builder
@AllArgsConstructor
public class FundInfoParams implements java.io.Serializable {

  private static final long serialVersionUID = -4491982669097036941L;
  /** 基金代码(必填)逗号隔开支持多个查询 */
  private String code;
}
