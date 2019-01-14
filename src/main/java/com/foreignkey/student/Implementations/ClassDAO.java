package com.foreignkey.student.Implementations;

import com.foreignkey.student.Models.Student;

public interface ClassDAO {


    Student findById ( Long id );

    Object findAll ();

    Student save ( Student student );


    void delete ( Long id );
}
