package com.tekion.approval.repo;

//import org.springframework.data.repository.CrudRepository;

import com.tekion.approval.Models.ApprovalTaskTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public
interface ApprovalTaskTableRepo extends CrudRepository <ApprovalTaskTable,Long> {
  //  void deleteById ( Student id );
/*
Optional <Student> findById ( Long id );

Iterable <Student> findAll ();

Student save ( Student student );

*/

}
