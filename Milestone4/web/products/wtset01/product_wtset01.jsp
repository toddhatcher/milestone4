<%-- 
    Document   : product_wtset01.jsp
    Created on : Oct 12, 2021, 12:11:40 AM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021
--%>

<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_default.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="allAboutToysURI" prefix="tch" %>
<!-- start the middle column -->

<section>
    <h2>Product Page - WTSET01</h2>
    <img src="<c:url value='/images/toy_trains_figure8_rail_track_set.png' />" width="80" 
         alt="Wood Train worth $249.99">
    <h3>Our featured figure 8 track and train set</h3>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_default.jsp" />
<jsp:include page="/includes/footer.jsp" />