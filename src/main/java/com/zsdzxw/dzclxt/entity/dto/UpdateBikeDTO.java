package com.zsdzxw.dzclxt.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBikeDTO {

    @JsonAlias("id")
    private Long id;

    @JsonAlias("bike_name")
    private String bikeName;

    @JsonAlias("bike_cost")
    private Long bikeCost;

    @JsonAlias("bike_insure")
    private Long bikeInsure;

    @JsonAlias("bike_status")
    private Integer bikeStatus;

    @JsonAlias("bike_url")
    private String bikeUrl;

}
