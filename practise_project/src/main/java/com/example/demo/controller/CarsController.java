package com.example.demo.controller;

import com.example.demo.dto.CarsDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CarsRepo;
import com.example.demo.service.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarsController {

    private final CarsService carsService;

    private final CarsRepo carsRepo;


    @GetMapping("/list/{status}")
    public ResponseEntity<?> findAll(@PathVariable("status") Integer status) throws Exception {
        List<CarsDto> dtoList = carsService.findByStatus(status);
        return ResponseEntity.ok(("carlistfound"));
    }


    @GetMapping("/list-by-name")
    public ResponseEntity<?> findByName(@RequestParam String name) throws Exception {
        List<CarsDto> dtoList = carsService.findByName(name);
        return ResponseEntity.ok(("carlistfoundbyname"));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody CarsDto carsDto ) throws Exception {
        try {
            carsDto = carsService.save(carsDto);
        } catch (NotFoundException e) {
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("saved");
    }
}
