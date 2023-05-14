package com.stc.library.repository;

import com.stc.library.entities.DatCho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatChoRepo extends MongoRepository<DatCho, String> {

}
