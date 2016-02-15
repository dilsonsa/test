package org.fiveware.controller;

import javax.servlet.http.HttpServletResponse;

import org.fiveware.beans.Cliente;
import org.fiveware.builder.ClienteBuilder;
import org.fiveware.model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CadastroController {
    @Autowired
	private ClienteBuilder clienteBuilder;
    @Autowired
    private ClienteModel model;
    
    


	@RequestMapping(value = "cadCliente", method = RequestMethod.GET)
	public void cadastra(HttpServletResponse response,String nome, String tipoLogradouro, String logradouro, String numero, String bairro,
			String estado, String cidade, String celularNumero, String fixoNumero) {

		Cliente cliente = clienteBuilder.comNome(nome).comTipoLogradouro(tipoLogradouro).comLogradouro(logradouro)
				.comNumero(numero).comBairro(bairro).comEstado(estado).comCidade(cidade).comCelular(celularNumero)
				.comTelefoneFixo(fixoNumero).constroi();
		
		model.cadastra(cliente);
		
		response.setStatus(200);
		
	}

}
