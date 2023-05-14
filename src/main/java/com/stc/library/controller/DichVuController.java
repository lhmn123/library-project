package com.stc.library.controller;

import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.DichVuResponse;
import com.stc.library.entities.DichVu;
import com.stc.library.exception.BadRequestException;
import com.stc.library.exception.ResourceNotFoundException;
import com.stc.library.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;
    @GetMapping("/dichVus")
    public List<DichVu> getAllDichVu() {
        List<DichVu> dichVus = dichVuService.getAllDichVu();
        return dichVus;
    }
    @GetMapping("/dichVu/{id}")
    public ResponseEntity<DichVuResponse> getDichVuById(@PathVariable(value = "id") String dichVuID) throws ResourceNotFoundException {
        DichVuResponse dichVuResponse = dichVuService.getDichVuById(dichVuID);
        return new ResponseEntity<>(dichVuResponse, HttpStatus.OK);
    }

    @PostMapping("/dichVu")
    public ResponseEntity<DichVuResponse> createDichVu(@Valid @RequestBody DichVu dichVu) throws BadRequestException {
        DichVuResponse dichVuResponse = dichVuService.createDichVu(dichVu);
        return new ResponseEntity<>(dichVuResponse, HttpStatus.OK);
    }
    @PutMapping("/dichVu/{id}")
    public ResponseEntity<DichVuResponse> updateDichVu(@PathVariable(value = "id") String dichVuID,
                                                                 @Valid @RequestBody DichVu dichVuDetails) throws ResourceNotFoundException {
        DichVuResponse dichVuResponse = dichVuService.updateDichVu(dichVuID, dichVuDetails);
        return new ResponseEntity<>(dichVuResponse, HttpStatus.OK);
    }

    @DeleteMapping("/dichVu/{id}")
    public ResponseEntity<ApiResponse> deleteDichVu(@PathVariable(value = "id") String dichVuID)
            throws ResourceNotFoundException {
        ApiResponse apiResponse = dichVuService.deleteDichVu(dichVuID);
        return new ResponseEntity< >(apiResponse, HttpStatus.OK);
    }
}
