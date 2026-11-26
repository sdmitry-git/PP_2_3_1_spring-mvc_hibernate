package springmvc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.dao.UserDAO;
import springmvc.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDao;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
