package com.zsdzxw.dzclxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsdzxw.dzclxt.entity.model.Appraise;
import com.zsdzxw.dzclxt.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface AppraiseMapper extends BaseMapper<Appraise> {

    /**
     * 获取全部评价
     *
     * @return
     */
    @Select("select * from dczlxt_appraise ")
    List<Appraise> getAllAppraise();

    /**
     * 通过用户ID获取订单评价
     *
     * @param userId 用户ID
     * @return
     */
    @Select("select * from dczlxt_appraise where user_id = #{user_id}")
    List<Appraise> getAppraisesByUserId(@Param("user_id") Long userId);

    /**
     * 通过订单ID获取订单评价
     *
     * @param
     * @return
     */
    @Select("select * from dczlxt_appraise where order_id = #{order_id} limit 1")
    Appraise getAppraisesByOrderId(@Param("order_id") Long orderId);

    /**
     * 通过自行车ID获取订单评价
     *
     * @param bikeId 自行车ID
     * @return
     */
    @Select("select * from dczlxt_appraise where bike_id = #{bike_id}")
    List<Appraise> getAppraisesByBikeId(@Param("bike_id") Long bikeId);

    /**
     * 获取分页评价信息
     *
     * @return
     */
    @Select("select * from dczlxt_appraise limit #{pageNo},#{pageSize}")
    List<Appraise> getPageAppraise(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

}
