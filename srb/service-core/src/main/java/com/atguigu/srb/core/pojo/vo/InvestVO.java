package com.atguigu.srb.core.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "投标信息")
public class InvestVO {

    private Long lendId;

    private String investAmount;

    private Long investUserId;

    private String investName;
}
