package com.foreignkey.student.Implementations;

import com.foreignkey.student.Models.ClassRepo;
import com.foreignkey.student.Models.Student;
import com.foreignkey.student.Models.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public
class ClassDAOImpl implements ClassDAO {
    final static Logger logger = LoggerFactory.getLogger(ClassDAOImpl.class);


    @Autowired
    ClassRepo classRepo;
    @Autowired
    StudentRepo studentRepo;

    @Override
    public
    Student findById ( Long id ) {

        Optional <Student> optional = studentRepo.findById(id);
        return optional.orElse(null);
    }

    @Override
    public
    List <Student> findAll () {
        return (List <Student>) studentRepo.findAll( );
    }

    @Override
    public
    Student save (Student student ) {

        return studentRepo.save(student);
    }

    @Override
    public
    void delete ( Long id ) {
        classRepo.deleteById(id);
    }
}

