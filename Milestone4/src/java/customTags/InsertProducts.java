/*
    Document   : InsertProducts.java
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

public class InsertProducts extends SimpleTagSupport{
    
    @Override
    public void doTag() throws JspException, IOException{
        Boolean isInsertOk = insertProducts();

        JspWriter out = getJspContext().getOut(); // Was pageContext.getOut()
        
        if (isInsertOk == true){
            out.println("<p>Products inserted: Sucessfully</p>");
        }
        else {
            out.println("<p>Products inserted: Failed</p>");
        }  

    }
    
    // Method to pull results from database
    private boolean insertProducts() {
        //ArrayList<Customer> allCustomers = new ArrayList<>();
        boolean wasInsertSuccess = false;
        try {
                DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
                //Connect to the Database using the URL, user id, and password
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "student1","pass");
                Statement initialStatement = con.createStatement();
                
                // Need IF Statement to check for existing table or move to create table.
                DatabaseMetaData dbm = con.getMetaData();
                ResultSet tables = dbm.getTables(null, null, "TODDSPRODUCTS", null);
                if(tables.next() != true)
                {
                    // Table doesn't exist.
                    // So Create Table.
                    String sqlCreate = "CREATE TABLE TODDSPRODUCTS " +
                                "(PRODUCT_CODE VARCHAR2(10) PRIMARY KEY, " +
                                "PRODUCT_NAME VARCHAR2(40) NOT NULL, " +
                                "PRODUCT_PRICE VARCHAR2(8) NOT NULL, " +
                                "PRODUCT_LINK VARCHAR2(120) NOT NULL )"; 
                    initialStatement.executeUpdate(sqlCreate);
                }
                
                // Test Product #1
                String INSERT_PRODUCT_SQL_1 = "INSERT INTO TODDSPRODUCTS" +
                " (PRODUCT_CODE, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_LINK) VALUES " +
                " ('9001AAT', 'Basic Wooded Starter Train', '$49.99', '/toddhatcherMilestone4/products/wt01/product_wt01.jsp')";
                // Use string for preparing statement
                PreparedStatement preparedStatement1 = con.prepareStatement(INSERT_PRODUCT_SQL_1);
                // Execute prepared statement
                preparedStatement1.executeUpdate();
                
                // Test Product #2
                String INSERT_PRODUCT_SQL_2 = "INSERT INTO TODDSPRODUCTS" +
                " (PRODUCT_CODE, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_LINK) VALUES " +
                " ('11055AAT', 'Figure 8 wooden rail track & train set', '$224.99', '/toddhatcherMilestone4/products/wtset01/product_wtset01.jsp')";
                // Use string for preparing statement
                PreparedStatement preparedStatement2 = con.prepareStatement(INSERT_PRODUCT_SQL_2);
                // Execute prepared statement
                preparedStatement2.executeUpdate();
                
                // Test Product #3
                String INSERT_PRODUCT_SQL_3 = "INSERT INTO TODDSPRODUCTS" +
                " (PRODUCT_CODE, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_LINK) VALUES " +
                " ('120001AAT', 'Painted wood train and caboose', '$99.99', '/toddhatcherMilestone4/products/wt02/product_wt02.jsp')";
                // Use string for preparing statement
                PreparedStatement preparedStatement3 = con.prepareStatement(INSERT_PRODUCT_SQL_3);
                // Execute prepared statement
                preparedStatement3.executeUpdate();
                  
                // Close everything before ending.  
                initialStatement.close();
                con.close();
                
                // Was successful if you made it this far.
                wasInsertSuccess = true;
            
        } catch (Exception e) {
                System.err.println("DB Error Display:");
                System.err.println(e);
            } 
        return wasInsertSuccess;
    }
}