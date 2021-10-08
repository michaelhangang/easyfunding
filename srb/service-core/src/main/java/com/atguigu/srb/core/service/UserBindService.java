package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.UserBind;
import com.atguigu.srb.core.pojo.vo.UserBindVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface UserBindService extends IService<UserBind> {
    String commitBindUser(UserBindVO userBindVO, Long userId);
    String getBindCodeByUserId(Long userId);
    void notify(Map<String, Object> paramMap);
}
