<%@page   isELIgnored="false" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>    

<html>

<body  bgcolor="lightgrey">

     <c:if test="${errorMessage  ne  null}">
         <font  color='red'> ${errorMessage}</font>
     </c:if>
     
    
     <hr>
 
    <form  name="f"  action="login" method="POST">
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='username'></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
            </tr>
        </table>
         
      </form>

</body>
</html>