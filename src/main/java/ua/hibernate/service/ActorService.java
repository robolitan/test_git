package ua.hibernate.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hibernate.dao.ActorDao;
import ua.hibernate.dao.ActorDaoImpl;
import ua.hibernate.model.Actor;

import java.sql.SQLException;

@Service
@AllArgsConstructor
@Transactional
public class ActorService {
    ActorDao actorDao;
    ActorDaoImpl actorDaoImpl;

    public Actor getActor(Short id){
        return actorDao.findById(id).orElseGet(Actor::new);
    }

    public Actor getActorById(Short id) throws SQLException {
        return actorDaoImpl.getActorById(id).orElseGet(Actor::new);
    }

    public void addImageToActor(Actor actor, String filename){
        actorDaoImpl.addImageToActor(actor, filename);
    }

    public void updateActorName(Short id, String name){
        actorDaoImpl.updateActorName(id, name);
    }

    public void saveActor(Actor actor){
        actorDaoImpl.saveActor(actor);
    }
}
