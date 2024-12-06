package com.acme.mshistory.framework.controller;

import com.acme.mshistory.application.service.HistoryService;
import com.acme.mshistory.domain.model.History;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService service;

    @GetMapping
    public ResponseEntity<List<History>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}