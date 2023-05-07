package com.zsdzxw.dzclxt.entity.vo;

import com.zsdzxw.dzclxt.entity.model.Bike;
import com.zsdzxw.dzclxt.entity.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderVO extends Order {


    private String startTimeStr;

    private String endTimeStr;


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

    /**
     * 评价描述
     */
    private String appraiseDescription;

    /**
     * 评价星级（1-5星）
     */
    private int appraiseStar;



}
