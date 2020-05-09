<!DOCTYPE html>
<%@page import="br.com.urbano.domain.Usuario"%>
<%@page import="java.util.List"%>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Cadastro de Login</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
  <link rel="stylesheet" type="text/css" href="./css/style.css" />  
</head>

<body>

 <!--FORMULÁRIO DE CADASTRO-->
      <div id="cadastro">
        <form method="post" action="usuario"> 
          <h1>Cadastro</h1> 
          
          <p> 
            <label for="nome_cad">Seu nome</label>
            <input id="nome_cad" name="nome" required="required" type="text" placeholder="Informe seu Nome" />
          </p>
          
          <p> 
            <label for="email_cad">Seu e-mail</label>
            <input id="email_cad" name="email" required="required" type="email" placeholder="contato@ivia.com"/> 
          </p>
          
          <p> 
            <label for="senha_cad">Sua senha</label>
            <input id="senha_cad" name="senha" required="required" type="password" placeholder="1234"/>
          </p>
          
          <p> 
            <input type="submit" value="Cadastrar"/> 
          </p>          
    
        </form>
      </div>      

</body>
</html>