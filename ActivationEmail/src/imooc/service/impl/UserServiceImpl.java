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
    public void register(User user) throws Exception {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.register(user);
        MailUtils.sendEmail(user.getEmail(), user.getCode());
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
