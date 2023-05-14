package com.stc.library.service;

import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.DichVuResponse;
import com.stc.library.entities.DichVu;
import com.stc.library.exception.ResourceNotFoundException;

import java.util.List;

public interface DichVuService {
    List<DichVu> getAllDichVu();

    DichVuResponse getDichVuById(String dichVuID) throws ResourceNotFoundException;

    DichVuResponse createDichVu(DichVu dichVu);

    DichVuResponse updateDichVu(String dichVuID, DichVu dichVuDetails) throws ResourceNotFoundException;

    ApiResponse deleteDichVu(String dichVuID) throws ResourceNotFoundException;
}
