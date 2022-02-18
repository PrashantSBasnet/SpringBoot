package com.example.demo.service.impl;

import com.example.demo.CustomMessageSource;
import com.example.demo.dto.CarsDto;
import com.example.demo.entity.Cars;
import com.example.demo.entity.Model;
import com.example.demo.entity.Person;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CarsRepo;
import com.example.demo.repository.ModelRepo;
import com.example.demo.repository.PersonRepo;
import com.example.demo.service.CarsService;
import lombok.RequiredArgsConstructor;;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
@RequiredArgsConstructor
@Component
public class CarsServiceImpl implements CarsService {

    private final   CustomMessageSource customMessageSource;
    private final CarsRepo carsRepo;
    private final ModelRepo modelRepo;
    private final PersonRepo personRepo;

    @Override
    public Map<String, Object> findById(Integer id) {
        return null;
    }

    @Override
    public List<CarsDto> findByStatus(Integer status) {
        return null;
    }

    @Override
    public CarsDto save(CarsDto dto) throws Exception {
        Cars cars; //because repo gives entity
        Model model;
        Person person;


        if (dto.getId() != null && dto.getId() != 0) {
            cars = carsRepo.findById(dto.getId()).orElseThrow(() -> new NotFoundException(
                    customMessageSource.get("invalid.id", customMessageSource.get("cars")
                    )
            ));
        }
        else {
            cars = new Cars();
        }

        cars.setId(dto.getId());
        cars.setName(dto.getName());


        model =modelRepo.findById(dto.getModelId()).orElseThrow(
                ()-> new NotFoundException(customMessageSource.get("invalid.id", customMessageSource.get("model")))
        );

        cars.setModel(model);

        person = personRepo.findById(dto.getPersonId()).orElseThrow(
                ()-> new NotFoundException(customMessageSource.get("invalid.id", customMessageSource.get("person")))
        );

       // cars.setPerson(person);

        carsRepo.save(cars);

        return new CarsDto(cars);
    }

    @Override
    public List<CarsDto> findByName(String name) {
        List<Cars> carsList = carsRepo.findByName(name);
        return CarsDto.builder().build().toDto(carsList);

    }


}
