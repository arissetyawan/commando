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
import model.Person;
import model.Product;

/**
 *
 * @author x201
 */
public class ProductsController extends HttpServlet {
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
                action= "";
            }
            try{
                switch (action) {
                    case "new":
                        showNewForm(request, response);
                        break;
                    case "create":
                        createProduct(request, response);
                        break;
                    case "delete":
                        deleteProduct(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "update":
                        updateProduct(request, response);
                        break;
                    case "list":
                        listProduct(request, response);
                        break;
                    default:
                        searchProduct(request, response);
                        break;
                }
            } catch(SQLException ex){
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

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/new.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        int category_id = Integer.valueOf(request.getParameter("category"));
        int price = Integer.valueOf(request.getParameter("price"));
        int stock = Integer.valueOf(request.getParameter("stock"));
 
        Product product = new Product();
        product.setUser_id(1);
        product.setName(name);
        product.setCategory_id(category_id);
        product.setPrice(price);
        product.setStock(stock);
        if (product.create()){
            message = "new product added";                    
            request.setAttribute("message", message);
            response.sendRedirect("products?action=list");
        }
        else{
            message= "new person failed to add";
            request.setAttribute("message", message);
            request.getRequestDispatcher("products?action=new").include(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Product product = new Product();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("product", product.find(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("products/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        int category_id = Integer.valueOf(request.getParameter("category"));
        int price = Integer.valueOf(request.getParameter("price"));
        int stock = Integer.valueOf(request.getParameter("stock"));
 
        Product product = new Product();
        product.setId(id);
        product.setUser_id(1);
        product.setName(name);
        product.setCategory_id(category_id);
        product.setPrice(price);
        product.setStock(stock);
        if (product.update()){
            message= "product updated";     
            request.setAttribute("message", message);
            List<Product> products = product.all();
            request.setAttribute("products", products);
//            request.getRequestDispatcher("/products/list.jsp").include(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("products?action=list");
            dispatcher.forward(request, response);
        }
        else{
            message= "product failed to updated";     
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("products?action=edit");
            dispatcher.forward(request, response);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        Product p = new Product();
        List<Product> products = p.all();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        Product p = new Product();
        List<Product> products = p.all();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products/search.jsp");
        dispatcher.forward(request, response);
    }

}
