package br.com.fatesg.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.fatesg.eventos.util.TokenFilter;

@SpringBootApplication
public class EventosApp {
	
	@Bean
	public FilterRegistrationBean<TokenFilter> filtroJwt() {
		FilterRegistrationBean<TokenFilter> filterRegistrationBean = new FilterRegistrationBean<TokenFilter>();
		filterRegistrationBean.setFilter(new TokenFilter());
		filterRegistrationBean.addUrlPatterns("/restrito/*");
		
		return filterRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(EventosApp.class, args);
	}

}