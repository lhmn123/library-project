package com.stc.library.repository;

import com.stc.library.entities.LoaiSach;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoaiSachRepo extends MongoRepository<LoaiSach, String> {
    Optional<LoaiSach> findLoaiSachByMaLoaiSach(String maLoaiSach);
}
