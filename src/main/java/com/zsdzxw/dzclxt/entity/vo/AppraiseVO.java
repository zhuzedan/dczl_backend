package com.zsdzxw.dzclxt.entity.vo;

import com.zsdzxw.dzclxt.entity.model.Appraise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppraiseVO extends Appraise {

    private String userName;

    private String bikeName;
}
