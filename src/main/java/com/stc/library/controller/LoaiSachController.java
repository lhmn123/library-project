package com.stc.library.controller;

import com.stc.library.entities.LoaiSach;
import com.stc.library.exception.BadRequestException;
import com.stc.library.exception.ResourceNotFoundException;
import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.LoaiSachResponse;
import com.stc.library.service.LoaiSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class LoaiSachController {
    @Autowired
    private LoaiSachService loaiSachService;

    @GetMapping("/loaiSachs")
    public List<LoaiSach> getAllLoaiSach() {
        List<LoaiSach> loaiSachs = loaiSachService.getAllLoaiSach();
        return loaiSachs;
    }

    @GetMapping("/loaiSach/{id}")
    public ResponseEntity<LoaiSachResponse> getLoaiSachById(@PathVariable(value = "id") String loaiSachID) throws ResourceNotFoundException {
        LoaiSachResponse loaiSach = loaiSachService.getLoaiSachById(loaiSachID);
        return new ResponseEntity<>(loaiSach, HttpStatus.OK);
    }

    @PostMapping("/loaiSach")
    public ResponseEntity<LoaiSachResponse> createLoaiSach(@Valid @RequestBody LoaiSach loaiSach) throws BadRequestException {
        LoaiSachResponse loaiSachResponse = loaiSachService.createLoaiSach(loaiSach);
        return new ResponseEntity<>(loaiSachResponse, HttpStatus.OK);
    }

    @PutMapping("/loaiSach/{id}")
    public ResponseEntity<LoaiSachResponse> updateLoaiSach(@PathVariable(value = "id") String loaiSachID,
                                                              @Valid @RequestBody LoaiSach loaiSachDetails) throws ResourceNotFoundException {
        LoaiSachResponse loaiSachResponse = loaiSachService.updateLoaiSach(loaiSachID, loaiSachDetails);
        return new ResponseEntity<>(loaiSachResponse, HttpStatus.OK);
    }

    @DeleteMapping("/loaiSach/{id}")
    public ResponseEntity<ApiResponse> deleteLoaiSach(@PathVariable(value = "id") String loaiSachID)
            throws ResourceNotFoundException {
        ApiResponse apiResponse = loaiSachService.deleteLoaiSach(loaiSachID);
        return new ResponseEntity< >(apiResponse, HttpStatus.OK);
    }

}
