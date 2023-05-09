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
@TableName(value = "dczlxt_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 自增主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 电动车id
     */
    private Long bikeId;

    /**
     * 结束时间
     */
    private String startLocation;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束地点
     */
    private String endLocation;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 行驶距离
     */
    private Long mileage;

    /**
     * 订单费用
     */
    private Long orderCost;

    /**
     * 订单状态(0-完成，1-异常终止，2-取消订单)
     */
    private int orderStatus;

    private String paymentTime;

    private String alipayNo;

}
