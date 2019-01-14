package com.foreignkey.student.Models;

//import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public
interface StudentRepo extends CrudRepository <Student,Long> {
/*
Optional <Student> findById ( Long id );

Iterable <Student> findAll ();

Student save ( Student student );

*/

}
