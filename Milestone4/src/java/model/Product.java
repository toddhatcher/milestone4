/*
    Document   : Product.java
    Created on : Oct 10, 2021, 11:08:40 PM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021
 */
package model;

/**
 *
 * @author Elite_ESP
 */
public class Product implements java.io.Serializable{
    
    // Private fields
    private String productCode;
    private String productName;
    private String productPrice;
    private String productLink;
    
    // No arg constructor
    public Product() {
        productCode = "";
        productName = "";
        productPrice = "";
        productLink = "";
    }

    // Full arg constrtuctor
    public Product(String productCode, String productName, String productPrice, String productLink) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productLink = productLink;
    }
    
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }
    
    public String getProductLink() {
        return productLink;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    
    public void setProductLink (String productLink) {
        this.productLink = productLink;
    }
}
