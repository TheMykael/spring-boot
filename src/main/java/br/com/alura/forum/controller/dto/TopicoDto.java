package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
<<<<<<< HEAD

import org.springframework.data.domain.Page;
=======
import java.util.List;
import java.util.stream.Collectors;
>>>>>>> 8d20120058d7729b68641a7af43324c6d512cae8

import br.com.alura.forum.modelo.Topico;

public class TopicoDto {
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto() {
		
	}
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

<<<<<<< HEAD
	public static Page<TopicoDto> converter(Page<Topico> topicos) {
		return topicos.map(TopicoDto::new);
=======
	public static List<TopicoDto> converter(List<Topico> topicos) {
		return topicos.stream()
					.map(TopicoDto::new)
					.collect(Collectors.toList());
>>>>>>> 8d20120058d7729b68641a7af43324c6d512cae8
	}

}
