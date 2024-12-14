package com.acme.msorder.application.service;

import com.acme.msorder.application.repository.OrderRepository;
import com.acme.msorder.domain.dto.OrderDto;
import com.acme.msorder.domain.dto.ProducerDto;
import com.acme.msorder.domain.model.Item;
import com.acme.msorder.domain.model.Order;
import com.acme.msorder.framework.event.TopicProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final ObjectMapper objectMapper;
    private final TopicProducer producer;
    private final ModelMapper mapper;

    public OrderDto create(OrderDto request) throws JsonProcessingException {
        Order order = mapper.map(request, Order.class);
        this.validateDates(order);
        repository.save(order);
        ProducerDto orderProducer = mapper.map(order, ProducerDto.class);
        log.info("## Dados enviados pelo cliente :{}", orderProducer);

        String message = objectMapper.writeValueAsString(orderProducer);

        producer.sendMessage(message);
        log.info("## Pedido retornado pela API de CEP: {}", orderProducer);
        return mapper.map(order, OrderDto.class);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    private void validateDates(Order order) {
        List<Item> items = order.getItems();
        for (Item item : items) {
            if (item.getExpirationDate().isBefore(item.getCreationDate())) {
                throw new RuntimeException(
                        "A data de expiração não pode ser anterior à data de criação."
                );
            }
        }
    }
}
