
package com.mindmill.product.Dao;
import com.mindmill.product.bean.Product;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;        

/**
 *
 * @author SR
 */
public class ProductDao {
    
    boolean addProductrowCount = false;
    boolean updateProductrowCount = false;
    boolean deleteProductrowCount = false;
    
    
    Connection getConnection(){
        Connection conn=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/product1","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
     String addProduct = "INSERT INTO product1 values(?, ?, ?);";
     String showProduct = "select * from product1";
     String deleteProdut = "delete from product1 where P_id = ?;";
     String updateProduct = "update product1 set p_id = ?,p_name= ?, p_brand =? where p_id = ?;";

// add new product start
     
     
     
public void addProduct(Product product){
    try (Connection conn = getConnection()){
        PreparedStatement ps = conn.prepareStatement(addProduct);
        ps.setInt(1, product.getP_id());
        ps.setString(2, product.getP_name());
        ps.setString(3, product.getP_brand());
        
        int rowCount=ps.executeUpdate();
        if(rowCount>0){
            addProductrowCount = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void updateProduct(Product product){
    try (Connection conn = getConnection()){
        PreparedStatement ps = conn.prepareStatement(updateProduct);
        ps.setInt(1, product.getP_id());
        ps.setString(2, product.getP_name());
        ps.setString(3, product.getP_brand());
        
        int rowCount=ps.executeUpdate();
        if(rowCount>0){
            updateProductrowCount = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public List < Product > showProduct() {
        
        List < Product > products = new ArrayList < > ();
        try (Connection connection = getConnection();
            ) {
            PreparedStatement ps = connection.prepareStatement(showProduct);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int p_id = rs.getInt("p_id");
                String p_name = rs.getString("p_name");
                String p_brand = rs.getString("p_brand");
         
                products.add(new Product(p_id, p_name, p_brand));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public boolean deleteProduct(int p_id){
        try (Connection conn = getConnection()){
            PreparedStatement ps = conn.prepareStatement(deleteProdut);
            ps.setInt(1, p_id);
            int rowCount = ps.executeUpdate();
            if(rowCount>0){
            deleteProductrowCount = true;
        }
        } catch (Exception e) {
            
        }
        return deleteProductrowCount;
    }

    
}

