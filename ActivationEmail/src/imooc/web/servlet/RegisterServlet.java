package imooc.web.servlet;

import imooc.domain.User;
import imooc.service.UserService;
import imooc.service.impl.UserServiceImpl;
import imooc.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nickname = request.getParameter("nickname");
            String email = request.getParameter("email");

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            user.setEmail(email);
            user.setState(0); // 0: Unactivated; 1: Activated
            String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
            user.setCode(code);

            UserService userService = new UserServiceImpl();
            userService.register(user);

            request.setAttribute("msg", "Welcome to Jerry's Website! Please go to your email to activate your " +
                    "account!");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
