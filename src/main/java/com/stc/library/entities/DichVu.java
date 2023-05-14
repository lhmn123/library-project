package com.stc.library.entities;

import com.stc.library.entities.embedded.GiaDichVu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dich-vu")
public class DichVu {
    @Transient
    public static final String SEQUENCE_NAME = "dichVu_sequence";
    @Id
    private String id;

    // mã dịch vụ không được trùng
    private String maDichVu;


    private String tenDichVu;

    // nội dung là html
    private String noiDung;

    // Giá dịch vụ bị phụ thu nếu trả sách chậm trễ hoặc hư hỏng sách đã mượn
    private List<GiaDichVu> giaDichVus = new ArrayList<>();

    private boolean trangThai = true;
}
