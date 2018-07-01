/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MemberModel;
import ORM_DB.Members;
import ORM_DB.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chamath Ravin
 */
@WebServlet(name = "userSignUp", urlPatterns = {"/userSignUp"})
public class userSignUp extends HttpServlet {
private static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private static final float STARTBALANCE = 100.0f;
    private static final String STARTSTATUS = "NP";
    
    MemberModel memberModel;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
         String NIC = request.getParameter("id");
        
        String name = request.getParameter("name");
        
        String address = request.getParameter("address");
        
        String DOB = request.getParameter("dob");
        
        String password = request.getParameter("password");
        
        Members member=null;
        
        
        if(NIC != null && name != null & address != null && DOB != null)
        {
            
            try {
                member = new Members(NIC, name, address, DATEFORMAT.parse(DOB),DATEFORMAT.parse(DATEFORMAT.format(new Date())) , STARTSTATUS, STARTBALANCE);
                
                memberModel.saveEmployee(member);
                //Create cookie session           
                HttpSession session=request.getSession();
                session.setAttribute("nic", NIC);
                session.setAttribute("name", name);
                response.sendRedirect("user_dash.jsp");
                
            } catch (Exception ex) {
                member = null;
           
                //Logger.getLogger(SignupCommunicator.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Unable to parse date format from input");
            }
        }
        
        

//        processRequest(request, response);

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
