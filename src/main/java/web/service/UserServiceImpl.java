package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements  UserService{
    private final UserDao userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public List<User> index() {
        return userDaoImpl.index();
    }

    @Override
    public User show(int id){
        return userDaoImpl.show(id);
    }

    @Override
    @Transactional
    public void save(User user){ userDaoImpl.save(user); }

    @Override
    @Transactional
    public void update (User user){
        userDaoImpl.update(user);
    }

    @Override
    @Transactional
    public void delete(int id){
        userDaoImpl.delete(id);
    }
}
