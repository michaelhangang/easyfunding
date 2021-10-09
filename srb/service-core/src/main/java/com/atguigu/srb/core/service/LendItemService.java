package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.LendItem;
import com.atguigu.srb.core.pojo.vo.InvestVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface LendItemService extends IService<LendItem> {
    void notify(Map<String, Object> paramMap);
    String commitInvest(InvestVO investVO);
    List<LendItem> selectByLendId(Long lendId);
    List<LendItem> selectByLendId(Long lendId, Integer status);
}
