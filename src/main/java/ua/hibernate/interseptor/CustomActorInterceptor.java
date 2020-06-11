package ua.hibernate.interseptor;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomActorInterceptor extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("IN INTERCEPTOR");
        super.onSave(entity, id, state, propertyNames, types);
        return false;
    }
}
