package imooc.dao;

import imooc.domain.User;

import java.sql.SQLException;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/06
 **/

public interface UserDao {

    void register(User user) throws Exception;

    User findByCode(String code) throws SQLException, ClassNotFoundException;

    void update(User user)throws Exception;
}
