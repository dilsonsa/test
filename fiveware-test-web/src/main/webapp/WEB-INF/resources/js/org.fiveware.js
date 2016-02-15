// requisição ajax para cadastrar cliente

var cadastraAjax = function() {

	$.get("cadCliente", {
		nome : $("input[name=nome]").val(),
		tipoLogradouro : $("input[name=tipoLogradouro]").val(),
		logradouro : $("input[name=logradouro]").val(),
		numero : $("input[name=numero]").val(),
		bairro : $("input[name=bairro]").val(),
		estado : $("input[name=estado]").val(),
		cidade : $("input[name=cidade]").val(),
		celularNumero : $("input[name=celularNumero]").val(),
		fixoNumero : $("input[name=fixoNumero]").val()
	}, function(resposta) {
		$("#mensagem").html("Cadastro Efetuado com sucesso!");
	});
};