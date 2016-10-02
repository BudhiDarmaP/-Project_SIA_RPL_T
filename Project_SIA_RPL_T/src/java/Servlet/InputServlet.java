package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lycorice
 */
public class InputServlet extends HttpServlet {
@Override
    protected void doGet (HttpServletRequest request, HttpServletResponse respone)
            throws ServletException, IOException {
        try {
            DataAdmin dataAdmin = new DataAdmin();
            DataAdmin2 dataAdmin2 = new DataAdmin2();
            ArrayList<Admin> adminList = dataAdmin.list();
            ArrayList<Mahasiswa> adminList2 = dataAdmin2.list();
            request.setAttribute("adminList", adminList);
            request.setAttribute("adminList2", adminList2);
            request.getRequestDispatcher("admin.jsp").forward(request, respone);
        } catch (SQLException ex) {
            throw new ServletException("Cannot obtain products from DB", ex);
        }
    }
}
