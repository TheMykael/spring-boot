package br.com.alura.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.context.annotation.Profile;
=======
<<<<<<< HEAD
import org.springframework.context.annotation.Profile;
=======
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

import br.com.alura.forum.config.security.TokenService;
import br.com.alura.forum.controller.dto.TokenDto;
import br.com.alura.forum.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
<<<<<<< HEAD
@Profile(value = {"prod", "test"})
=======
<<<<<<< HEAD
@Profile(value = {"prod", "test"})
=======
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		try {			
			Authentication authentication = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
			
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
