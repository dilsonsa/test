<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Fiveware Test | Marcelo Toyoda</title>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
</head>
<body>    
    <div class="container">
    	<h1>Formulário de Cadastro de Usuários</h1>
    	<form id="form-cadastro" action="person/save" method="post">
    	   <div class="form-group">
			    <label for="nome">Nome</label>
			    <input type="text" class="form-control" id="name" name="name" placeholder="Digite Nome">
		   </div>
		   <fieldset class="form-group">
			    <legend>Sexo</legend>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="radio" class="form-check-input" name="gender" id="genderMasc" value="MASCULINO" checked>
			        Masculino
			      </label>
			    </div>
			    <div class="form-check">
			    <label class="form-check-label">
			        <input type="radio" class="form-check-input" name="gender" id="genderFem" value="FEMININO">
			        Feminino
			      </label>
			    </div>			    
  		  	</fieldset>
		    <div class="form-group">
			    <label for="departments">Selecione o Departamento</label>
			    <select class="form-control" id="departments" name="department">
			     <c:forEach items="${departments}" var="department">
			     	<option value="${department.id}">${department.name}</option>
			     </c:forEach>			      			      
			    </select>
		   </div>
		   <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" name="sports" class="form-check-input" value="Futebol">
			        Futebol
			    </label>
  			</div>
  			<div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" name="sports" class="form-check-input" value="Musculação">
			        Musculação
			    </label>
  			</div>
  			<div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" name="sports" class="form-check-input" value="Natação">
			        Natação
			    </label>
  			</div>
  			<button type="button" id="btnCadastro" class="btn btn-primary">Cadastrar</button>		   
    	</form>
    </div>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#btnCadastro").click(function(event) {
				event.preventDefault();
				var url = $("#form-cadastro").attr('action');
				$("#btnCadastro").prop("disabled", true);

				$.post(url, {
					name : $('#name').val(),
					gender : $('input[name="gender"]:checked').val(),
					sports : $('input[name="sports"]:checked').map(function () {return this.value;}).get().join(","),
					department : $('#departments').val()
				}).complete(function() {
					$("#btnCadastro").prop("disabled", false);
				});
			});
		});
	</script>
</body>
</html>