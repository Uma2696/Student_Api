package com.foreignkey.student.Models;

import javax.persistence.*;


//@Entity
//@Table(name = "student")

@Entity
public
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "roll_no")
    private String rollNo;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Class aClass;

    public
    Long getId () {
        return id;
    }

    public
    void setId ( Long id ) {
        this.id = id;
    }

    public
    String getStudentName () {
        return studentName;
    }

    public
    void setStudentName ( String studentName ) {
        this.studentName = studentName;
    }

    public
    String getRollNo () {
        return rollNo;
    }

    public
    void setRollNo ( String rollNo ) {
        this.rollNo = rollNo;
    }

    public
    Class getaClass () {
        return aClass;
    }

    public
    void setaClass ( Class aClass ) {
        this.aClass = aClass;
    }
}