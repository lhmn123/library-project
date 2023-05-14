package com.stc.library.dto.responseDTO;

import com.stc.library.entities.embedded.GiaDichVu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DichVuResponse {
    private String id;

    // mã dịch vụ không được trùng
    private String maDichVu;

    private String tenDichVu;

    // nội dung là html
    private String noiDung;

    // Giá dịch vụ bị phụ thu nếu trả sách chậm trễ hoặc hư hỏng sách đã mượn
    private List<GiaDichVu> giaDichVus = new ArrayList<>();

    private boolean trangThai = true;

    public DichVuResponse(String id, String maDichVu, String tenDichVu, String noiDung, List<GiaDichVu> giaDichVus, boolean trangThai) {
        this.id = id;
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.noiDung = noiDung;
        this.giaDichVus = giaDichVus;
        this.trangThai = trangThai;
    }
}
