/*
    Document   : DropProducts.java
    Created on : Oct 10, 2021, 11:08:40 PM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021
 */

package customTags;

import java.io.*;
import java.sql.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class DropProducts extends SimpleTagSupport{
    @Override
    public void doTag() throws JspException, IOException{
        Boolean isDropSuccessful = dropProducts();

        JspWriter out = getJspContext().getOut(); // Was pageContext.getOut()
        
        if (isDropSuccessful == true){
            out.println("<p>Products dropped: Successfully</p>");
        }
        else {
            out.println("<p>Products dropped: Failed</p>");
        }
        
    }
    
    // Method to drop products from database
    private boolean dropProducts() {
    
        boolean wasDropSuccess = false;
        
        try {
            DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
                //Connect to the Database using the URL, user id, and password
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "student1","pass");
                Statement initialStatement = con.createStatement();
                
                String DROP_PRODUCTS_TABLE_SQL = "DROP TABLE TODDSPRODUCTS PURGE";
                // Use string for 
                PreparedStatement preparedStatement = con.prepareStatement(DROP_PRODUCTS_TABLE_SQL);
                // Execute query
                preparedStatement.executeUpdate();

                // Close everything before ending.  
                initialStatement.close();
                con.close();
                
                // Was successful if you made it this far.    
                wasDropSuccess = true;
            
        } catch (Exception e) {
                System.err.println("DB Error Products:");
                System.err.println(e);
            } 
        return wasDropSuccess;
    }
}