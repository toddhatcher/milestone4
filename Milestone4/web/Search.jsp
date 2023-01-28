<%-- 
    Document   : Search.jsp
    Created on : Oct 11, 2021, 11:15:35 PM
    Author     : Todd Hatcher
    Assignment : 9.2
    Class      : CIS402-A349
    Date       : 10/12/2021

--%>
<jsp:include page="/includes/header.jsp" />
<%@ page import = "java.io.*"%>
<%@ page import = "javax.servlet.jsp.*"%>
<%@ page import = "javax.servlet.jsp.tagext.*"%>
<jsp:include page="/includes/column_left_default.jsp" />
<!-- start the middle column -->

<section>
    <h1>Search Results Page</h1>
    <p>You searched for: " 
    <%
        if(request.getMethod().equals("POST"))
        {
            String userSearch = request.getParameter("search");
            JspWriter output = pageContext.getOut();
            output.println(String.format("%s", userSearch));
        }
    %>
    "</p>
    
    
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_default.jsp" />
<jsp:include page="/includes/footer.jsp" />