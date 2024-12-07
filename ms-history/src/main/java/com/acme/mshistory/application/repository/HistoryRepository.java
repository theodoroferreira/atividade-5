package com.acme.mshistory.application.repository;

import com.acme.mshistory.domain.model.History;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends MongoRepository<History, ObjectId> {
}

