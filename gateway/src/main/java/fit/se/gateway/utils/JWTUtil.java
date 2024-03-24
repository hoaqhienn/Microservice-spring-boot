package fit.se.gateway.utils;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
public static final String SECRET = "lehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghienlehoanghien";
	
	public void validateToken(final String token) {
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
