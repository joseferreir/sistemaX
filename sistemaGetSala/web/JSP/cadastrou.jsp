<%-- 
    Document   : cadastrou
    Created on : 30/01/2016, 12:32:09
    Author     : José
--%>

<%@page import="br.edu.ifpb.medelo.Usuario"%>
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
