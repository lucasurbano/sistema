<!DOCTYPE html>
<%@page import="domain.Usuario"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>usuario</title>
<script>
function confirma(pi){
	
	if (window.confirm("Tem certeza que deseja excluir?")){
		location.href="usuario?i="+ pi ;
	}
}
</script>

</head>

<body>


<div>

	<%
	Object msg=	request.getAttribute("msg");
	if (msg!=null){
		String msgStr = (String)msg;
		out.print(msg);
	}
	%>
</div>

<form method="post" action="usuario">
	E-mail:
	<input type="text" value="" name="nome" /> 

	<input type="submit" value="Save">

</form>

<%
List<Usuario>  lista =  (List<Usuario>)request.getAttribute("lista");
int i=0;
for (Usuario u: lista){
	out.print(u.getNome()+      "<a href='javascript:confirma("+i+")'>  excluir </a><br/>" );
	i++;
}
%>


</body>
</html>