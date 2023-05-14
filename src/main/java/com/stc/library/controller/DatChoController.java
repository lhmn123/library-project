package com.stc.library.controller;

import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.DatChoResponse;
import com.stc.library.entities.DatCho;
import com.stc.library.exception.BadRequestException;
import com.stc.library.exception.ResourceNotFoundException;
import com.stc.library.service.DatChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DatChoController {
    @Autowired
    private DatChoService datChoService;

    @GetMapping("/datChos")
    public List<DatCho> getAlldatChos() {
        List<DatCho> datChos = datChoService.getAllDatCho();
        return datChos;
    }

    @GetMapping("/datCho/{id}")
    public ResponseEntity<DatChoResponse> getDatChoById(@PathVariable(value = "id") String datChoID) throws ResourceNotFoundException {
        DatChoResponse datChoResponse = datChoService.getDatChoById(datChoID);
        return new ResponseEntity<>(datChoResponse, HttpStatus.OK);
    }

    @PostMapping("/datCho")
    public ResponseEntity<DatChoResponse> createDatCho(@Valid @RequestBody DatCho datCho) throws BadRequestException {
        DatChoResponse datChoResponse = datChoService.createDatCho(datCho);
        return new ResponseEntity<>(datChoResponse, HttpStatus.OK);
    }

    @PutMapping("/datCho/{id}")
    public ResponseEntity<DatChoResponse> updateDatCho(@PathVariable(value = "id") String datChoID,
                                                                 @Valid @RequestBody DatCho datChoDetails) throws ResourceNotFoundException {
        DatChoResponse datChoResponse = datChoService.updateDatCho(datChoID, datChoDetails);
        return new ResponseEntity<>(datChoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/datCho/{id}")
    public ResponseEntity<ApiResponse> deleteDatCho(@PathVariable(value = "id") String datChoID)
            throws ResourceNotFoundException {
        ApiResponse apiResponse = datChoService.deleteDatCho(datChoID);
        return new ResponseEntity< >(apiResponse, HttpStatus.OK);
    }

}
