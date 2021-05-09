package leite.aquilla.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	private static final String[] ROUTE_PUBLIC = {"/hr-oauth/oauth/token"};
	private static final String[] ROUTE_OPERATOR = {"/hr-worker/**"};
	private static final String[] ROUTE_ADMIN = {"/hr-payroll/**", "/hr-user/**", "/actuator/**", "hr-oauth/actuator/**"};
	
	JwtAccessTokenConverter jwtAccessTokenConverter;
	JwtTokenStore jwtTokenStore;
	
	@Autowired
	public ResourceServerConfig(JwtAccessTokenConverter jwtAccessTokenConverter, JwtTokenStore jwtTokenStore) {
		super();
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
		this.jwtTokenStore = jwtTokenStore;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(jwtTokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(ROUTE_PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, ROUTE_OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
		.antMatchers(ROUTE_ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
	}
}