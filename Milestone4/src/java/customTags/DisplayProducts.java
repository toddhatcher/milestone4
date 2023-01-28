/*
    Document   : DisplayProducts.java
    Created on : Oct 10, 2021, 11:08:40 PM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021
 */

package customTags;

import model.Product;
import java.io.*;
import java.sql.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;

// Research why SimpleTagSupport worked with getJspContext().getOut() and regular TagSupport didn't.
public class DisplayProducts extends SimpleTagSupport{
    
    // doEndTag was having an error with the customerInfo.getCustomerId() and other methods below.
    // Since the Customer object fields throw an IOException, I had to add IOException to the method header.
    // This caused an error with the doEndTag whichw as fixed by using the "doTag()"
    @Override
    public void doTag() throws JspException, IOException{
        ArrayList<Product> listAllProducts = retrieveProducts();

        JspWriter out = getJspContext().getOut(); // Was pageContext.getOut()
        
        for (Product productInfo : listAllProducts) {
            out.println("<tr>");
            out.println(String.format("<td>%s</td>", productInfo.getProductCode()));
            out.println(String.format("<td>%s</td>", productInfo.getProductName()));
            out.println(String.format("<td>%s</td>", productInfo.getProductPrice()));
            out.println(String.format("<td><a href=%s>Link</a></td>", productInfo.getProductLink()));
            out.println("</tr>");
        }    

    }
    
    // Method to pull results from database
    private ArrayList<Product> retrieveProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();
        
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            //Connect to the Database using the URL, user id, and password
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "student1","pass");
            Statement resultsStatement = con.createStatement();
            ResultSet results = resultsStatement.executeQuery("SELECT * FROM TODDSPRODUCTS");
            
            while(results.next()){
                // For each record, pull the data out of each field.
                    String product_code = results.getString(1);
                    String product_name = results.getString(2);
                    String product_price = results.getString(3);
                    String product_link = results.getString(4);

                    // Make customer object and stick the data back in the customer fields
                    Product resultProduct = new Product(product_code, product_name, product_price, product_link);
                    allProducts.add(resultProduct);
            }
            
        } catch (Exception e) {
                System.err.println("DB Error Products:");
                System.err.println(e);
            } 
        return allProducts;
    }
}