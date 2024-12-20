package com.acme.msorder.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerDto {

    private Long orderId;
    private String cpf;
}
