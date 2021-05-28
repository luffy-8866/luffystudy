package com.luffy;

import static org.junit.Assert.assertTrue;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test()
    {
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置id  {“jti”：“8888”}
                .setId("8888")
                //签发用户 {"sub"："admin"}
                .setSubject("admin")
                //签发时间 {"iat":"xxx"}
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "123456");
        String compact = jwtBuilder.compact();
        System.out.println(compact);
    }

    @Test
    public void parseToken()
    {
        long l = System.currentTimeMillis();
        long now =l+60*1000;

        JwtBuilder jwtBuilder = Jwts.builder()
            //设置id  {“jti”：“8888”}
            .setId("8888")
            //签发用户 {"sub"："admin"}
            .setSubject("admin")
            //签发时间 {"iat":"xxx"}
            .setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "123456")
            .setExpiration(new Date(now));
        String compact = jwtBuilder.compact();

        Claims body = Jwts.parser()
                .setSigningKey("123456")
                .parseClaimsJws(compact)
                .getBody();
        System.out.println(body.toString());
    }

    @Test
    public void diyParseToken()
    {
        long l = System.currentTimeMillis();
        long now =l+60*1000;
        Map<String, Object> map = new HashMap<>();
        map.put("logo","1111");
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置id  {“jti”：“8888”}
                .setId("8888")
                //签发用户 {"sub"："admin"}
                .setSubject("admin")
                //签发时间 {"iat":"xxx"}
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "123456")
                .setExpiration(new Date(now))
                .setClaims(map);
        String compact = jwtBuilder.compact();
        Claims body = Jwts.parser()
                .setSigningKey("123456")
                .parseClaimsJws(compact)
                .getBody();
        System.out.println(body.toString());
    }
}
