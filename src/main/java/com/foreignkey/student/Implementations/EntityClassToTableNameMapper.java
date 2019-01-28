package com.foreignkey.student.Implementations;
import org.hibernate.internal.SessionImpl;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class EntityClassToTableNameMapper {

    @Transactional
    public String[] getTableNames(EntityManager em, Class entityClass) {

        Object entityExample;
        try {
            entityExample = entityClass.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }

        SessionImpl session = em.unwrap(SessionImpl.class);

        EntityPersister persister = session.getEntityPersister(null, entityExample);

        if (persister instanceof AbstractEntityPersister) {
            AbstractEntityPersister persisterImpl = (AbstractEntityPersister) persister;

            String tableName = persisterImpl.getTableName();

            String rootTableName = persisterImpl.getRootTableName();

            return new String[] {rootTableName, tableName};

        } else {
            throw new RuntimeException("Unexpected persister type; a subtype of AbstractEntityPersister expected.");
        }
    }
}