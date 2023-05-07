package com.zsdzxw.dzclxt.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.zsdzxw.dzclxt.entity.model.Bike;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BikeDTO {

    @JsonAlias("bike_name")
    private String bikeName;

    @JsonAlias("bike_cost")
    private Long bikeCost;

    @JsonAlias("bike_insure")
    private Long bikeInsure;

}
