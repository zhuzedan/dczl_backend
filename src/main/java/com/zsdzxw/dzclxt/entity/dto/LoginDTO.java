package com.zsdzxw.dzclxt.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    /**
     * 用户名
     */
    private String userName;


    /**
     * 用户密码
     */
    private String userPassword;
}
