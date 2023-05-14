package com.stc.library.service.ServiceImplement;

import com.stc.library.entities.LoaiSach;
import com.stc.library.exception.BadRequestException;
import com.stc.library.exception.ResourceNotFoundException;
import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.LoaiSachResponse;
import com.stc.library.repository.LoaiSachRepo;
import com.stc.library.service.LoaiSachService;
import com.stc.library.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiSachServiceImpl implements LoaiSachService {
    @Autowired
    private LoaiSachRepo loaiSachRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public List<LoaiSach> getAllLoaiSach() {
        return loaiSachRepo.findAll();
    }

    @Override
    public LoaiSachResponse getLoaiSachById(String loaiSachID) throws ResourceNotFoundException {
        LoaiSach loaiSach = loaiSachRepo.findById(loaiSachID)
                .orElseThrow(() -> new ResourceNotFoundException("LoaiSach", "loaiSachID", loaiSachID));
        return new LoaiSachResponse(loaiSach.getId(), loaiSach.getMaLoaiSach(),
                loaiSach.getTenLoaiSach(), loaiSach.isTrangThai());
    }

    @Override
    public LoaiSachResponse createLoaiSach(LoaiSach loaiSach) {
        Optional<LoaiSach> loaiSachByMaLoaiSach = loaiSachRepo.
                findLoaiSachByMaLoaiSach(loaiSach.getMaLoaiSach());
        if (loaiSachByMaLoaiSach.isPresent()) {
            throw new BadRequestException("Mã Loại Sách đã tồn tại! Vui lòng nhập giá trị khác!");
        }
        loaiSach.setId(String.valueOf(sequenceGeneratorService.generateSequence(LoaiSach.SEQUENCE_NAME)));
        LoaiSach newLoaiSach = loaiSachRepo.save(loaiSach);
        return new LoaiSachResponse(newLoaiSach.getId(), newLoaiSach.getMaLoaiSach(),
                newLoaiSach.getTenLoaiSach(), newLoaiSach.isTrangThai());
    }

    @Override
    public LoaiSachResponse updateLoaiSach(String loaiSachID, LoaiSach loaiSachDetails) throws ResourceNotFoundException {
        LoaiSach loaiSach = loaiSachRepo.findById(loaiSachID)
                .orElseThrow(() -> new ResourceNotFoundException("LoaiSach", "loaiSachID", loaiSachID));

        loaiSach.setMaLoaiSach(loaiSachDetails.getMaLoaiSach());
        loaiSach.setTenLoaiSach(loaiSachDetails.getTenLoaiSach());
        loaiSach.setTrangThai(loaiSachDetails.isTrangThai());
        final LoaiSach updatedLoaiSach = loaiSachRepo.save(loaiSach);
        return new LoaiSachResponse(updatedLoaiSach.getId(), updatedLoaiSach.getMaLoaiSach(),
                updatedLoaiSach.getTenLoaiSach(), updatedLoaiSach.isTrangThai());
    }

    @Override
    public ApiResponse deleteLoaiSach(String loaiSachID) throws ResourceNotFoundException {
        LoaiSach loaiSach = loaiSachRepo.findById(loaiSachID)
                .orElseThrow(() -> new ResourceNotFoundException("LoaiSach", "loaiSachID", loaiSachID));

        loaiSachRepo.delete(loaiSach);
        return new ApiResponse(Boolean.TRUE, "LoaiSach deleted successfully");
    }
}
