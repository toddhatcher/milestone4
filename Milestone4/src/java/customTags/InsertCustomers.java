/*
    Document   : InsertCustomers.java
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

// Research why SimpleTagSupport worked with getJspContext().getOut() and regular TagSupport didn't.
public class InsertCustomers extends SimpleTagSupport{
    
    // doEndTag was having an error with the customerInfo.getCustomerId() and other methods below.
    // Since the Customer object fields throw an IOException, I had to add IOException to the method header.
    // This caused an error with the doEndTag whichw as fixed by using the "doTag()"
    @Override
    public void doTag() throws JspException, IOException{
        Boolean isInsertOk = insertCustomers();

        JspWriter out = getJspContext().getOut(); // Was pageContext.getOut()
        
        if (isInsertOk == true){
            out.println("<p>Customers inserted: Successfully</p>");
        }
        else {
            out.println("<p>Customers inserted: Failed</p>");
        }
        
        /*
        for (Customer customerInfo : listAllCustomers) {
            out.println("<tr>");
            out.println(String.format("<td>%s</td>", customerInfo.getCustomerId()));
            out.println(String.format("<td>%s</td>", customerInfo.getFirstName()));
            out.println(String.format("<td>%s</td>", customerInfo.getLastName()));
            out.println(String.format("<td>%s</td>", customerInfo.getAddress()));
            out.println(String.format("<td>%s</td>", customerInfo.getState()));
            out.println(String.format("<td>%s</td>", customerInfo.getZip()));                 
            out.println("</tr>");
        }    
        */
    }
    
    // Method to pull results from database
    private boolean insertCustomers() {
        //ArrayList<Customer> allCustomers = new ArrayList<>();
        boolean wasInsertSuccess = false;
        try {
                DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
                //Connect to the Database using the URL, user id, and password
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "student1","pass");
                Statement initialStatement = con.createStatement();
                
                // Need IF Statement to check for existing table or move to create table.
                DatabaseMetaData dbm = con.getMetaData();
                ResultSet tables = dbm.getTables(null, null, "TODDSCUSTOMERS", null);
                if(tables.next() != true)
                {
                    // Table doesn't exist.
                    // So Create Table.
                    String sqlCreate = "CREATE TABLE TODDSCUSTOMERS " +
                                "(CUSTOMER_ID VARCHAR2(10) PRIMARY KEY, " +
                                "FIRST_NAME VARCHAR2(30) NOT NULL, " +
                                "LAST_NAME VARCHAR2(30) NOT NULL, " +
                                "ADDRESS VARCHAR2(30) NOT NULL, " +
                                "STATE VARCHAR2(2) NOT NULL, " +
                                "ZIP VARCHAR2(5) NOT NULL )"; 
                    initialStatement.executeUpdate(sqlCreate);
                }
                
                // Test customer 1
                String INSERT_USER_SQL_1 = "INSERT INTO TODDSCUSTOMERS" +
                " (CUSTOMER_ID, FIRST_NAME, LAST_NAME, ADDRESS, STATE, ZIP) VALUES " +
                " ('1001', 'Todd', 'Hatcher', '714 E Phillip', 'NE', '69101')";
                // Use string for 
                PreparedStatement preparedStatement1 = con.prepareStatement(INSERT_USER_SQL_1);
                // Execute query
                preparedStatement1.executeUpdate();
                
                // Test customer 2
                String INSERT_USER_SQL_2 = "INSERT INTO TODDSCUSTOMERS" +
                " (CUSTOMER_ID, FIRST_NAME, LAST_NAME, ADDRESS, STATE, ZIP) VALUES " +
                " ('1002', 'Abhishek', 'Kumar', '870 Express', 'NE', '69205')";
                // Use string for 
                PreparedStatement preparedStatement2 = con.prepareStatement(INSERT_USER_SQL_2);
                // Execute query
                preparedStatement2.executeUpdate();
                
                // Test customer 3
                String INSERT_USER_SQL_3 = "INSERT INTO TODDSCUSTOMERS" +
                " (CUSTOMER_ID, FIRST_NAME, LAST_NAME, ADDRESS, STATE, ZIP) VALUES " +
                " ('1003', 'Derrick', 'Fordyce', '572 Fieldmaster', 'NE', '68501')";
                // Use string for 
                PreparedStatement preparedStatement3 = con.prepareStatement(INSERT_USER_SQL_3);
                // Execute query
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