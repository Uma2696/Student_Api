package com.foreignkey.student.Controller;

import com.foreignkey.student.Implementations.ClassDAO;
import com.foreignkey.student.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public
class ClassController {
    @Autowired
    private ClassDAO classDAO;

    @GetMapping("/student")
    @ResponseBody
    public
    List <Student> getClasses () {

        return (List <Student>) classDAO.findAll( );
    }

    @GetMapping("/student/{id}")
    @ResponseBody
    public
    Student getStudentById ( @PathVariable Long id ) {

        return classDAO.findById(id);
    }

    @PostMapping("/save")
    public
    Student createStudent ( @RequestBody Student student ) {
        return classDAO.save(student);


    }

    @PutMapping("/student/{id}")
    public
    void modifyStudentById ( @PathVariable("id") Long id, @Valid @RequestBody Student student) {
        student.setId(id);
    }


    @DeleteMapping("/{id}")
    public
    void deleteStudent( @PathVariable Long id ) {

        classDAO.delete(id);
    }
}

