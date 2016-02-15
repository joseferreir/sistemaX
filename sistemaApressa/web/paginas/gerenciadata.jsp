<%-- 
    Document   : gerenciadata
    Created on : 01/02/2016, 19:10:32
    Author     : Zilderlan
--%>

<%@page import="br.edu.ifpb.valueObjects.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="PT-BR">  <!--  -->
    <head>
        <%
            Usuario u =(Usuario) session.getAttribute("user");
        %>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <meta http-equiv="refresh" content="200">
        <meta name="author" content="Zilderlan Leite,Jose Ferreira, Aluisio Pereira">
        <meta name="" content=" ">
        <meta name="" content="">
        <title>Gerenciamento de Usuários</title>
        
        
        <link rel="stylesheet" href="../css/style.css" type="text/css">
        <style type="text/css">
            @import "../css/jquery.dataTables_1.css";
        </style>
        <script src="../js/ajax.js"></script>
        <script src="../js/tabela.js"></script>
        <script src="../js/jquery.js"></script>
        <script  src="../js/jquery.dataTables.js"></script>
    <script>
        $(document).ready(function(){
            $('#tb').dataTable();
        });
                
                function redireciona('.remove'){
                    location.href='ServletExcluirUsuario';
                    alert('inok');
                }
    </script>
        
        
    </head>

    


        <header> <!--  -->

                <div class="content-top">
                <div class="content-left">
                    <h2>  SistemaApressa </h2>
                    
                    <img src="../img/logo-ifpb.png" title="foto">
                    <h3> Logado como <code><%out.print(u.getPapel());%></code></h3>

                </div>

                <div class="content-right">
                    <h3> <% out.print(u.getNome()); %></h3>
                    <img src="../img/user.jpg" title="Foto do usuário">
                    <ul >
                        <li><a href="" class="perfil">Editar Perfil</a></li>
                        <li><a href="" class="exit">Sair</a></li>
                    </ul>

                </div>

            </div>



        </header>

        <article>
        <section> 
            <div class="content-bottom" >
            <button type="button" class="add" id="" onclick="document.getElementById('holiday-add').style.display='block';">
                <img src="../img/add.jpg" title="">
            </button>
            <button type="button" class="edit" id="" onclick="document.getElementById('holiday-add').style.display='block';">                       
                <img src="../img/edit.jpg" title>
            </button>
            <form action="ServletExcluirUsuario" method="post" class="delete-user">
                <input class='formContato' type='text' name='delete' id='delete' value='Assunto' onchange="alteraDiv()">

                <button class="remove" type="submit"  >
                    <img src="../img/remove.png" title="">
                </button>
                    
            </form>

            </div>
            <div class="">
                <input type="button" value="Importar" class="import" id="" onclick="document.getElementById('date-import').style.display='block';">
            </div>
        </section>
                
        <!-- -->
       <section id="holiday-add">
            <h4>Inserir Feriado</h4>
            <form action="CadastraFeriado" method="post" id="addFeriado "class="">
                <label class="label-holiday" >Nome do Feriado</label>
                <input  type="text" placeholder="Ex: Dia das Mães" name="name" id="name-holiday"> 
                <label id="label-holiday" >Data</label>
                <input  type="text" placeholder="Ex: 09/09/1900" name="data" id="holiday"> 
                <input for=" " type="button" name="" value="Cancelar" class="cancel" id="" onclick="document.getElementById('holiday-add').style.display='none';"> 
                <input for=" " type="submit" name="" value="Cadastrar" class="submit" id="">            
            </form >
        </section>

        <section style="margin: 10% 0 5% 2%")>
            <p> Aluísio coloque o Calendário aqui</p>
            <p> Aluísio coloque o Calendário aqui</p>
            <p> Aluísio coloque o Calendário aqui</p>
            <p> Aluísio coloque o Calendário aqui</p>
            <p> Aluísio coloque o Calendário aqui</p>
            <p> Aluísio coloque o Calendário aqui</p>
            <p> Aluísio coloque o Calendário aqui</p> 
        </section>


        <section id="date-import">
            <h4> Importar Feriado</h4>
            <form action="importarferiados" method="post" id=""class=""> 
                <label class="name-fe" >Nome do feriado</label>
                <input for=" " type="text" name="" placeholder="Ex: Dia das Mães" class="" id="import-fe"> 
                <input for=" type="file"  name="" class="" id="select-fe"> 
                <h5>SObrescrever Feriado</h5>
                <input type="checkbox" name="sobrescrever" id="check">

                
                <input for=" " type="button" name="" value="Cancelar" class="cancel" id="" onclick="document.getElementById('date-import').style.display='none';"> 
                <input for=" " type="submit" name="" value="Cadastrar" class="submit" id="">            
            </form >
        </section>

      
        </article>
    </body>
</html>

