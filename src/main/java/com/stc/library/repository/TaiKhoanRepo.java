package com.stc.library.repository;

import com.stc.library.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TaiKhoanRepo extends MongoRepository<TaiKhoan, String> {
    Optional<TaiKhoan> findTaiKhoanByEmail(String email);
}
