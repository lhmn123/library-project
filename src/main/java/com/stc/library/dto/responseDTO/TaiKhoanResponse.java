package com.stc.library.dto.responseDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TaiKhoanResponse {
    private String id;

    private String name;

    // email không được trùng nhau
    private String email;

    @JsonIgnore
    private String password;

    private String dienThoai;

    private List<String> roles = new ArrayList<>();

    private boolean trangThai;

    public TaiKhoanResponse(String id, String name, String email, String password, String dienThoai, List<String> roles, boolean trangThai) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dienThoai = dienThoai;
        this.roles = roles;
        this.trangThai = trangThai;
    }
}
