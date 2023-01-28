/*
    Document   : DisplayCustomers.java
    Created on : Oct 10, 2021, 11:08:40 PM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021
 */

package customTags;

import model.Customer;
import java.io.*;
import java.sql.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;

// Research why SimpleTagSupport worked with getJspContext().getOut() and regular TagSupport didn't.
public class DisplayCustomers extends SimpleTagSupport{
    
    // doEndTag was having an error with the customerInfo.getCustomerId() and other methods below.
    // Since the Customer object fields throw an IOException, I had to add IOException to the method header.
    // This caused an error with the doEndTag whichw as fixed by using the "doTag()"
    @Override
    public void doTag() throws JspException, IOException{
        ArrayList<Customer> listAllCustomers = retrieveCustomers();

        JspWriter out = getJspContext().getOut(); // Was pageContext.getOut()
        
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

    }
    
    // Method to pull results from database
    private ArrayList<Customer> retrieveCustomers() {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            //Connect to the Database using the URL, user id, and password
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "student1","pass");
            Statement resultsStatement = con.createStatement();
            ResultSet results = resultsStatement.executeQuery("SELECT * FROM TODDSCUSTOMERS");
            
            while(results.next()){
                // For each record, pull the data out of each field.
                    String customer_id = results.getString(1);
                    String first_name = results.getString(2);
                    String last_name = results.getString(3);
                    String address = results.getString(4);
                    String state = results.getString(5);
                    String zip = results.getString(6);

                    // Make customer object and stick the data back in the customer fields
                    Customer resultCustomer = new Customer(customer_id, first_name, last_name, address, state, zip);
                    allCustomers.add(resultCustomer);
            }
            
        } catch (Exception e) {
                System.err.println("DB Error Customers:");
                System.err.println(e);
            } 
        return allCustomers;
    }
}