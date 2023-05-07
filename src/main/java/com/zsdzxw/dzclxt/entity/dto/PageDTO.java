package com.zsdzxw.dzclxt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO {

    private Integer pageNo;

    private Integer pageSize;
}
