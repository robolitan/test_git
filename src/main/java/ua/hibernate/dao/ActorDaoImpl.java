package ua.hibernate.dao;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.QueryHints;
import org.hibernate.dialect.Dialect;
import org.hibernate.jpa.AvailableSettings;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.hibernate.interseptor.CustomActorInterceptor;
import ua.hibernate.model.Actor;

import javax.persistence.*;
import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ActorDaoImpl {
    @Autowired
    EntityManager entityManager;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public void saveActor(Actor actor){
        entityManager.persist(actor);
    }

    public Optional<Actor> getActorById(Short id) throws SQLException {
        System.out.println(entityManager);
        Session unwrap = entityManager.unwrap(Session.class);


        NativeQuery justForTest = unwrap.getNamedNativeQuery("justForTest");
        Actor actor = (Actor) justForTest
                .setParameter("actor_id", id)
                .addEntity(Actor.class)
                .getSingleResult();
        return Optional.of(actor);
    }

    public void addImageToActor(Actor actor, String filename) {
        entityManager.merge(actor);
        entityManager.close();
        System.out.println(entityManager);

    }

    public void updateActorName(Short id, String name) {
        Map<String, Object> hints = new HashMap<>();
        hints.put("java.persistence.lock.timeout", 1);
        Actor actor = entityManager.find(Actor.class,
                id,
                LockModeType.PESSIMISTIC_WRITE,
                hints);
        System.out.println("*****************" + actor.getClass());
        actor.setLast_name(name);
    }
}
