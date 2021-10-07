package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.BorrowInfo;
import com.atguigu.srb.core.pojo.entity.Lend;
import com.atguigu.srb.core.pojo.vo.BorrowInfoApprovalVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface LendService extends IService<Lend> {
    void createLend(BorrowInfoApprovalVO borrowInfoApprovalVO, BorrowInfo borrowInfo);

    List<Lend> selectList();

    Map<String, Object> getLendDetail(Long id);
}
