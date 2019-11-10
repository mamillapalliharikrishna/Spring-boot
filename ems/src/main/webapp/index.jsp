<%@taglib    uri="http://java.sun.com/jsp/jstl/core"     prefix="c" %>
<c:if    test="${message  != null}">
       <h2> <c:out   value="${message }"/> </h2>
</c:if>
<hr>
  <center>
           <a    href="getEmployeePage">Add  Employee</a>  <br> <br>
            <a   href="listEmployees">   List   Employees </a>
  </center>