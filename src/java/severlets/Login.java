package severlets;

import Baza.DB;
import Baza.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("json;charset=UTF-8");
        StringBuilder result = new StringBuilder("{");
        
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
            result.append("\"username\":\"false\",\"password\":\"false\"");
        }
        else
        {
            result.append("\"username\":\"true\",\"password\":\"");
            
            Korisnik tek = (Korisnik)list.get(0);
            String tekPas = tek.getKorPassword();
            if(password.equals(tekPas))
                result.append("true");
            else
                result.append("false");
            
            result.append("\"");
        }
        result.append("}");
        
        try (PrintWriter out = response.getWriter()) {
            out.println(result);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
