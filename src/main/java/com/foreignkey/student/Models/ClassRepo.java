package com.foreignkey.student.Models;

import org.springframework.data.repository.CrudRepository;

public interface ClassRepo extends CrudRepository <Class, Long> {

   // void deleteById ( Long id );
}