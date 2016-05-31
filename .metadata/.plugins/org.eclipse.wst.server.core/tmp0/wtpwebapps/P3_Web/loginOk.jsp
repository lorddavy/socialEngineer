
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
$(document).ready(function() {
        $('#navigation').load('menu.jsp');   
});
</script>

<% 
HttpSession session = request.getSession(false);
String nickname = "Error";
String mail = "Error";
String Sexo = "Error";
if(session != null) {
if(session.getAttribute("nickname")!=null){
	nickname = (String)session.getAttribute("nickname");
}
else{
	nickname = "Error";
}

if(session.getAttribute("mail")!=null){
	mail = (String)session.getAttribute("mail");
}
else{
	mail = "Error";
}

if(session.getAttribute("sexo")!=null){
	if((int)session.getAttribute("sexo") == 0){
		Sexo = "Hombre";
	}else{
		Sexo = "Mujer";
	}
	
}
else{
	Sexo = "Error";
}
}
%>

<p>Información de usuario:</p><br>

<table>
<tr> 
<td> Nickname&nbsp</td> <td>&nbsp <%=nickname%> </td>
</tr>

<tr> 
<td> Correo Electrónico&nbsp</td> <td>&nbsp <%=mail%> </td>
</td>
</tr>

<tr> 
<td> Sexo&nbsp</td> <td>&nbsp <%=Sexo%> </td>
</td>
</tr>

</table>
