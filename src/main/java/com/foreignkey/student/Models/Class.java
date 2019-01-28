package com.foreignkey.student.Models;

import javax.persistence.*;


@Entity
@Table(schema = "MYSCHEMA")
public
class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "section",unique = true)
    private String section;


    public
    Long getId () {
        return id;
    }

    public
    void setId ( Long id ) {
        this.id = id;
    }

    public
    String getSection () {
        return section;
    }

    public
    void setSection ( String section ) {
        this.section = section;
    }


}