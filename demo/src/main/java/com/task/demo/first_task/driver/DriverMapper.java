package com.task.demo.first_task.driver;

import com.task.demo.first_task.driver.model.Driver;
import com.task.demo.first_task.driver.model.DriverDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DriverMapper {

    private final ModelMapper modelMapper;

    public Driver convertToDriver(DriverDto driverDto) {
        return modelMapper.map(driverDto, Driver.class);
    }

    public DriverDto convertToDriverDto(Driver driver) {
        return modelMapper.map(driver, DriverDto.class);
    }

    public List<DriverDto> convertDriversToUserDtoes(List<Driver> drivers) {
        return drivers.stream()
                .map(this::convertToDriverDto)
                .collect(Collectors.toList());
    }
}
