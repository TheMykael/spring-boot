package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
<<<<<<< HEAD
import io.jsonwebtoken.Claims;
=======
>>>>>>> 55c94f6c05b730a7c5f31dcb4a8b24994c5b5584
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
=======
>>>>>>> 55c94f6c05b730a7c5f31dcb4a8b24994c5b5584
	
}
