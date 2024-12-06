package com.acme.mshistory.application.service;

import com.acme.mshistory.application.repository.HistoryRepository;
import com.acme.mshistory.domain.model.History;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository repository;

    public History save(History request) {
        request.setEventDate(LocalDate.now());
        return repository.save(request);
    }

    public List<History> findAll() {
        return repository.findAll();
    }

}
