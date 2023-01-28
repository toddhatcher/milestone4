<%-- 
    Document   : index.jsp
    Created on : Oct 12, 2021, 12:00:10 AM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021
--%>
<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_default.jsp" />
<%@ taglib uri="allAboutToysURI" prefix="tch" %>
<!-- start the middle column -->

<section>
    <h2>Our Toys:</h2>
        <table border="1">
            <tr>
                <th>Product Code</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Page</th>
            </tr>
            <tch:displayProductsTag />
        </table>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_default.jsp" />
<jsp:include page="/includes/footer.jsp" />