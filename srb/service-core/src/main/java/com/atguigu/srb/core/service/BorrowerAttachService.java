package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.BorrowerAttach;
import com.atguigu.srb.core.pojo.vo.BorrowerAttachVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface BorrowerAttachService extends IService<BorrowerAttach> {
    List<BorrowerAttachVO> selectBorrowerAttachVOList(Long borrowerId);
}
