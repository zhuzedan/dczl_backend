package com.zsdzxw.dzclxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsdzxw.dzclxt.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户名或者电话和密码进行登录
     *
     * @param userName 用户名
     * @param userPassword 密码
     * @return
     */
    @Select("select * from dczlxt_user where (user_name = #{user_name} or user_tele = #{user_name}) and user_password = #{user_password} limit 1")
    User getUserByNameOrTeleAndPassword(
            @Param("user_name") String userName,
            @Param("user_password") String userPassword);

    /**
     * 获取全部用户信息
     *
     * @return
     */
    @Select("select * from dczlxt_user ")
    List<User> getAllUser();

    /**
     * 获取分页用户信息
     *
     * @return
     */
    @Select("select * from dczlxt_user limit #{pageNo},#{pageSize}")
    List<User> getPageUser(@Param("pageNo") Integer pageNo , @Param("pageSize") Integer pageSize);

    /**
     * 获取单条用户信息
     *
     * @return
     */
    @Select("select * from dczlxt_user where id = #{user_id} limit 1")
    User getUserById(@Param("user_id") Long userId);
}
