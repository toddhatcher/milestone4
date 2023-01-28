/*
    Document   : DropCustomers.java
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

public class DropCustomers extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException{
        Boolean isDropSuccessful = dropCustomers();

        JspWriter out = getJspContext().getOut(); // Was pageContext.getOut()
        
        if (isDropSuccessful == true){
            out.println("<p>Customers dropped: Successfully</p>");
        }
        else {
            out.println("<p>Customers dropped: Failed</p>");
        }
    
    }
    
    // Method to pull results from database
    private boolean dropCustomers() {
        //ArrayList<Customer> allCustomers = new ArrayList<>();
        boolean wasDropSuccess = false;
        try {
                DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
                //Connect to the Database using the URL, user id, and password
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "student1","pass");
                Statement initialStatement = con.createStatement();
                
                String DROP_CUSTOMERS_TABLE_SQL = "DROP TABLE TODDSCUSTOMERS PURGE";
                // Use string for 
                PreparedStatement preparedStatement = con.prepareStatement(DROP_CUSTOMERS_TABLE_SQL);
                // Execute query
                preparedStatement.executeUpdate();

                // Close everything before ending.  
                initialStatement.close();
                con.close();
                
                // Was successful if you made it this far.    
                wasDropSuccess = true;    
                
        } catch (Exception e) {
                System.err.println("DB Error Customers:");
                System.err.println(e);
            } 
        return wasDropSuccess;
    }
}