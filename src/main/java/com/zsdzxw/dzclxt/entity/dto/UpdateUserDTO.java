package com.zsdzxw.dzclxt.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserDTO {

    @JsonAlias("id")
    private Long id;

    @JsonAlias("user_name")
    private String userName;

    @JsonAlias("user_password")
    private String userPassword;

    @JsonAlias("user_tele")
    private String userTele;

    @JsonAlias("user_status")
    private Integer userStatus;

    @JsonAlias("user_type")
    private Integer userType;

    @JsonAlias("user_allowence")
    private Long userAllowence;
}
