package ads.servlets;

import ads.Ad;
import ads.AdsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Moravia on 12/8/16.
 */
@WebServlet(name = "CreateServlet", urlPatterns = "/ads/create")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // validate the inputs from the form

        String title = request.getParameter("title");
        String body = request.getParameter("body");

        // create a new Ad object
        Ad ad = new Ad(title, body);

        // create an AdsDAO object
        AdsDAO adsDAO = null;
        try {
            // create new AdsDAO to create connection
            adsDAO = new AdsDAO();

            // call save method on AdsDAO passing it the given Ad object
            adsDAO.add(ad);

            // return to view
            response.sendRedirect("/ads");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }
}


