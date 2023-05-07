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
@TableName(value = "dczlxt_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户电话
     */
    private String userTele;

    /**
     * 用户类型(1-用户，2-管理员)
     */
    private int userType;

    /**
     * 上次登录时间
     */
    private Date lastLogin;

    /**
     * 用户余额
     */
    private Long userAllowence;

    /**
     * 用户状态(0-信用好，1-信用较好，2-信用较差，3-无信用)
     */
    private int userStatus;

}
