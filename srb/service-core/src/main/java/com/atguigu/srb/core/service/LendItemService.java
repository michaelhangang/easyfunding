package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.LendItem;
import com.atguigu.srb.core.pojo.vo.InvestVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface LendItemService extends IService<LendItem> {
    void notify(Map<String, Object> paramMap);
    String commitInvest(InvestVO investVO);
}
