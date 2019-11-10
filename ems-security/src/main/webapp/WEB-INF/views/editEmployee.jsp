<%@taglib    uri="http://www.springframework.org/tags/form"     prefix="form"%>

<form:form     action="updateEmployee"     method="post"      modelAttribute="e">
<table>
    <tr>
         <td>Empid</td>
         <td><form:input    path="empid"       readonly="true"/> </td>
   </tr>
   <tr>
         <td>Empname</td>
         <td><form:input    path="empname" /> </td>
   </tr>
   <tr>
         <td>Age</td>
         <td><form:input    path="age"  /> </td>
   </tr>
   <tr>
         <td>Salary</td>
         <td><form:input    path="salary"  /> </td>
   </tr>
   <tr>
         <td colspan="2">
             <input    type="submit"       value="submit">
        </td>             
   </tr>
            
</table>
</form:form>