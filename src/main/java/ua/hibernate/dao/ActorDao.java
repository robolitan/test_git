package ua.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.hibernate.model.Actor;

import java.util.Optional;

@Repository
public interface ActorDao extends JpaRepository<Actor, Short> {

    @Override
    <S extends Actor> S save(S s);

    @Override
    Optional<Actor> findById(Short aShort);


}
