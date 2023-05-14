package com.stc.library.service;

import com.stc.library.entities.LoaiSach;
import com.stc.library.exception.ResourceNotFoundException;
import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.LoaiSachResponse;


import java.util.List;

public interface LoaiSachService {
    List<LoaiSach> getAllLoaiSach();

   LoaiSachResponse getLoaiSachById(String loaiSachID) throws ResourceNotFoundException;

    LoaiSachResponse createLoaiSach(LoaiSach loaiSach);

    LoaiSachResponse updateLoaiSach(String loaiSachID, LoaiSach loaiSachDetails) throws ResourceNotFoundException;

    ApiResponse deleteLoaiSach(String loaiSachID) throws ResourceNotFoundException;
}
