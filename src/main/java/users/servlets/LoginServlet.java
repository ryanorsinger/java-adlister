package users.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Moravia on 12/5/16.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost   (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sessionMessage = "";
        boolean isValidLogin;

        HttpSession session = request.getSession();

        isValidLogin = username.equals("username") && password.equals("password");

        if(isValidLogin) {
            sessionMessage = "User logged in successfully";
            session.setAttribute("message", sessionMessage);

            // show new ad creation
            response.sendRedirect("/ads/create");
        } else {
            // write a message to the session
            sessionMessage = "Please check your username or password";
            session.setAttribute("message", sessionMessage);

            // add a check on login.jsp to output the session message if it exists
            // send back home
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/users/login.jsp")
                .forward(request, response);
    }
}
