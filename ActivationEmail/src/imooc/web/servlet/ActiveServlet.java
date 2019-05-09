package imooc.web.servlet;

import imooc.domain.User;
import imooc.service.UserService;
import imooc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ActiveServlet")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        UserService userService = new UserServiceImpl();
        try {
            User user = userService.findByCode(code);
            if (user != null) {
                user.setState(1);
                user.setCode(null);
                userService.update(user);
                request.setAttribute("msg", "Activation Complete! Your account activation has been completed " +
                        "successfully.");
            }else {
                request.setAttribute("msg", "Your activation code seems is not correct. Please activate again.");
            }
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
