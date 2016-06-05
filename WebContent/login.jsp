<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.BeanLogin" %>
   

<script type="text/javascript" src="jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="jquery/jquery.validate.js"></script>
<script>
$(document).ready(function(){
    $("#registerForm").validate({
    	submitHandler: function(form) {
    		$('#content').load('logincontroller',$("#registerForm").serialize());
    	},
        rules: {
        	nickname: "required",
    	    contraseña: "required"
        }
    });
}

);
</script>
</head>
<body>

<% 
BeanLogin login = null;
if (request.getAttribute("login")!=null) {
	login = (BeanLogin)request.getAttribute("login");
}
else {
	login = new BeanLogin();
}
%>

<form id=registerForm action="" method="POST">
<table>
<tr> 
<td> Nickname </td> 
<td> <input type="text" name="nickname" value="<%=login.getNickname() %>" id="nickname" class="required" minlength="3" maxlength="16"/> </td>
</tr>
<td> Contraseña </td>
<td> <input type="password" name="contraseña" value = "" id="contraseña" minlength="6" maxlength="16"/> </td>
<tr> 
<td> <input name="sumbit" type="submit" value="Enviar"> </td>
</tr>
</table>
<% 	
	if ( login.getError()[0] == 1) {
		%> 
		<td class="error"> The user or the password are not correct! Check the inputs. </td>  
		<% 
	}
%>
</form>