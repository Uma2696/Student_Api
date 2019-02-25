package com.tekion.approval.repo;

import com.tekion.approval.Models.ApprovalTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalTableRepo extends CrudRepository <ApprovalTable, Long> {

   // void deleteById ( Long id );
}