package com.zsdzxw.dzclxt.entity.dto;
import lombok.Data;

/**
 * @apiNote TODO
 * @author zzd
 * @date 2023/5/9 9:10
 */

@Data
public class AliPay {
    private String traceNo;
    private String totalAmount;
    private String subject;
    private String alipayTraceNo;
}

