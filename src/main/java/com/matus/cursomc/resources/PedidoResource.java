package com.matus.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matus.cursomc.domain.Pedido;
import com.matus.cursomc.services.PedidoService;

@RestController // Criou umas classe Rest
@RequestMapping(value="/pedidos")// O URL q vai ser usado /categirias
public class PedidoResource {
	
	//---------A classe REST vai acessar o servico (private PedidoService service)---------
	@Autowired
	private PedidoService service;
	
	//value="/{id}" ==> Agoro o url vai ser: /categirias/IdQueForPassadoParaBuscar
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //se for colocar algo POST, deletar DELETE, etc
	
	// ResponseEntity<?> ==> Coisa do Spring, armazena varias informacoes de uma respota HTTP para o servico REST
	// @PathVariable ==> Fala q o Integer id vai ser id da URL (value="/{id}") 
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}