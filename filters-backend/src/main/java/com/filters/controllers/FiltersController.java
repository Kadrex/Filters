package com.filters.controllers;

import com.filters.service.FilterService;
import com.filters.to.FilterTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class FiltersController {

    @Autowired
    private FilterService service;

    @GetMapping(value = "/getFilters")
    public ResponseEntity<List<FilterTO>> getFilters() {
        return ResponseEntity.of(Optional.ofNullable(service.getFilters()));
    }

    @PostMapping(value = "saveFilter")
    public ResponseEntity<FilterTO> saveFilter(@RequestBody FilterTO filter) {
        return ResponseEntity.ok(service.saveFilter(filter));
    }

}
