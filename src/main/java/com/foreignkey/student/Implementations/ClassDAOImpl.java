package com.foreignkey.student.Implementations;

import com.foreignkey.student.Models.ClassRepo;
import com.foreignkey.student.Models.Student;
import com.foreignkey.student.Models.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public
class ClassDAOImpl implements ClassDAO {
    final static Logger logger = LoggerFactory.getLogger(ClassDAOImpl.class);


    @Autowired
    ClassRepo classRepo;
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    EntityManager em;

    @Autowired
    EntityClassToTableNameMapper tableNameMapperService;


    @PostConstruct
    void init () {
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        Set <BeanDefinition> beanDefinitions = scanner.findCandidateComponents("com.foreignkey.student");
        @SuppressWarnings("unchecked")
        List <String> tableList = (List <String>) em.createNativeQuery("SHOW TABLES").getResultList( );
        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
                Class clazz = Class.forName(beanDefinition.getBeanClassName( ));
                String[] tableNameResult = tableNameMapperService.getTableNames(em, clazz);
                boolean matched = false;
                for (String tableName : tableList) {
                    if (tableName.equals(tableNameResult[0])) {
                        matched = true;
                        break;
                    }
                }
                if (!matched) {
                    //log this and be silent or throw and crash
                    System.out.println("TABLE NOT FOUND FOR SOME CLASS " + clazz.getSimpleName( ));
                    throw new AssertionError("TABLE NOT FOUND");
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace( );
            }

        }


    }


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
    Student save ( Student student ) {

        Student result = studentRepo.save(student);
        if (result == null) {
            throw new AssertionError("Table not found");
        }
        return result;
    }

    @Override
    public
    void delete ( Long id ) {
        studentRepo.deleteById(id);
    }
}

