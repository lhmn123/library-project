package com.stc.library.entities;

import com.stc.library.entities.embedded.ThongTinDatCho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dat-cho")
public class DatCho {
    @Transient
    public static final String SEQUENCE_NAME = "datCho_sequence";
    @Id
    private String id;

    // email người đặt chỗ
    private String email;

    private List<ThongTinDatCho> thongTinDatChos = new ArrayList<>();

    // Thời gian đặt phòng họp nhóm
    private Date thoiGian;

    // lấy từ enum trạng thái đặt chỗ
    private String trangThaiDatCho;

    private boolean trangThai = true;
}
