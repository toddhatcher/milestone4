/*
    Document   : Customer.java
    Created on : Sep 13, 2021, 2:20:48 AM
    Author     : Todd Hatcher 
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/10/2021
 */
package model;

/**
 *
 * @author Todd Hatcher
 */

public class Customer implements java.io.Serializable {
    
    // Private fields
    private String customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String zip;
    
    // No arg constructor
    public Customer() {
        customerId = "";
        firstName = "";
        lastName = "";
        address = "";
        state = "";
        zip = "";
    }

    // Full arg constrtuctor
    public Customer(String customerId, String firstName, String lastName,
        String address, String state, String zip) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.zip = zip;
    }
    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
}
