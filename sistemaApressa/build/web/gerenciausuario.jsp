<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="br.edu.ifpb.DAO.UsuarioAdmDAO"%>
<%@page import="br.edu.ifpb.valueObjects.Usuario"%>
<html lang="PT-BR">  <!--  -->
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html">
        <meta http-equiv="refresh" content="200">
        <meta name="author" content="Zilderlan Leite, Ferreira, Aluisio Pereira">
        <meta name="" content="">
        <meta name="" content="">
        <title>Gerenciamento de Usuários</title>

        <%
            Usuario usuario = (Usuario) session.getAttribute("user");
        %>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style type="text/css">
            @import "css/jquery.dataTables.css";
        </style>
        <script src="js/ajax.js"></script>
        <script src="js/tabela.js"></script>
        <script src="js/jquery.js"></script>
        <script  src="js/jquery.dataTables.js"></script>
        <script>
            $(document).ready(function () {
                $('#tb').dataTable();
            });

//            function redireciona('.remove'){
//                location.href = 'ServletExcluirUsuario';
//                alert('inok');
//            };

        </script>


    </head>




    <header> <!--  -->

        <div class="content-top">
            <div class="content-left">
                <h2> SistemaApressa</h2>
                <img src="img/logo-ifpb.png" title="foto perfil">
                <h3> Logado <code><%  out.print( usuario.getPapel()); %></code></h3>

            </div>

            <div class="content-right">
                <h3> <%  out.print( usuario.getNome()); %></h3>
                <img src="img/profiles/reader-default.png">
                <ul >
                    <li><a href="#" class="perfil">Editar Perfil</a></li>
                    <li><a href="logout" class="exit">Sair</a></li>
                </ul>

            </div>

        </div>

        <div class="content-bottom" >
            <button type="button" class="edit" id="" onclick="document.getElementById('user-add').style.display = 'block';">
                <img src="img/add.jpg" title="">
            </button>
            <button type="button" class="edit" id="" onclick="document.getElementById('user-update').style.display = 'block';">           			
                <img src="img/edit.jpg" title>
            </button>
            <form action="#" method="post" class="delete-user">
                <input class='formContato' type='text' name='delete' id='delete' value='Assunto' onchange="alteraDiv()">

                <button class="remove" type="submit"  >
                    <img src="img/remove.png" title="">
                </button>

            </form>

        </div>


    </header>

    <article>


        <!-- -->
        <section id="user-add">


            <form action="CadastroUser " method="post" id=""class="form-add">
                <img src="img/profiles/reader-default.png" title="" class="photo">
                <h4>Carregar Foto</h4>
                <input type="file" name="foto"  class="btn-file" id="btn-file" onchange="document.getElementById('file-falso').value = this.value;">
                <label class="name">Nome de Usuário</label>
                <input for=" " type="text" name="name" placeholder="Ex:Antonio Marques" class="" id="name">  

                <label class="senha" >Senha</label>
                <input for=" " type="password" name="senha" placeholder="Ex: Anderc4ma5" class="" id="senha"> 

                <label class="email" >Email</label>
                <input  type="email" placeholder="Ex: zilderlan@meuemail.com" name="email" id="email"> 

                <label class="matricula" >Matricula</label>
                <input  type="text" placeholder="Ex: 123456" name="matricula" id="matricula"> 

                <label class="tipo" >Tipo</label>
                <select  type="select" name="papel"  id="papel" > 
                    <option value="">Selecione</option>
                    <option value="ADMISTRAD0R">admin</option>
                    <option value="ALUNO">aluno</option>
                    <option value="ASSISTENTE_SALA">assistente de sala</option>
                    <option value="PROFESSOR">professor</option>
                    <option value="MONITOR">monitor</option>
                </select>


                <input for=" " type="button" name="" value="Cancelar" class="cancel" id="" onclick="document.getElementById('user-add').style.display = 'none';"> 
                <input for=" " type="submit" name="" value="Cadastrar" class="submit" id="">       		
            </form >

        </section>

        <section id="user-update">
            <div class="modal-body">
<form action="EditaUsuario" method="post" id=""class="form-update">
    <img src="img/profiles/reader-default.png" title="" class="photo">
                <h4>Carregar Foto</h4>
                <input type="file" name="foto"  class="btn-file" id="btn-file" onchange="document.getElementById('file-falso').value = this.value;">
                <label class="name">Nome de Usuário</label>
                <input for=" " type="text" name="name" placeholder="Ex:Antonio Marques" class="" id="name">  

                <label class="senha" >Senha</label>
                <input for=" " type="password" name="senha" placeholder="Ex: Anderc4ma5" class="" id="senha"> 

                <label class="email" >Email</label>
                <input  type="email" placeholder="Ex: zilderlan@meuemail.com" name="email" id="email"> 

                <label class="matricula" >Matricula</label>
                <input  type="text" placeholder="Ex: 123456" name="matricula" id="matricula"> 

                <label class="tipo" >Tipo</label>
                <select  type="select" name="papel"  id="papel" > 
                    <option value="">Selecione</option>
                    <option value="ADMISTRAD0R">admin</option>
                    <option value="ALUNO">aluno</option>
                    <option value="ASSISTENTE_SALA">assistente de sala</option>
                    <option value="PROFESSOR">professor</option>
                    <option value="MONITOR">monitor</option>
                </select>


                <input for=" " type="button" name="" value="Cancelar" class="cancel" id="" onclick="document.getElementById('user-add').style.display = 'none';"> 
                <input for=" " type="submit" name="" value="Cadastrar" class="submit" id="">     		
        	</form >
               
        </section>

        <section clas="user-table">

            <div class="table">
                <table id="tb">
                    <thead>
                        <tr class="tr">
                            <th>Matricula</th>
                            <th>Nome</th>
                            <th>E-mail</th>
                            <th>papel</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            UsuarioAdmDAO queryUsuario = new UsuarioAdmDAO();
                            List<Usuario> usuarios = queryUsuario.buscaTotosUsuarios();

                            Collections.sort(usuarios);

                            for (Usuario u : usuarios) {
                                out.print("<tr onclick=\"displayData(" + ")\" >");
                                out.print("<th>" + u.getMatricula() + "</th>");
                                out.print("<th>" + u.getNome() + "</th>");
                                out.print("<th>" + u.getEmail() + "</th>");
                                out.print("<th>" + u.getPapel().name() + "</th>");
                                out.print("<th>" + u.getStatus() + "</th>");
                                out.print("</tr>");
                            }
                        %>
                    </tbody>
                </table>
              
                <!--        		 
                       
                                        </tbody>
                
                                </table>
                            </div>
                
                        </section>
                        </article>
                    </body>
                </html>