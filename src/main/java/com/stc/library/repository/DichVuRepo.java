package com.stc.library.repository;

import com.stc.library.entities.DichVu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DichVuRepo extends MongoRepository<DichVu, String> {
    Optional<DichVu> findDichVuByMaDichVu(String maDichVu);
}
