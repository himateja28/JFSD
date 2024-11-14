package klu.model;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	public final String SECRET_key = "iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAApgAAAKYB3X3/OAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5";
	public final SecretKey key = Keys.hmacShaKeyFor(SECRET_key.getBytes());
	
	public String generateToken(String username)
	{
		Map<String, String>data = new HashMap<String, String>();
		data.put("username", encryptData(username));
		
		long milisecondperday = 86400000;
		
		return Jwts.builder()
				.setClaims(data)
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+milisecondperday))
				.signWith(key)
				.compact();
	}
	
	public String validateToken(String token)
	{
		Claims claims = Jwts.parserBuilder()
							.setSigningKey(key)
							.build()
							.parseClaimsJws(token)
							.getBody();
		Date exp = claims.getExpiration();
		if(exp == null|| exp.before(new Date()))
			return "JWT token expired";
		Map<String, String> data = new HashMap<String, String>();
		data.put("username", decryptData(claims.get("username").toString()));
		return data.toString();
	}
	
	public String encryptData(String data)
	{
		try {
			
			MessageDigest MD = MessageDigest.getInstance("SHA-256");
			byte[] keyBytes = MD.digest(SECRET_key.getBytes());
			SecretKey cryptokey = new SecretKeySpec(keyBytes, "AES");
			
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, cryptokey);
			
			byte[] encryptedBytes = cipher.doFinal(data.getBytes());
			
			return Base64.getEncoder().encodeToString(encryptedBytes);
			
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String decryptData(String data)
	{
		try {
			MessageDigest MD =MessageDigest.getInstance("SHA-256");
			byte[] keyBytes = MD.digest(SECRET_key.getBytes());
			SecretKey cryptokey = new SecretKeySpec(keyBytes, "AES");
			
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, cryptokey);
			byte[] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(data.getBytes()));
			return new String(decryptBytes);
		} 
		catch (Exception e)
		{
			return e.getMessage();
		}
	}
}
