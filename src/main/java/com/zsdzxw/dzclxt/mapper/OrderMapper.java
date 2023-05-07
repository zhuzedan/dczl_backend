package com.zsdzxw.dzclxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsdzxw.dzclxt.entity.model.Order;

import com.zsdzxw.dzclxt.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 通过用户ID获取订单
     *
     * @param userId
     * @return
     */
    @Select("select * from dczlxt_order where user_id = #{user_id} limit #{pageNo},#{pageSize}")
    List<Order> getOrdersByUserId(@Param("user_id") Long userId , @Param("pageNo") Integer pageNo , @Param("pageSize") Integer pageSize);

    /**
     * 通过自行车ID获取订单
     *
     * @param bikeId
     * @return
     */
    @Select("select * from dczlxt_order where bike_id = #{bike_id}")
    List<Order> getOrdersByBikeId(@Param("bike_id") Long bikeId);

    /**
     * 获取分页订单信息
     *
     * @return
     */
    @Select("select * from dczlxt_order limit #{pageNo},#{pageSize}")
    List<Order> getPageOrder(@Param("pageNo") Integer pageNo , @Param("pageSize") Integer pageSize);

    @Select("select * from dczlxt_order")
    List<Order> getAllOrder();

    @Select("select * from dczlxt_order where user_id = #{userId}")
    List<Order> getAllOrdersByUserId(@Param("userId") Long userId);

}
