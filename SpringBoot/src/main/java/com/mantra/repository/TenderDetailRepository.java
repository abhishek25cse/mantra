package com.mantra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mantra.domain.Tender;

@Repository
public interface TenderDetailRepository extends MongoRepository<Tender, String> {

}
