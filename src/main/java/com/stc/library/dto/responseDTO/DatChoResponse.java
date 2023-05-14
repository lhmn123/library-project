package com.stc.library.dto.responseDTO;

import com.stc.library.entities.embedded.ThongTinDatCho;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class DatChoResponse {
    private String id;

    // email người đặt chỗ
    private String email;

    private List<ThongTinDatCho> thongTinDatChos = new ArrayList<>();

    // Thời gian chăm sóc thú cưng
    private Date thoiGian;

    // lấy từ enum trạng thái đặt chỗ
    private String trangThaiDatCho;

    private boolean trangThai = true;

    public DatChoResponse(String id, String email, List<ThongTinDatCho> thongTinDatChos, Date thoiGian, String trangThaiDatCho, boolean trangThai) {
        this.id = id;
        this.email = email;
        this.thongTinDatChos = thongTinDatChos;
        this.thoiGian = thoiGian;
        this.trangThaiDatCho = trangThaiDatCho;
        this.trangThai = trangThai;
    }
}
