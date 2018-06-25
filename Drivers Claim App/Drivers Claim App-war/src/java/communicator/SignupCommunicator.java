/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicator;

import ORM_DB.Members;
import UserBeans.UserOpsBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sean
 */
public class SignupCommunicator extends HttpServlet {

    private static final DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private static final float STARTBALANCE = 100.0f;
    private static final String STARTSTATUS = "NP";
    @EJB
    private UserOpsBeanRemote userOpsBean;

    
    
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
        
       
        
        Members member = null;
        
        if(NIC != null && name != null & address != null && DOB != null)
        {
            
            try {
                member = new Members(NIC, name, address, DATEFORMAT.parse(DOB),DATEFORMAT.parse(DATEFORMAT.format(new Date())) , STARTSTATUS, STARTBALANCE);
                userOpsBean.saveMember(member);
            } catch (ParseException ex) {
                member = null;
                //Logger.getLogger(SignupCommunicator.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Unable to parse date format from input");
            }
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Heelo</title>");            
            out.println("</head>");
            out.println("<body>");
            if(member != null)
            {
                out.println("<h1>Congardulation you have be come a memeber</h1>");
            
            }else
            {
               request.getRequestDispatcher("Signup.html").forward(request, response);
            
            }
            out.println("</body>");
            out.println("</html>");
        }
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
