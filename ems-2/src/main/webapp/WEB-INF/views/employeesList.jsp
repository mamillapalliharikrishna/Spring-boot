<%@taglib    uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<a    href="getEmployeePage">Add  Employee</a>  <br> <br>
<table  border="1">
    <tr>
        <th>Empid</th>  <th>Empname</th> <th>Age </th> <th>Salary </th> <th> Actions </th>
   </tr>  
   <c:if    test="${!empty   employees}">
            <c:forEach     items="${employees}"    var="emp">
                     <tr>
                          <td><c:out  value="${emp.empid}"/></td>
                          <td><c:out  value="${emp.empname}"/></td>
                          <td><c:out  value="${emp.age}"/></td>
                          <td><c:out  value="${emp.salary}"/></td>
                          <td>
                                 <a    href="editEmployeePage?empid=${emp.empid}">Edit </a>
                                 &nbsp; &nbsp; &nbsp;
                                 <a    href="deleteEmployee?empid=${emp.empid}"> Delete </a>
                         </td>
                   </tr>
            </c:forEach>
   </c:if>      
   </table>                
   
   <a   href="logout"> logout</a>                                                                     
             
