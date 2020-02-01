package com.ke.mall.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
/**
 * @version v1
 * @author liuyangxing
 * @since 2020/1/18
 * @summary
 **/
public class PmsBrand implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "品牌名称")
    private String name;

    @ApiModelProperty(value = "首字母")
    private String firstLetter;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;

    @ApiModelProperty(value = "是否品牌制造商，1是，0不是")
    private Byte factoryStatus;

    @ApiModelProperty(value = "展示状态1展示，0不展示")
    private Byte showStatus;

    @ApiModelProperty(value = "产品数量")
    private Integer proCount;

    @ApiModelProperty(value = "产品评论数量")
    private Integer commentCount;

    @ApiModelProperty(value = "品牌logo")
    private String logo;

    @ApiModelProperty(value = "图片地址")
    private String picLoc;

    @ApiModelProperty(value = "品牌故事")
    private String brandStory;

    @ApiModelProperty(value = "创建时间")
    private Date ctime;

    @ApiModelProperty(value = "状态，1有效，0无效")
    private Byte state;
}