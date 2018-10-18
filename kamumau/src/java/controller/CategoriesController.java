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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author x201
 */
public class CategoriesController extends HttpServlet {
    private final static String add_action = "new";
    private final static String delete_action = "delete";
    private final static String edit_action = "edit";
    private final static String list_action = "list";
    private String message= "";

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
                String action = request.getParameter("action");
                if(action==null){
                    action= "list";
                }
                try {
                    switch (action) {
                    case "new":
                        break;
                    case "create":
                        break;
                    case "delete":
                        break;
                    case "edit":
                        break;
                    case "update":
                        break;
                    default:
                        listCategories(request, response);
                        break;
                    }
                } 
            catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }

    
    private void listCategories(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Category c= new Category();
        List<Category> categories = c.all();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("categories/list.jsp");
        dispatcher.forward(request, response);
        
    }
    
     private void createCategories(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String category_id = request.getParameter("category_id");
 
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setParentId(category_id);
        if (category.create()){
            String message = "new person added";                    
            request.setAttribute("message", message);
            response.sendRedirect("categories?action="+list_action);
        }
        else{
            String message = "new category failed to add";
            request.setAttribute("message", message);
            String add_action = null;
            request.getRequestDispatcher("categories?action="+add_action).include(request, response);
        }
    }
     private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("categories/new.jsp");
            dispatcher.forward(request, response);
     }
      private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            Category category= new Category();
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("category", category.find(id));

            RequestDispatcher dispatcher = request.getRequestDispatcher("categories/edit.jsp");
            dispatcher.forward(request, response);
        }
}
