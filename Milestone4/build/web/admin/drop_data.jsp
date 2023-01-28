<%-- 
    Document   : drop_data.jsp
    Created on : Oct 10, 2021, 3:33:17 AM
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

    <p>Here you can drop all of the demo data out of the database.</p>
    <hr />
    <tch:dropCustomersTag />
    <hr />
    <tch:dropProductsTag />
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_admin.jsp" />
<jsp:include page="/includes/footer.jsp" />
