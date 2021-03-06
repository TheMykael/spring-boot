package br.com.alura.forum.controller;

import java.net.URI;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 8d20120058d7729b68641a7af43324c6d512cae8
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
=======
<<<<<<< HEAD
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
=======
<<<<<<< HEAD
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
=======
<<<<<<< HEAD
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
=======
<<<<<<< HEAD
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
=======
<<<<<<< HEAD
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
=======
<<<<<<< HEAD
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
=======
<<<<<<< HEAD
>>>>>>> bbf2bbea1e0116e0e609cb171910bee197b9e690
>>>>>>> 700a712bcca54c8f26d7c12b7bd7ab04f79af085
>>>>>>> 55c94f6c05b730a7c5f31dcb4a8b24994c5b5584
>>>>>>> 4894220b423d44d7ad4622fc20590b6c35e7863e
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
>>>>>>> 26a32ea4127a1a1aa3daa2e86004e0f006f6c7d1
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
=======
>>>>>>> 8d20120058d7729b68641a7af43324c6d512cae8
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> 8d20120058d7729b68641a7af43324c6d512cae8
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
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	@Transactional
<<<<<<< HEAD
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
=======
<<<<<<< HEAD
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
=======
<<<<<<< HEAD
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
=======
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
>>>>>>> 26a32ea4127a1a1aa3daa2e86004e0f006f6c7d1
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form,
			UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}")
				.buildAndExpand(topico.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	//Read
	@GetMapping
<<<<<<< HEAD
	@Cacheable(value = "listaDeTopicos")
=======
<<<<<<< HEAD
	@Cacheable(value = "listaDeTopicos")
=======
<<<<<<< HEAD
	@Cacheable(value = "listaDeTopicos")
=======
<<<<<<< HEAD
	@Cacheable(value = "listaDeTopicos")
=======
<<<<<<< HEAD
	@Cacheable(value = "listaDeTopicos")
=======
<<<<<<< HEAD
	@Cacheable(value = "listaDeTopicos")
=======
<<<<<<< HEAD
	@Cacheable(value = "listaDeTopicos")
=======
<<<<<<< HEAD
>>>>>>> bbf2bbea1e0116e0e609cb171910bee197b9e690
>>>>>>> 700a712bcca54c8f26d7c12b7bd7ab04f79af085
>>>>>>> 55c94f6c05b730a7c5f31dcb4a8b24994c5b5584
>>>>>>> 4894220b423d44d7ad4622fc20590b6c35e7863e
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
>>>>>>> 26a32ea4127a1a1aa3daa2e86004e0f006f6c7d1
	public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso,
			@PageableDefault(sort = "id", direction = Direction.ASC) Pageable paginacao) {

		
		if (nomeCurso == null) {
			Page<Topico> topicos = topicoRepository.findAll(paginacao);
			return TopicoDto.converter(topicos);
		} else {
			Page<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso, paginacao);
=======
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {			
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
>>>>>>> 8d20120058d7729b68641a7af43324c6d512cae8
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
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
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
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable("id") Long id) {
		Optional<Topico> optionalTopico = topicoRepository.findById(id);
		if (optionalTopico.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
