package com.stc.library.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "loai-sach")
public class LoaiSach {
    @Transient
    public static final String SEQUENCE_NAME = "loaiSach_sequence";
    @Id
    private String id;

    // mã không được trùng
    private String maLoaiSach;

    private String tenLoaiSach;

    private boolean trangThai = true;
}
