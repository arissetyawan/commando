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
import model.Order;

/**
 *
 * @author x201
 */
public class OrdersController extends HttpServlet {
 private String message= "";
 private String cs_name= "";
 int id;
 int no;
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
                try {
                    switch (action) {
                    case "list":
                        listOrders(request, response);
                        break;
                    case "create":
                        create(request, response);
                        break;
                    case "delete":
                        deleteOrders(request, response);
                        break;
                    case "edit":
                        editOrders(request, response);
                        break;
                    case "editcom":
                        edit(request, response);
                        break;
                    case "cart":
                        cart(request, response);
                        break;
                    case "user":
                        users(request, response);
                        break;
                    case "complete":
                        listComplete(request, response);
                        break;
                    case "add":
                        add(request, response);
                        break;
                    case "updatein":
                        updateinOrders(request, response);
                        break;
                    case "updatecom":
                        updatecomOrders(request, response);
                        break;
                    default:
                        notfound(request, response);
                        break;
                    }
                } 
            catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
    }

    
    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
          Order o= new Order();
        List<Order> orders = o.all(id);        
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/list.jsp");
        dispatcher.forward(request, response);
    }
        private void listComplete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
          Order o= new Order();
        List<Order> orders = o.complete(id);
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/complete.jsp");
        dispatcher.forward(request, response);
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
    private void editOrders(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
                no = Integer.parseInt(request.getParameter("no"));
        Order o= new Order();
        List<Order> orders = o.editincoming(no);
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void edit(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
                no = Integer.parseInt(request.getParameter("no"));
        Order o= new Order();
        List<Order> orders = o.editcomplete(no);
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/edit.jsp");
        dispatcher.forward(request, response);
    }
        private void deleteOrders(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         Order o = new Order();
        int no = Integer.parseInt(request.getParameter("no"));
        o.delete(no);   
            cs_name = "orders deleted";  
             request.setAttribute("cs_name", cs_name);
     request.getRequestDispatcher("orders?action=list").include(request, response);
    }
        
    private void users(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         Order o = new Order();
        id = Integer.parseInt(request.getParameter("user"));
        o.user(id);
        cs_name = "you are login as "+o.csname; 
        request.setAttribute("cs_name", cs_name);
     request.getRequestDispatcher("orders?action=list").include(request, response);
    }
    
    private void notfound(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
         RequestDispatcher dispatcher = request.getRequestDispatcher("orders/notfound.jsp");
        dispatcher.forward(request, response);
    }
    
    private void cart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Order o= new Order();
        List<Order> orders = o.cart(id);
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/cart.jsp");
        dispatcher.forward(request, response);
    }
    
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Order o= new Order();
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/add.jsp");
        dispatcher.forward(request, response);
    }
            private void updateinOrders(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         Order o = new Order();
        int no = Integer.parseInt(request.getParameter("no"));
        o.updatein(no);   
            cs_name = "orders updated";  
             request.setAttribute("cs_name", cs_name);
     request.getRequestDispatcher("orders?action=edit").include(request, response);
    }
   
    private void updatecomOrders(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
         Order o = new Order();
        int no = Integer.parseInt(request.getParameter("no"));
        o.updatecom(no);   
            cs_name = "orders complete";  
             request.setAttribute("cs_name", cs_name);
     request.getRequestDispatcher("orders?action=edit").include(request, response);
    }
    private void create(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Order o = new Order();
        int seller = Integer.parseInt(request.getParameter("id_seller"));
        int productid = Integer.parseInt(request.getParameter("product"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        
    o.setslid(id);
    o.setproductid(productid);
    o.setqty(qty);
    o.setbyid(seller);
    o.settbyid(id);
    o.settslid(seller);
   
                cs_name = "orders added to mycart";  
             request.setAttribute("cs_name", cs_name);
             o.addorders();
    request.getRequestDispatcher("orders?action=cart").include(request, response);
    }
}
