package com.zsdzxw.dzclxt.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dczlxt_appraise")
public class Appraise implements Serializable {

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
     * 订单id
     */
    private Long orderId;

    /**
     * 评价描述
     */
    private String appraiseDescription;

    /**
     * 评价星级（1-5星）
     */
    private Integer appraiseStar;

}
