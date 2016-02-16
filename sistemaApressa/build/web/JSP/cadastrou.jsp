

<%@page import="br.edu.ifpb.valueObjects.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Usuario  username =(Usuario) session.getAttribute("user");
if(username!=null)
    return;
session.setAttribute("user",username);
System.out.print(username);
String nome = username.getNome();
     
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>Bem-vindo: <%=nome%> <p>
    </body>
</html>
