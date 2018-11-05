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

import java.sql.PreparedStatement;
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
    public String created_at;
    public String updated_at;
    public String status, sname;
    public String address;
    public static String name, csname, nim, byname, productname;
    public int price, qty, productid, slid,tbyid,tslid;
    public int byid;
   
    
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
        public int getqty() {
        return qty;
    }

    public void setqty(int qty) {
        this.qty = qty;
    }
    public int getproductid() {
        return productid;
    }

    public void setproductid(int productid) {
        this.productid = productid;
    }
    public String getproductname() {
        return productname;
    }

    public void setproductname(String productname) {
        this.productname = productname;
    }

    public String getsname() {
        return sname;
    }

    public void setsname(String sname) {
        this.sname = sname;
    }
    
    
    
    
    
    
    public int getNo() {
        return no;
    }
        public void setNo(int no) {
        this.no = no;
    }

    public void setUser(int user_id) {
        this.user_id= user_id;
    }
        
    public String getStatus() {
        return status;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getcsname() {
        return csname;
    }
    public void setcsname(String csname) {
        this.csname = csname;
    }
        public String getbyname() {
        return byname;
    }
    public void setbyname(String byname) {
        this.byname = byname;
    }
            public int getbyid() {
        return byid;
    }
    public void setbyid(int byid) {
        this.byid = byid;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }
    
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getslid() {
        return slid;
    }
    public void setslid(int slid) {
        this.slid = slid;
    } 
        public int gettslid() {
        return tslid;
    }
    public void settslid(int tslid) {
        this.tslid = tslid;
    } 
    public int gettbyid() {
        return tbyid;
    }
    public void settbyid(int tbyid) {
        this.tbyid = tbyid;
    } 
    
    
    
    
   public ArrayList<Order> all(int user_id){
        String query = "SELECT o.no as no, o.created_at as created_at, o.updated_at as updated_at, "
                + " u.full_name as full_name, o.status as status  FROM " + tableName
                + " o inner join user u on "
                + "o.id_buyer = u.id  WHERE o.id_user = " + user_id + " and o.status = 'new' ";
        System.out.println(query);
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setNo(res.getInt("no"));
                order.setCreated_at(res.getString("created_at"));
                order.setUpdated_at(res.getString("updated_at"));    
                order.setStatus(res.getString("status"));
                order.setName(res.getString("full_name"));
                orders.add(order);
               
            }
                        
        }
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
        
    }
   
   public ArrayList<Order> editincoming(int no){
        String query = "SELECT o.no as no, o.created_at as created_at, o.updated_at as updated_at, "
                + " u.full_name as full_name, o.status as status  FROM ORDERS "
                + " o inner join user u on "
                + "o.id_buyer = u.id  WHERE o.no = " +no + " and o.status = 'new' ";
        System.out.println(query);
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setNo(res.getInt("no"));
                order.setCreated_at(res.getString("created_at"));
                order.setUpdated_at(res.getString("updated_at"));    
                order.setStatus(res.getString("status"));
                order.setName(res.getString("full_name"));
                orders.add(order);              
            }
                        
        }
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
        
    }
   
   public ArrayList<Order> editcomplete(int no){
        String query = "SELECT o.no as no, o.created_at as created_at, o.updated_at as updated_at, "
                + " u.full_name as full_name, o.status as status  FROM ORDERS "
                + " o inner join user u on "
                + "o.id_buyer = u.id  WHERE o.no = " +no + " and o.status = 'paid' ";
        System.out.println(query);
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setNo(res.getInt("no"));
                order.setCreated_at(res.getString("created_at"));
                order.setUpdated_at(res.getString("updated_at"));    
                order.setStatus(res.getString("status"));
                order.setName(res.getString("full_name"));
                orders.add(order);              
            }
                        
        }
        
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
        
    }
   
   
   
   public ArrayList<Order> complete(int user_id){
               String query = "SELECT o.no as no, o.created_at as created_at, o.updated_at as updated_at, "
                + " u.full_name , o.id as id, o.status as status  FROM " + tableName  
                + " o inner join user u on "
                + "o.id_buyer = u.id  WHERE o.id_user = " + user_id + " and o.status = 'paid' ORDER BY o.no DESC";
       
       ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Order order = new Order();
                order.setNo(res.getInt("no"));
                order.setCreated_at(res.getString("created_at"));
                order.setUpdated_at(res.getString("updated_at"));
                order.setName(res.getString("full_name"));
                order.setId(res.getInt("id"));
                order.setStatus(res.getString("status"));
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
    
   public void delete(int no) {
        String query = "DELETE FROM " + tableName + " WHERE no = " +no + " ";
        String query2 = "DELETE FROM transactions WHERE order_id = " +no + " ";
        try {
            PreparedStatement pst = this.conn().prepareStatement(query);
            pst.execute();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        
        }  
                try {
            PreparedStatement psd = this.conn().prepareStatement(query2);
            psd.execute();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        
        } 
    }
    
    public Order findByOrderNo(int no){
        String query = "SELECT no FROM " + tableName + " WHERE no = " + no + " ";
        Order order = new Order();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                order.setNo(res.getInt("no"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }
    public  ArrayList<Order> find(int no){
        String query = "SELECT * FROM " + tableName + " WHERE buyer_id = '" +no +"'";
        System.out.println("Query = "+query);
       ArrayList<Order> orders = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                Order order = new Order();
              order.setId(res.getInt("id"));
               order.setName(res.getString("name"));
               order.setAdress(res.getString("address"));
               order.setqty(res.getInt("qty"));
            order.setPrice(res.getInt("price"));
            order.setStatus(res.getString("status"));
             order.setCreated_at( res.getString("created_at"));
               order.setUpdated_at(res.getString("updated_at"));
            orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
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
                order.setCreated_at(res.getString("created_at"));
                order.setUpdated_at(res.getString("updated_at"));
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
    
    public void user(int id)
    {
        String query =  "SELECT ID,full_name FROM user where id = " +id;
        Order order = new Order();
        try {
           Statement stmt = this.conn().createStatement();
           ResultSet res = stmt.executeQuery(query);
           while(res.next())
           {
               order.setUser(res.getInt("id"));
               order.setcsname(res.getString("full_name"));
               System.out.println(order.getId());   
               System.out.println(order.getcsname()); 
           }
            
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
        public ArrayList<Order> cart(int id)
     {
         String query = "SELECT t.id as id, t.order_id as order_id, u.full_name as id_seller, p.name as product_id, "
                 + "t.status as status, t.qty as qty"
                 + "  FROM TRANSACTIONS t inner join user u "
                 + "on t.id_seller = u.id "
                 + "inner join products p "
                 + "on p.id = t.product_id where t.id_buyer = "+id;
         
          ArrayList<Order> orders = new ArrayList<>();
         try
         {   System.out.println(query);
             Statement stmt = this.conn().createStatement();
             ResultSet rs = stmt.executeQuery(query);
             while(rs.next())
             {   Order order = new Order();
                 order.setName(rs.getString("id_seller"));
                 order.setId(rs.getInt("id"));
                 order.setNo(rs.getInt("order_id"));
                 order.setqty(rs.getInt("qty"));
                 order.setStatus(rs.getString("status"));
                 order.setproductname(rs.getString("product_id"));
                 orders.add(order);
             }
         }
         catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
         return orders;
     }
    public void updatein(int no)
    {
     
        String query =  "UPDATE ORDERS SET STATUS = 'paid' where no = " +no;
         String query2 =  "UPDATE transactions SET STATUS = 'paid' where no = " +no;
       
        try {
              PreparedStatement pst = this.conn().prepareStatement(query);
            pst.execute();            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }  
                try {
              PreparedStatement psd = this.conn().prepareStatement(query2);
            psd.execute();            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }   
    }
public void updatecom(int no)
    {
     
        String query =  "UPDATE ORDERS SET STATUS = 'complete' where no = " +no;
         String query2 =  "UPDATE transactions SET STATUS = 'paid' where no = " +no;
       
        try {
              PreparedStatement pst = this.conn().prepareStatement(query);
            pst.execute();            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }  
                try {
              PreparedStatement psd = this.conn().prepareStatement(query2);
            psd.execute();            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }   
    }
public void addorders(){
     String date= generateDate();
        String status= "new";
        this.setNo(Math.abs(this.generateNo()));     
    String query = "INSERT INTO "+ tableName +"(no, id_user, id_buyer, status,created_at,updated_at) values ('" + this.no + "', '" + this.byid + "', '" + this.slid +"','" +status + "','" +date + 
             "','" +date + "')";
    String query2 = "INSERT INTO TRANSACTIONS "+"(order_id, product_id, id_seller, id_buyer, qty, status) values ('" + this.no + "', '" + this.productid + "', '" + this.tslid + "','" +this.tbyid + 
             "','" +this.qty +"','" +status + "')";
    System.out.println(query);
    System.out.println("  ");
    System.out.println(query2);
    try {
            PreparedStatement pst = this.conn().prepareStatement(query);
            
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            PreparedStatement psd = this.conn().prepareStatement(query2);
            
            psd.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
}

}
