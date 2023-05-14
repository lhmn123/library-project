package com.stc.library.dto.responseDTO;

import lombok.Data;

@Data
public class LoaiSachResponse {
    private String id;

    private String maLoaiSach;

    private String tenLoaiSach;

    private boolean trangThai;

    public LoaiSachResponse(String id, String maLoaiSach, String tenLoaiSach, boolean trangThai) {
        this.id = id;
        this.maLoaiSach = maLoaiSach;
        this.tenLoaiSach = tenLoaiSach;
        this.trangThai = trangThai;
    }
}
