package web.dao;

import web.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> index() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
    @Override
    public User show(int id){
        return em.find(User.class,id);
    }
    @Transactional
    @Override
    public void save(User user){

        em.persist(user);
    }
    @Transactional
    @Override
    public void update (User user){
        em.merge(user);
    }
    @Transactional
    @Override
    public void delete(int id){
        em.remove(show(id));
    }
}
