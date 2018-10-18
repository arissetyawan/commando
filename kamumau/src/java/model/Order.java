/*
 * @author x201
 *  CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT,
    no int NOT NULL,
    user_id int NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    status VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
);
);
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Order extends MyConnection{
    private final String tableName= "orders";
    private final String tableTransaction= "transactions";
    public int no;
    public int user_id;
    public Date created_at;
    public Date updated_at;
    private String status;
    protected String address;
    protected String name;
    protected float price;
    protected int buyer_id;
    
    /* this constructor defined 
       this class to have same behaviour with it parents
    etc
    */
    
    public Order() {
        super();
    }
    
    /*
    this method returns property id set by setId
    */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setUser(int user_id) {
        this.user_id= user_id;
    }

    public void setStatus(String status) {
        this.status= status;
    }

    private String generateDate(){
        Date date= new Date();
        return String.format("%1$tY-%1$tm-%1$td", date);
    }
    private int generateNo(){
        return (int) System.currentTimeMillis();
    }
    public void setNo(int no) {
        this.no = no;
    }
    
    public void setCreatedAt(Date date){
        this.created_at= date;
    }
    public void setUpdatedAT(Date date){
        this.updated_at= date;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAdress(String address) {
        this.address = address;
    }
    
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
    
    
    public ArrayList<Order> all(){
        
        String query = "SELECT * FROM " + tableName;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setNo(res.getInt("id"));
              order.setId(res.getInt("buyer_id"));
               order.setName(res.getString("name"));
               order.setAdress(res.getString("address"));
            order.setPrice(res.getFloat("price"));
               int a = res.getInt("status");
               if(a==1)
               {
                  order.setStatus("new");
               }
               else if (a==2)
               {
                   order.setStatus("paid");
               }
               else if(a==3)
               {
                   order.setStatus("delivered");
               }
             order.setCreatedAt( res.getDate("created_at"));
               order.setUpdatedAT( res.getDate("updated_at"));
               
                
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    public ArrayList<Transaction> getTransactions(int order_id) {
        String query = "SELECT * FROM " + tableTransaction + " WHERE order_id= " + order_id;
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Transaction t = new Transaction();
                transactions.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transactions;
    }



    private boolean validate(){
        return true;
    }

    public boolean update() {
        return false;
    }
    
    public boolean delete() {
        return false;
    }
    
    public Order findByOrderNo(int no){
        String query = "SELECT * FROM " + tableName + " WHERE no = " + no + " ";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));
                order.setUser(res.getInt("user_id"));
                order.setStatus(res.getString("status"));
                order.setCreatedAt(res.getDate("created_at"));
                order.setUpdatedAT(res.getDate("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }
    public Order find(int id){
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id + " ";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));
                order.setCreatedAt(res.getDate("created_at"));
                order.setUpdatedAT(res.getDate("updated_at"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    public Order initOrCeate(int user_id){
        String query = "SELECT * FROM " + tableName + " WHERE user_id = " + user_id + " AND status='new'";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setId(res.getInt("id"));
                order.setNo(res.getInt("no"));
                order.setUser(res.getInt("user_id"));
                order.setStatus(res.getString("status"));
                order.setCreatedAt(res.getDate("created_at"));
                order.setUpdatedAT(res.getDate("updated_at"));
            }
            else{
                order.setUser(user_id);
                if(order.create()){
                   order= order.findByOrderNo(order.getNo());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }
   
    private boolean create() {
        String now_date= generateDate();
        String status= "new";
        String query = "INSERT INTO "+ tableName +"(no, user_id, created_at, updated_at,status) values ('" + this.generateNo() + "', '" + this.user_id  + "', '" +  now_date + "', '" + now_date + "','" + status + "')";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
