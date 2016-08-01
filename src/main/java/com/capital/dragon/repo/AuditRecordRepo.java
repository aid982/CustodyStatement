package com.capital.dragon.repo;

import org.springframework.data.repository.CrudRepository;

import com.capital.dragon.model.AuditRecord;

public interface AuditRecordRepo extends CrudRepository<AuditRecord, Long>{
	

}
