package imooc.service.impl;

import imooc.dao.UserDao;
import imooc.dao.impl.UserDaoImpl;
import imooc.domain.User;
import imooc.service.UserService;
import imooc.utils.MailUtils;

import java.sql.SQLException;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/06
 **/
public class UserServiceImpl implements UserService {
    @Override
    public boolean register(User user) throws Exception {
        UserDaoImpl userDao = new UserDaoImpl();
        boolean result = userDao.register(user);
        if (result){
            MailUtils.sendEmail(user.getEmail(), user.getCode());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User findByCode(String code) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDaoImpl();
        return userDao.findByCode(code);
    }

    @Override
    public void update(User user) throws Exception {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }
}
