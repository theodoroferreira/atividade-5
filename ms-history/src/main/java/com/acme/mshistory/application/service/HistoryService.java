package com.acme.mshistory.application.service;

import com.acme.mshistory.application.repository.HistoryRepository;
import com.acme.mshistory.domain.dto.HistoryDto;
import com.acme.mshistory.domain.model.History;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository repository;

    public void save(History request) {
        request.setEventDate(LocalDate.now());
        repository.save(request);
    }

    public List<HistoryDto> findAll() {
        List<HistoryDto> dtos;
        List<History> historyList = repository.findAll();
        dtos = historyList.stream().map(history -> HistoryDto.builder()
                .id(history.getId().toString())
                .eventDate(history.getEventDate())
                .orderId(history.getOrderId())
                .build()).collect(Collectors.toList());
        return dtos;
    }

}
