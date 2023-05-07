package com.zsdzxw.dzclxt.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    @JsonAlias("user_name")
    private String userName;

    @JsonAlias("user_password")
    private String userPassword;

    @JsonAlias("user_tele")
    private String userTele;

    @JsonAlias("user_type")
    private Integer userType;

}
