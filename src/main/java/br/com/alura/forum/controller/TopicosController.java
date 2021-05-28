package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	//Create
	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}")
				.buildAndExpand(topico.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	//Read
	//Este método pode opcionalmente receber o nome do curso como uma query na requisição
	//e listar de acordo
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {			
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		
	}
	
	//Read
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable("id") Long id) {
		Optional<Topico> optionalTopico = topicoRepository.findById(id);
		if (optionalTopico.isPresent()) {			
			return ResponseEntity.ok(new DetalhesDoTopicoDto(optionalTopico.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//Update
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable("id") Long id,
			@RequestBody @Valid AtualizacaoTopicoForm form) {
		Optional<Topico> optionalTopico = topicoRepository.findById(id);
		if (optionalTopico.isPresent()) {
			Topico topico = form.atualizar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoDto(topico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	//Delete
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable("id") Long id) {
		Optional<Topico> optionalTopico = topicoRepository.findById(id);
		if (optionalTopico.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
