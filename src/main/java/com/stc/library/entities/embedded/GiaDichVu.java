package com.stc.library.entities.embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiaDichVu {
    // Id loại sách
    private String loaiSach;

    // Lỗi vi pham
    private String loiViPham;

    private double gia;

}
