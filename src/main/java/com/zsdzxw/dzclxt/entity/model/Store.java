package com.zsdzxw.dzclxt.entity.model;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author :zzd
 * @apiNote :门店表(Store)实体类
 * @date :2023-05-07 09:15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("dczlxt_store")
public class Store implements Serializable {
    @TableId
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "门店名字")
    private String storeName;

    @ApiModelProperty(value = "联系人电话")
    private String contactPhone;

    @ApiModelProperty(value = "联系人名字")
    private String contactName;

    @ApiModelProperty(value = "门店描述")
    private String description;

    @ApiModelProperty(value = "状态1可用，0停用")
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @TableLogic
    @ApiModelProperty(value = "删除标志0没删1删了")
    private Integer isDeleted;

}
