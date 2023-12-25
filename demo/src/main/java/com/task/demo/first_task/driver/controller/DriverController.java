package com.task.demo.first_task.driver.controller;

import com.task.demo.first_task.driver.DriverMapper;
import com.task.demo.first_task.driver.model.DriverDto;
import com.task.demo.first_task.driver.model.DriverRequestForUpdate;
import com.task.demo.first_task.driver.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor
@Validated
public class DriverController {

    private final DriverService driverService;
    private final DriverMapper driverMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DriverDto driverDto) {

        return new ResponseEntity<>(driverMapper.convertToDriverDto(driverService.create(driverDto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(driverMapper.convertDriversToUserDtoes(driverService.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        if (id > 0) {
            return ResponseEntity.ok(driverMapper.convertToDriverDto(driverService.getById(id)));
        }
        return ResponseEntity.internalServerError().body("id is not correct");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DriverRequestForUpdate driverForUpdate, @PathVariable long id) {
        if (id > 0) {
            if (driverForUpdate != null) {
                return ResponseEntity.ok(driverMapper.convertToDriverDto(driverService.update(driverForUpdate, id)));
            }
            return ResponseEntity.internalServerError().body("Body is not present");
        }
        return ResponseEntity.internalServerError().body("id is not correct");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (id > 0) {
            driverService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.internalServerError().body("id is not correct");
    }
}
