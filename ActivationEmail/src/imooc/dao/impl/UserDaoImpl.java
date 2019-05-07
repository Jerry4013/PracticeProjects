package imooc.dao.impl;

import imooc.dao.UserDao;
import imooc.domain.User;

import java.sql.*;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/06
 **/
public class UserDaoImpl implements UserDao {

    @Override
    public void register(User user) throws SQLException, ClassNotFoundException {

        Connection connection = getConnection();
        PreparedStatement statement;

        System.out.println("Opened database successfully");

        try {
            String sql="insert into hmail.userinfo(username, password,nickname," +
                    "email,state,code) values(?,?,?,?,?,?)";
            statement = getPreparedStatement(user, connection, sql);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByCode(String code) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement statement;
        String sql = "SELECT * FROM hmail.userinfo WHERE code = ? ";
        statement = connection.prepareStatement(sql);
        statement.setString(1, code);
        ResultSet resultSet = statement.executeQuery();
        User user = new User();
        while (resultSet.next()){
            user.setUid(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setNickname(resultSet.getString(4));
            user.setEmail(resultSet.getString(5));
            user.setState(resultSet.getInt(6));
            user.setCode(resultSet.getString(7));
        }
        statement.close();
        connection.close();
        return user;
    }

    @Override
    public void update(User user) throws Exception {
        Connection connection = getConnection();
        PreparedStatement statement;
        String sql = "UPDATE hmail.userinfo SET username = ?, password = ?, nickname = ?, email = ?, state = ?, code " +
                "= ? WHERE uid = ?";
        statement = getPreparedStatement(user, connection, sql);
        statement.setObject(7, user.getUid());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    private PreparedStatement getPreparedStatement(User user, Connection connection, String sql) throws SQLException {
        PreparedStatement statement;
        statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getNickname());
        statement.setString(4, user.getEmail());
        statement.setInt(5, user.getState());
        statement.setString(6, user.getCode());
        return statement;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/hmail";
        String username = "postgres";
        String password = "postgres";
        Connection connection;
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

}
