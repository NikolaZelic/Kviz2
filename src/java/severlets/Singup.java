package severlets;

import Baza.DB;
import Baza.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Singup", urlPatterns = {"/singup"})
public class Singup extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("json;charset=UTF-8");
        StringBuilder result = new StringBuilder("{\"success\":\"");
        
        // Reading request's parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Check parameters
        if(username==null ||password==null)
            return;
        username = username.trim();
        password = password.trim();
        if(username.isEmpty()||password.isEmpty())
            return;
        
        // Search DB for user
        List<Korisnik> list = DB.query("SELECT k FROM Korisnik k WHERE k.korUsername='"+username+"'");
        
        // PROCESSING USER
        if(list.isEmpty())  // There isn't user with searched username
        {
            // Create new user
            Korisnik k = new Korisnik();
            k.setKorUsername(username);
            k.setKorPassword(password);
            DB.insert(k);
            result.append("true\"");
        }
        else
        {
            result.append("false\"");
        }
        result.append("}");
        
        try (PrintWriter out = response.getWriter()) {
            out.println(result);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
