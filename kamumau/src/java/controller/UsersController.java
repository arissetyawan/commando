/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 *
 * @author x201
 */
@WebServlet(name = "UsersController", urlPatterns = {"/UsersController"})
public class UsersController extends ApplicationController {

    private final static String add_action = "new";
    private final static String signin_action = "signin";
    private final static String login_action = "do-login";
    private final static String logout_action = "logout";
    private final static String welcome_action = "welcome";
    private final static String update_action = "update";
    private final static String success_action = "success";
    private final static String delete_action = "delete";
    
    private String message = "";

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            if (action == null) {
                action = "do-login";
            }
            try {
                switch (action) {
                    case "new":
                        ShowNewForm(request, response);
                        break;
                    case "signin":
                        showLoginForm(request, response);
                        break;
                    case "create":
                        createUser(request, response);
                        break;
                    case "do-login":
                        doLogin(request, response);
                        break;
                    case "logout":
                        doLogout(request, response);
                        break;
                    case "welcome":
                        mustLoggedIn(request, response);
                        showWelcomePage(request, response);
                        break;
                    case "update":
                        mustLoggedIn(request, response);
                        showUpdateUser(request, response);
                        break;
                    case "success":
                        
                        showSuccessPage(request, response);
                        break;
                    case "delete":
                       deleteUser(request, response);
                    break;
                    default:
                        showLoginForm(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
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

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        logout(request, response);
        if (user.doLogin()) {
            setLoggedIn(user, request, response);
            showWelcomePage(request, response);

        }

    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        logout(request, response);
        showLoginForm(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/signin.jsp");
        dispatcher.forward(request, response);
    }

    private void showWelcomePage(HttpServletRequest request, HttpServletResponse response)    throws ServletException, IOException, ServletException  {
            RequestDispatcher dispatcher = request.getRequestDispatcher("users/welcome.jsp");
            dispatcher.forward(request, response);
        }
    
    private void showSuccessPage(HttpServletRequest request, HttpServletResponse response)    throws ServletException, IOException, ServletException  {
            RequestDispatcher dispatcher = request.getRequestDispatcher("users/success.jsp");
            dispatcher.forward(request, response);
        }


    private void ShowNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/signup.jsp");
        dispatcher.forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullname = request.getParameter("name");
        String address = request.getParameter("address");
        String bank_name = request.getParameter("bank_name");
        String no_account = request.getParameter("no_account");

        User users = new User();
        users.setEmail(email);
        users.setPassword(password);
        users.setFullname(fullname);
        users.setAddress(address);
        users.setBank_name(bank_name);
        users.setNo_account(no_account);
        if (users.create()) {
            message = "new user added";
            request.setAttribute("message", message);
            response.sendRedirect("users?action=success");
        } else {
            message = "new user failed to add";
            request.setAttribute("message", message);
            request.getRequestDispatcher("user?action=" + add_action).include(request, response);
        }

    }

    private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        HttpSession session = request.getSession();
        String user = session.getAttribute("current_user").toString();
        User users = new User();
        users = users.find(Integer.parseInt(user));
        request.setAttribute("user", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/update.jsp");
        dispatcher.forward(request, response);
    }
    
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullname = request.getParameter("name");
        String address = request.getParameter("address");
        String bank_name = request.getParameter("bank_name");
        String no_account = request.getParameter("no_account");
        
        HttpSession session = request.getSession();
        String profil = session.getAttribute("current_user").toString();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setAddress(address);
        user.setBank_name(bank_name);
        user.setNo_account(no_account);
        if (user.update()) {
            message = "user updated";
            request.setAttribute("message", message);
            List<User> users = user.all();
            request.setAttribute("users", user);
             RequestDispatcher dispatcher = request.getRequestDispatcher("users?action=" + update_action);
            dispatcher.forward(request, response);
        } else {
            message = "user failed to updated";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("users?action=" + update_action);
            dispatcher.forward(request, response);
        }

    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        User users = new User();
        users.setId(id);
        if(users.delete()){
            message= "user deleted";                    
        }
        else{
            message= "user was not deleted";                
        }    
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users?action="+ add_action);
        dispatcher.forward(request, response);


    }
}
