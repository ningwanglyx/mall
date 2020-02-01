package com.ke.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @version v1
 * @author liuyangxing
 * @since 2020/2/1
 * @summary 红包记录表model
 **/
public class RedPacket implements Serializable {
    @ApiModelProperty(value = "红包主键")
    private Integer id;

    @ApiModelProperty(value = "发红包用户id")
    private Integer userId;

    @ApiModelProperty(value = "红包总金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "发放时间")
    private Date sendDate;

    @ApiModelProperty(value = "红包总数")
    private Integer total;

    @ApiModelProperty(value = "单个红包金额")
    private BigDecimal perAmount;

    @ApiModelProperty(value = "剩余红包数")
    private Integer stock;

    @ApiModelProperty(value = "版本")
    private Integer version;

    @ApiModelProperty(value = "备注")
    private String note;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BigDecimal getPerAmount() {
        return perAmount;
    }

    public void setPerAmount(BigDecimal perAmount) {
        this.perAmount = perAmount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}