package com.stc.library.service;

import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.TaiKhoanResponse;
import com.stc.library.entities.TaiKhoan;
import com.stc.library.exception.ResourceNotFoundException;

import java.util.List;

public interface TaiKhoanService {
    List<TaiKhoan> getAllTaiKhoan();

    TaiKhoanResponse getTaiKhoanById(String taiKhoanID) throws ResourceNotFoundException;

    TaiKhoanResponse createTaiKhoan(TaiKhoan taiKhoan);

    TaiKhoanResponse updateTaiKhoan(String taiKhoanID, TaiKhoan taiKhoanDetails) throws ResourceNotFoundException;

    ApiResponse deleteTaiKhoan(String taiKhoanID) throws ResourceNotFoundException;
}
