package com.stc.library.service.ServiceImplement;
import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.TaiKhoanResponse;
import com.stc.library.entities.TaiKhoan;
import com.stc.library.exception.BadRequestException;
import com.stc.library.exception.ResourceNotFoundException;
import com.stc.library.repository.TaiKhoanRepo;
import com.stc.library.service.SequenceGeneratorService;
import com.stc.library.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanRepo.findAll();
    }

    @Override
    public TaiKhoanResponse getTaiKhoanById(String taiKhoanID) throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepo.findById(taiKhoanID)
                .orElseThrow(() -> new ResourceNotFoundException("TaiKhoan", "taiKhoanID", taiKhoanID));
        return new TaiKhoanResponse(taiKhoan.getId(), taiKhoan.getName(), taiKhoan.getEmail(),
                taiKhoan.getPassword(), taiKhoan.getDienThoai(), taiKhoan.getRoles(), taiKhoan.isTrangThai());
    }

    @Override
    public TaiKhoanResponse createTaiKhoan(TaiKhoan taiKhoan) {
        Optional<TaiKhoan> taiKhoanByEmail = taiKhoanRepo.
                findTaiKhoanByEmail(taiKhoan.getEmail());
        if (taiKhoanByEmail.isPresent()) {
            throw new BadRequestException("Email đã tồn tại! Vui lòng nhập giá trị khác!");
        }
        taiKhoan.setId(String.valueOf(sequenceGeneratorService.generateSequence(taiKhoan.SEQUENCE_NAME)));
        TaiKhoan newTaiKhoan = taiKhoanRepo.save(taiKhoan);
        return new TaiKhoanResponse(newTaiKhoan.getId(), newTaiKhoan.getName(), newTaiKhoan.getEmail(),
                newTaiKhoan.getPassword(), newTaiKhoan.getDienThoai(), newTaiKhoan.getRoles(), newTaiKhoan.isTrangThai());
    }

    @Override
    public TaiKhoanResponse updateTaiKhoan(String taiKhoanID, TaiKhoan taiKhoanDetails) throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepo.findById(taiKhoanID)
                .orElseThrow(() -> new ResourceNotFoundException("TaiKhoan", "taikhoanID", taiKhoanID));

        taiKhoan.setName(taiKhoanDetails.getName());
        taiKhoan.setEmail(taiKhoanDetails.getEmail());
        taiKhoan.setPassword(taiKhoanDetails.getPassword());
        taiKhoan.setDienThoai(taiKhoanDetails.getDienThoai());
        taiKhoan.setRoles(taiKhoanDetails.getRoles());
        taiKhoan.setTrangThai(taiKhoanDetails.isTrangThai());
        final TaiKhoan updatedTaiKhoan = taiKhoanRepo.save(taiKhoan);
        return new TaiKhoanResponse(updatedTaiKhoan.getId(), updatedTaiKhoan.getName(), updatedTaiKhoan.getEmail(),
                updatedTaiKhoan.getPassword(), updatedTaiKhoan.getDienThoai(), updatedTaiKhoan.getRoles(), updatedTaiKhoan.isTrangThai());
    }

    @Override
    public ApiResponse deleteTaiKhoan(String taiKhoanID) throws ResourceNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepo.findById(taiKhoanID)
                .orElseThrow(() -> new ResourceNotFoundException("TaiKhoan", "taikhoanID", taiKhoanID));

        taiKhoanRepo.delete(taiKhoan);
        return new ApiResponse(Boolean.TRUE, "TaiKhoan deleted successfully");
    }
}
