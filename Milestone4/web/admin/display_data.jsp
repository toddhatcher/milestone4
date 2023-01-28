<%-- 
    Document   : display_data.jsp
    Created on : Oct 11, 2021, 2:32:10 PM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021
--%>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_admin.jsp" />
<%@ taglib uri="allAboutToysURI" prefix="tch" %>
<!-- start the middle column -->

<section>
    <h1>All Aboard Toys Admin Portal</h1>

    <p>Here you can display all of the demo data in the database.</p>
    <hr />
    <div align="center">    
                    <h2>Our Customers:</h2>
                    <table border="1">
                        <tr>
                            <th>Customer ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>State</th>
                            <th>Zip</th>
                        </tr>
                        <tch:displayCustomersTag />
                    </table>
                    <br />
                    <h2>Our Products:</h2>
                    <table border="1">
                        <tr>
                            <th>Product Code</th>
                            <th>Product Name</th>
                            <th>Product Price</th>
                            <th id="productLink">Product Link</th>
                        </tr>
                        <tch:displayProductsTag />
                    </table>
                    <br />
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_admin.jsp" />
<jsp:include page="/includes/footer.jsp" />