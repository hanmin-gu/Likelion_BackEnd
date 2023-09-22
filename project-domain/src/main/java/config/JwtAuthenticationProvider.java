package config;

import Util.Aes256Util;
import common.UserType;
import common.UserVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Objects;

public class JwtAuthenticationProvider {
    private String secretKey = "secretKey";
    private long tokenValidTime = 1000L * 60 * 60 * 24;
    public String createToken(String userPk, Long id, UserType userType){
        Claims claims = Jwts.claims().setSubject(Aes256Util.encrypt(userPk)).setId(Aes256Util.encrypt(id.toString()));
        claims.put("roles", userType);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
    public boolean validateToken(String jwtToken){

        System.out.println(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken));
        try{
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claimsJws.getBody().getExpiration().before(new Date());
        }catch (Exception e){
            return false;
        }
    }
    public UserVo getUserVo(String token){
        Claims c = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        System.out.println(c.getId());
        System.out.println(Aes256Util.decrypt(c.getId()));
        System.out.println(Aes256Util.decrypt(c.getSubject()));
        //Aes256Util.decrypt(c.get)
        return new UserVo(Long.valueOf(Objects.requireNonNull(Aes256Util.decrypt(c.getId()))), Aes256Util.decrypt(c.getSubject()));
    }
}

