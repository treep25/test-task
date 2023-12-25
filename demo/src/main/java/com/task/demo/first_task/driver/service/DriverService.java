package com.task.demo.first_task.driver.service;

import com.task.demo.first_task.driver.DriverMapper;
import com.task.demo.first_task.driver.model.Driver;
import com.task.demo.first_task.driver.model.DriverDto;
import com.task.demo.first_task.driver.model.DriverRequestForUpdate;
import com.task.demo.first_task.driver.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    public Driver create(DriverDto driverDto) {
        return driverRepository.save(
                driverMapper.convertToDriver(driverDto)
        );
    }

    public List<Driver> get() {
        return driverRepository.findAll();
    }

    public Driver getById(long id) {
        return driverRepository.findById(id).orElseThrow(() -> new RuntimeException("There are no such driver with id " + id));
    }

    public Driver update(DriverRequestForUpdate driverForUpdate, long id) {
        getById(id);

        Driver driver = Driver.builder().build();

        if(driverForUpdate.getName() != null && !driverForUpdate.getName().isBlank() && !driverForUpdate.getName().isEmpty()){
            driver.setName(driverForUpdate.getName());
        }
        if(driverForUpdate.getAge() >17){
            driver.setAge(driverForUpdate.getAge());
        }

        return driverRepository.save(driver);
    }

    public void delete(long id) {
        getById(id);

        driverRepository.deleteById(id);
    }
}
