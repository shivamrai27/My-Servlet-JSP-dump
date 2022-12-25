
package com.mindmill.product.bean;

/**
 *
 * @author SR
 */
public class Product {
    
   private int    p_id;
   private String p_name ;
   private String P_brand;

    public Product(int p_id, String p_name, String P_brand) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.P_brand = P_brand;
    }

    public Product(String p_name, String P_brand) {
        this.p_name = p_name;
        this.P_brand = P_brand;
    }

   
    
    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_brand() {
        return P_brand;
    }

    public void setP_brand(String P_brand) {
        this.P_brand = P_brand;
    }
    
}
