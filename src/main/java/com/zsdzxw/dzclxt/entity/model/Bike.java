package com.zsdzxw.dzclxt.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dczlxt_bike")
public class Bike implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 电动车名称
     */
    private String bikeName;

    /**
     * 电动车价格
     */
    private Long bikeCost;

    /**
     * 电动车保险价格
     */
    private Long bikeInsure;


    /**
     * 电动车图片存放地址
     */
    private String bikeUrl;

    /**
     * 电动车状态(1-正常、2-易损、3-维修、4-报废)
     */
    private int bikeStatus;

    /**
     * 接入时间
     */
    private Date insertTime;

}
