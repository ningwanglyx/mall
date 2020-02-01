package com.ke.mall.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Summary: 会员管理Service接口
 * @Author: YangxingLiu
 * @Since: 2020/1/19 14:53
 */
public interface IUmsMemberService {
    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    JSONObject generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    JSONObject verifyAuthCode(String telephone, String authCode);
}
