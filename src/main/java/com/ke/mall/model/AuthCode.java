package com.ke.mall.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Summary: 验证码对象
 * @Author: YangxingLiu
 * @Since: 2020/1/19 15:27
 */
@Data
public class AuthCode implements Serializable {
    @NotEmpty
    @ApiModelProperty(value = "验证码")
    private String authCode;
    @NotEmpty
    @ApiModelProperty(value = "手机号")
    private String telephone;

    public AuthCode(String authCode, String telephone){
        this.authCode = authCode;
        this.telephone = telephone;
    }

    public AuthCode(){

    }

    @Override
    public String toString() {
        return "AuthCode{" +
                "authCode='" + authCode + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
