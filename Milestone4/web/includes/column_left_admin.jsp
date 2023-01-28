<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarA">
    <nav>
        <h3>Admin Tools</h3>
        <ul>
          <li><a href="<c:url value='/admin/display_data.jsp' />">
                  Display Data</a></li>
          <li><a class="current" href="<c:url value='/admin/load_data.jsp' />">
                  Load Data</a></li>
          <li><a href="<c:url value='/admin/drop_data.jsp' />">
                  Drop Data</a></li>
          <!--
          <li><a href="<c:url value='/email' />">
                  Join Email List</a></li>
          <li><a href="<c:url value='/customer_service' />">
                  Customer Service</a></li>
          -->
         
      </ul>
    </nav>
</aside>