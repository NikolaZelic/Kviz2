package severlets;

import Baza.DB;
import Baza.Odgovori;
import Baza.Pitanja;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Questions", urlPatterns = {"/questions"})
public class Questions extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("json;charset=UTF-8");
        StringBuilder json = new StringBuilder();
        
        // Reade questions from database
        List<Pitanja> list = DB.query("SELECT p FROM Pitanja p");
        
        // Choosing random questions
        int qNum = 4;
        Collections.shuffle(list);
        List<Pitanja> questions = new ArrayList<>(qNum);
        int i=0;
        for(Pitanja j:list)
        {
            questions.add(j);
            if(i==qNum)
                break;
            i++;
        }
        
        // Writing question to JSON
        json.append("{\"questions\":[");    // Begining of the questions aray
        boolean firstQuestion = true;
        for( Pitanja question : questions )
        {
            // Appending comma to the end of the prevouius question
            if(firstQuestion)
                firstQuestion = false;
            else
                json.append(",");
            
            json.append("{");   // Begining of the question object
            
            // Question text
            json.append("\"text\":\"").append(question.getPitText()).append("\",");
            
            // Questions answers
            json.append("\"answers\":["); // Begining of the answers array
            Set<Odgovori> answers = question.getOdgovoriSet();
            boolean firstAnswer = true;
            for( Odgovori answer : answers )
            {
                // ANSWER
                // Appending comm ato the last answer
                if(firstAnswer) 
                   firstAnswer = false;
                else
                    json.append(",");
                json.append("{"); // Begining of the answer
                json.append("\"text\":\"").append(answer.getOdgText()).append("\",");   // Answer text
                json.append("\"correct\":\"").append(answer.getOdgTacan()==0?"false":"true").append("\"");
                json.append("}");   // End of the answer
            }
            json.append("]");   // End of the answers array
            json.append("}");   // End of the question onject
        }
        json.append("]");   // End of the questions array
        json.append("}");   // End of the json
        
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
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
