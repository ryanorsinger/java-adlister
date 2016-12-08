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
import java.util.Arrays;
import java.util.List;

/**
 * Created by Moravia on 12/8/16.
 */
@WebServlet(name = "IndexServlet", urlPatterns = "/ads")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdsDAO adsDAO = new AdsDAO();
            List<Ad> all = adsDAO.all();
            request.setAttribute("ads", all);

            System.out.println(Arrays.toString(all.toArray()));

            // Return the /ads/index.jsp view
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp")
                    .forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
