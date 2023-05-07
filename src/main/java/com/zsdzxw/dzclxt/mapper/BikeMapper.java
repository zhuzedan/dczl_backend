package com.zsdzxw.dzclxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsdzxw.dzclxt.entity.model.Bike;
import com.zsdzxw.dzclxt.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface BikeMapper extends BaseMapper<Bike> {

    /**
     * 获取全部电动车信息
     *
     * @return
     */
    @Select("select * from dczlxt_bike ")
    List<Bike> getAllBike();

    /**
     * 获取分页用电动车信息
     *
     * @return
     */
    @Select("select * from dczlxt_bike limit #{pageNo},#{pageSize}")
    List<Bike> getPageBike(@Param("pageNo") Integer pageNo , @Param("pageSize") Integer pageSize);

    /**
     * 获取单个电动车详情
     *
     * @return
     */
    @Select("select * from dczlxt_bike where id = #{bikeId} limit 1")
    Bike getBikeById(@Param("bikeId") Long bikeId);

}
