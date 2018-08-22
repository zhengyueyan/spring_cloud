package com.zyy.oauth2;

import com.zyy.oauth2.properties.OAuth2Properties;
import com.zyy.oauth2.util.JsonUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


@RestController
@Slf4j
@SpringBootApplication
public class Oauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2Application.class, args);
	}

	@Autowired
	private OAuth2Properties oAuth2Properties;

	@GetMapping("/user")
	public Object getCurrentUser1(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
		log.info("【SecurityOauth2Application】 getCurrentUser1 authenticaiton={}", JsonUtil.toJson(authentication));

		String header = request.getHeader("Authorization");
		String token = org.apache.commons.lang.StringUtils.substringAfter(header, "bearer ");

		Claims claims = Jwts.parser().setSigningKey(oAuth2Properties.getJwtSigningKey().getBytes("UTF-8")).parseClaimsJws(token).getBody();
		String blog = (String) claims.get("blog");
		log.info("【SecurityOauth2Application】 getCurrentUser1 blog={}", blog);

		return authentication;
	}

}
