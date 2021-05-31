package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
<<<<<<< HEAD
import io.jsonwebtoken.Claims;
=======
<<<<<<< HEAD
import io.jsonwebtoken.Claims;
=======
<<<<<<< HEAD
import io.jsonwebtoken.Claims;
=======
<<<<<<< HEAD
import io.jsonwebtoken.Claims;
=======
<<<<<<< HEAD
import io.jsonwebtoken.Claims;
=======
>>>>>>> 55c94f6c05b730a7c5f31dcb4a8b24994c5b5584
>>>>>>> 4894220b423d44d7ad4622fc20590b6c35e7863e
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
>>>>>>> 26a32ea4127a1a1aa3daa2e86004e0f006f6c7d1
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secretKey;

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API do Fórum da Alura")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4894220b423d44d7ad4622fc20590b6c35e7863e
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
>>>>>>> 26a32ea4127a1a1aa3daa2e86004e0f006f6c7d1

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser()
			.setSigningKey(this.secretKey)
			.parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser()
		.setSigningKey(this.secretKey)
		.parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> 55c94f6c05b730a7c5f31dcb4a8b24994c5b5584
>>>>>>> 4894220b423d44d7ad4622fc20590b6c35e7863e
>>>>>>> 6fc1e2b1efea72d0fff32e3d95e400a84cb361e9
>>>>>>> e3901d6bd8aae9b6b156df7cda90814c63fe1cd3
>>>>>>> 26a32ea4127a1a1aa3daa2e86004e0f006f6c7d1
	
}
