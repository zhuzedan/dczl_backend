package com.zsdzxw.dzclxt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppraiseDTO {

    private Long id;

    private Long userId;

    private Long orderId;

    private Long bikeId;

    private String appraiseDescripition;

    private Integer appraiseStar;

}
