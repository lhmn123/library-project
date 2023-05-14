package com.stc.library.service;


import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.DatChoResponse;
import com.stc.library.entities.DatCho;
import com.stc.library.exception.ResourceNotFoundException;

import java.util.List;

public interface DatChoService {
    List<DatCho> getAllDatCho();

    DatChoResponse getDatChoById(String datChoID) throws ResourceNotFoundException;

    DatChoResponse createDatCho(DatCho datCho);

    DatChoResponse updateDatCho(String datChoID, DatCho datChoDetails) throws ResourceNotFoundException;

    ApiResponse deleteDatCho(String datChoID) throws ResourceNotFoundException;
}
