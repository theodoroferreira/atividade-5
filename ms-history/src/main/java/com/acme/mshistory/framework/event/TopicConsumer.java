package com.acme.mshistory.framework.event;

import com.acme.mshistory.application.service.HistoryService;
import com.acme.mshistory.domain.model.History;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TopicConsumer {

    private final HistoryService service;

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${spring.kafka.topic.order-history}", groupId = "${spring.kafka.consumer.group-id}")
    public void getTopicConsumer(String message) throws JsonProcessingException {
        log.info("Mensagem Histórico {}", message);

        History history = objectMapper.readValue(message, History.class);

        service.save(history);
        log.info("Order salvo na base com sucesso: {}", history);
    }
}