package com.zsdzxw.dzclxt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @apiNote TODO
 * @author zzd
 * @date 2023/5/7 20:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeFilterDto extends PageDTO{
    private String lowPrice;
    private String highPrice;
}
