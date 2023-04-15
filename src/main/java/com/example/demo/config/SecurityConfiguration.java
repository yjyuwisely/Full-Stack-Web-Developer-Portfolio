package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserService;

@Configuration // 스프링의 환경설정 파일임을 의미하는 애너테이션
@EnableWebSecurity // 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	/* 패스워드 암호화 전용, 동일한 메시지도 매번 다르게 암호화 생성, 복호화 불가, 올바르게 암호환 된 것인지만 확인 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests() // I added: "/","/index**","assets/images/**", "/videos/**","/login?error, "/profile**"
				// 폴더를 login 없이 허용
				.antMatchers("/", "/index**", "/assets**", "/registration**", "/js/**", "/css/**", "/assets/images/**",
						"/videos/**", "/login?error", "/profile**").permitAll()
				// 그 외 모든 요청은 인증과정 필요
				.anyRequest().authenticated().and().formLogin().loginPage("/login")
				// .defaultSuccessUrl("/index", true) // I added: redirect to index.html. After a successful login, any user will be redirected to index.html.
				// .failureUrl("/login")
				.permitAll()
				.and().logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
				.permitAll();

	}

}