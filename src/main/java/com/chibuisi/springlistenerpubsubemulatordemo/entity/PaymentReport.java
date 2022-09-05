package com.chibuisi.springlistenerpubsubemulatordemo.entity;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PaymentReport {
    private Long id;
    private String email;
    private String currentPrice;
}
