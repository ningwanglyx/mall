package com.ke.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ke.mall.service.IStringRedisService;
import com.ke.mall.service.IUmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.constraints.Size;
import java.util.Random;

/**
 * @Summary: 会员管理Service实现
 * @Author: YangxingLiu
 * @Since: 2020/1/19 15:00
 */
@Service
@Slf4j
public class UmsMemberService implements IUmsMemberService {
    @Autowired
    private IStringRedisService stringRedisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public JSONObject generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for(int i = 0; i < 6; i++){
            sb.append(r.nextInt(10));
        }
        stringRedisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        stringRedisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        JSONObject res = new JSONObject();
        res.put("authCode", sb.toString());
        res.put("message", "获取验证码成功");
        res.put("code", 1);
        return res;
    }
    //对输入的验证码进行校验
    @Override
    public JSONObject verifyAuthCode(String telephone, String authCode) {
        Assert.state(telephone != null && authCode != null, "参数不能为空");
        String check = stringRedisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        Boolean res = authCode.equals(check);
        JSONObject jsonObject = new JSONObject();
        if(res){
            jsonObject.put("message", "校验验证码成功");
            jsonObject.put("code", 1);
            return jsonObject;
        }
        jsonObject.put("message", "验证码不正确");
        jsonObject.put("code", -1);
        return jsonObject;
    }
}
