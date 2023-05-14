package com.stc.library.service.ServiceImplement;

import com.stc.library.dto.responseDTO.ApiResponse;
import com.stc.library.dto.responseDTO.DatChoResponse;
import com.stc.library.entities.DatCho;
import com.stc.library.exception.ResourceNotFoundException;
import com.stc.library.repository.DatChoRepo;
import com.stc.library.service.DatChoService;
import com.stc.library.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatChoServiceImpl implements DatChoService {
    @Autowired
    private DatChoRepo datChoRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Override
    public List<DatCho> getAllDatCho() {
        return datChoRepo.findAll();
    }

    @Override
    public DatChoResponse getDatChoById(String datChoID) throws ResourceNotFoundException {
        DatCho datCho = datChoRepo.findById(datChoID)
                .orElseThrow(() -> new ResourceNotFoundException("DatCho", "datChoID", datChoID));
        return new DatChoResponse(datCho.getId(), datCho.getEmail(), datCho.getThongTinDatChos(),
                datCho.getThoiGian(), datCho.getTrangThaiDatCho(), datCho.isTrangThai());
    }

    @Override
    public DatChoResponse createDatCho(DatCho datCho) {
        datCho.setId(String.valueOf(sequenceGeneratorService.generateSequence(datCho.SEQUENCE_NAME)));
        DatCho newDatCho = datChoRepo.save(datCho);
        return new DatChoResponse(datCho.getId(), datCho.getEmail(), datCho.getThongTinDatChos(),
                datCho.getThoiGian(), datCho.getTrangThaiDatCho(), datCho.isTrangThai());
    }

    @Override
    public DatChoResponse updateDatCho(String datChoID, DatCho datChoDetails) throws ResourceNotFoundException {
        DatCho datCho = datChoRepo.findById(datChoID)
                .orElseThrow(() -> new ResourceNotFoundException("DatCho", "datChoID", datChoID));

        datCho.setEmail(datChoDetails.getEmail());
        datCho.setThongTinDatChos(datChoDetails.getThongTinDatChos());
        datCho.setThoiGian(datChoDetails.getThoiGian());
        datCho.setTrangThaiDatCho(datChoDetails.getTrangThaiDatCho());
        datCho.setTrangThai(datChoDetails.isTrangThai());
        final DatCho updatedDatCho = datChoRepo.save(datCho);
        return new DatChoResponse(datCho.getId(), datCho.getEmail(), datCho.getThongTinDatChos(),
                datCho.getThoiGian(), datCho.getTrangThaiDatCho(), datCho.isTrangThai());
    }

    @Override
    public ApiResponse deleteDatCho(String datChoID) throws ResourceNotFoundException {
        DatCho datCho = datChoRepo.findById(datChoID)
                .orElseThrow(() -> new ResourceNotFoundException("DatCho", "datChoID", datChoID));

        datChoRepo.delete(datCho);
        return new ApiResponse(Boolean.TRUE, "DatCho deleted successfully");
    }
}
