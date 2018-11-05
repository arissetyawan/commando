/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bagus
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User extends MyConnection {

    private final String tableName = "users";
    public String email, password, fullname, address, bank_name, no_account;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getNo_account() {
        return no_account;
    }

    public void setNo_account(String no_account) {
        this.no_account = no_account;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private boolean validate() {
        boolean status = false;
        if (!"".equals(this.email) && !"".equals(this.password) && !"".equals(this.fullname)
                && !"".equals(this.address)) {
            status = true;
        }
        return status;
    }

    public boolean create() {
        if (!validate()) {
            return false;
        }
        String query = "INSERT INTO " + tableName + "(email, pass, name, address, bank_name, no_account) values ('" + this.email + "', '" + this.password + "', '" + this.fullname + "', '" + this.address + "', '" + this.bank_name + "', '" + this.no_account + "')";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update() {
        if (!validate()) {
            return false;
        }
        String query = "UPDATE " + tableName + " SET email='"
                + this.email + "', pass='" + this.password
                + "', name='" + this.fullname
                + "', address='" + this.address
                + "', bank_name='" + this.bank_name
                + "', no_account='" + this.no_account
                + "' WHERE id = " + this.id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete() {
        String query = "DELETE FROM " + tableName + " WHERE id = " + this.id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            return stmt.executeUpdate(query) > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public User find(int id) {
        User user = new User();
        String query = "SELECT * FROM " + tableName + " WHERE id = " + id + " ";
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("pass"));
                user.setFullname(res.getString("name"));
                user.setAddress(res.getString("address"));
                user.setBank_name(res.getString("bank_name"));
                user.setBank_name(res.getString("no_account"));
                user.setId(res.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public ArrayList<User> all() {
        String query = "SELECT * FROM " + tableName;
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                User user = new User();
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("pass"));
                user.setFullname(res.getString("name"));
                user.setAddress(res.getString("address"));
                user.setBank_name(res.getString("bank_name"));
                user.setBank_name(res.getString("no_account"));
                user.setId(res.getInt("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public boolean doLogin() {
        User user = new User();
        String query = "SELECT * FROM " + tableName + " WHERE email = '" + this.email + "' and pass = '" + this.password + "'";
        try {
            Statement stmt = this.conn().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                user.setEmail(res.getString("email"));
                user.setPassword(res.getString("pass"));
                user.setId(res.getInt("id"));
                this.id = res.getInt("id"); 
        return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }    
    }

}
