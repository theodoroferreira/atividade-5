package com.acme.ms_order.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @CPF(message = "CPF inválido")
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
}
