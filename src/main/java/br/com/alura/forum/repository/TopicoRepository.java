package br.com.alura.forum.repository;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
import java.util.List;

>>>>>>> 8d20120058d7729b68641a7af43324c6d512cae8
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

<<<<<<< HEAD
	Page<Topico> findByCurso_Nome(String nomeCursoString, Pageable paginacao);
=======
	List<Topico> findByCurso_Nome(String nomeCurso);
>>>>>>> 8d20120058d7729b68641a7af43324c6d512cae8

}
