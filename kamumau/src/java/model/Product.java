/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fredd
 */
public class Product extends MyConnection{
    private final String tableName= "products";
    public int id, user_id, price, stock, category_id;
    public String name, categoryName;
    public String created_at, updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
    
    private boolean validate(){
        boolean status= false;
        if (!"".equals(this.name) &&  !"".equals(this.price) 
                &&  !"".equals(this.stock) &&  !"".equals(this.category_id)){
            status= true;
        } 
        return status;
    }
    
    public boolean create() {
        boolean result;
        if(!validate()){
            return false;
        }
        String query = "INSERT INTO "+ tableName +
                "(user_id, name, price, stock, category_id) "
                + "values ('" + this.user_id + "', '" + this.name + "', '" 
                + this.price + "', '" + this.stock + "', '" + this.category_id + "')";
        try {
            result = this.stateOpen().executeUpdate(query) > 0;
            this.stateClose();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Product> all(){
        String query = "SELECT products.*, categories.name AS category_name "
                + "FROM "+tableName+" LEFT JOIN categories "
                + "ON categories.id = products.category_id "
                + "WHERE products.stock>0";
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Product product = new Product();
                product.setId(res.getInt("id"));
                product.setUser_id(res.getInt("user_id"));
                product.setName(res.getString("name"));
                product.setPrice(res.getInt("price"));
                product.setStock(res.getInt("stock"));
                product.setCategory_id(res.getInt("category_id"));
                product.setCategoryName(res.getString("category_name"));
                product.setUpdated_at(res.getString("updated_at"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
    
    public ArrayList<Product> findProduct(String key){
        String query = "SELECT products.*, categories.name AS category_name "
                + "FROM "+tableName+" LEFT JOIN categories "
                + "ON categories.id = products.category_id "
                + "WHERE products.stock > 0 AND products.name like '%"+key+"%'";
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Product product = new Product();
                product.setId(res.getInt("id"));
                product.setUser_id(res.getInt("user_id"));
                product.setName(res.getString("name"));
                product.setPrice(res.getInt("price"));
                product.setStock(res.getInt("stock"));
                product.setCategory_id(res.getInt("category_id"));
                product.setCategoryName(res.getString("category_name"));
                product.setUpdated_at(res.getString("updated_at"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
    

    public Object find(int id) {
        Product product = new Product();
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                product.setId(res.getInt("id"));
                product.setName(res.getString("name"));
                product.setPrice(res.getInt("price"));
                product.setStock(res.getInt("stock"));
                product.setCategory_id(res.getInt("category_id"));
                product.setId(res.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public boolean update() {
        if(!validate()){
            return false;
        }
        String query = "UPDATE "+ tableName + " SET category_id='"
                + this.category_id +"', name='"+ this.name + "', price='" 
                + this.price + "', stock='" + this.stock + "' WHERE id ='" 
                + this.id + "'";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Product> outofStockProduct(String stock) {
        String query = "SELECT products.*, categories.name AS category_name "
                + "FROM "+tableName+" LEFT JOIN categories "
                + "ON categories.id = products.category_id "
                + "WHERE products.stock=0";
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Product product = new Product();
                product.setId(res.getInt("id"));
                product.setUser_id(res.getInt("user_id"));
                product.setName(res.getString("name"));
                product.setPrice(res.getInt("price"));
                product.setStock(res.getInt("stock"));
                product.setCategory_id(res.getInt("category_id"));
                product.setCategoryName(res.getString("category_name"));
                product.setUpdated_at(res.getString("updated_at"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM "+ tableName +
                " WHERE id='"+id+"'";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0 ? true:false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public int checkTransaction(int id){
        //just for example
        return 0;
    }
    
}
