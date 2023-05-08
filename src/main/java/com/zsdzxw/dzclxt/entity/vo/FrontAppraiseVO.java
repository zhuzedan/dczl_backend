package com.zsdzxw.dzclxt.entity.vo;

import com.zsdzxw.dzclxt.entity.model.Appraise;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @apiNote TODO
 * @author zzd
 * @date 2023/5/8 10:19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FrontAppraiseVO extends Appraise {
    private String userName;

    private String bikeName;
    private String bikeUrl;
}
