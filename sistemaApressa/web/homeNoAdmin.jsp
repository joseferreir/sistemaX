<%-- 
    Document   : home
    Created on : 27/01/2016, 16:59:14
    Author     : Zilderlan
--%>
<%@page import="javax.swing.JOptionPane"%>
<%--<%@page import="br.edu.ifpb.valueObjects.Usuario"%>--%>
<%@page import="br.edu.ifpb.valueObjects.Usuario"%>
<%
        Usuario usuario = (Usuario) session.getAttribute("user");
//        String a = usuario.getFoto();
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="PT-BR">  <!--  -->
    <head>
		<meta charset="UTF-8">
		
		<title>Home</title>
		
		<link rel="stylesheet" href="css/loginStyle.css" type="text/css" >
		<link rel="stylesheet" href="css/style.css" type="text/css">
		<script src="ajax.js"></script>
	<script src="tabela.js"></script>
	<script src="jquery.js"></script>
	<script  src="jquery.dataTables.min.js"></script>
		
		
    </head>

    


        <header> <!--  -->
        	<div class="content-top">
        		<div class="content-left">
        			<h2> SistemaApressa</h2>
                                <img src="img/logo-ifpb.png">
        			<h3> Logado <code><%  out.print( usuario.getPapel()); %></code></h3>

        		</div>

        		<div class="content-right">
        			<h3> </h3>
                                <img src="img/profiles/reader-default.png" alt="Foto">
                                <%out.print(usuario.getNome());%>
        			<ul >
        				<li><a href="" class="perfil">Editar Perfil</a></li>
        				<li><a href="logout" class="exit">Sair</a></li>
        			</ul>

        		</div>

        	</div>


        </header>

        <article class="sec">
        
	           	
        <!-- -->
        <section >
        <div class="function-user">
        <h3> Conjunto 1</h3>
        <ul>
            
            <li><a href="gerenciausuario.jsp"> X</a></li>
            <li><a href="">Funcionalidade Y</a></li>
            <li><a href="">Funcionalidade Z</a></li>
        </ul>
        </div>
       <div class="function-date">
        <ul>
        <h3> Conjunto 2</h3>
            <li><a href="">Funcionalidade A </a></li>
            <li><a href="">Funcionalidade W</a></li>
            <li><a href="">Funcionalidade D</a></li>
        </ul>
        </div>
        </section>        


        	
        </article>
    </body>
</html>
