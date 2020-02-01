package com.ke.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @version v1
 * @author liuyangxing
 * @since 2020/2/1
 * @summary 抢红包记录表model
 **/
public class UserRedPacket implements Serializable {
    @ApiModelProperty(value = "抢红包主键id")
    private Integer id;

    @ApiModelProperty(value = "红包主键id")
    private Integer redPacketId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "抢红包金额")
    private BigDecimal perAmount;

    @ApiModelProperty(value = "抢红包时间")
    private Date grabTime;

    @ApiModelProperty(value = "备注")
    private String note;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRedPacketId() {
        return redPacketId;
    }

    public void setRedPacketId(Integer redPacketId) {
        this.redPacketId = redPacketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getPerAmount() {
        return perAmount;
    }

    public void setPerAmount(BigDecimal perAmount) {
        this.perAmount = perAmount;
    }

    public Date getGrabTime() {
        return grabTime;
    }

    public void setGrabTime(Date grabTime) {
        this.grabTime = grabTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}