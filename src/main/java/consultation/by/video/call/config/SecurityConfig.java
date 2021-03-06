package consultation.by.video.call.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import consultation.by.video.call.filter.JwtRequestFilters;
import consultation.by.video.call.model.enums.ListRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@EnableWebSecurity
@Configuration
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilters jwtRequestFilters;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private static final String[] publicEndpoint = {
            "/swagger-resources/**",
            "/swagger-ui/**", "/v2/api-docs",
            "/v3/api-docs",
            "/api/docs",
            "/api/docs/**",
            "/api/docs/swagger-ui",
            "/swagger-ui.html",
            "/**/swagger-ui/**",
            "/swagger-ui"            
    };

    //    === To Prevent Malicious String ===
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowSemicolon(true);
        firewall.setAllowBackSlash(true);
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }
    //    === End ===

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/register").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/login").permitAll()                
                .antMatchers(HttpMethod.GET,"/user/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/user/{id}").permitAll() //hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/user/me").permitAll()
                .antMatchers(HttpMethod.GET,"/user/filter").permitAll()
                .antMatchers(HttpMethod.POST,"/user/roles/{id}").permitAll()
                .antMatchers("https://s1-02-t-preview.netlify.app/").permitAll()
                .antMatchers(HttpMethod.POST,"/patient/api/v1/turn_patient").permitAll()                
                .antMatchers(HttpMethod.GET,"/patient/api/v1/patients").permitAll()
                .antMatchers(HttpMethod.GET,"/patient/api/v1/{id}").hasAnyAuthority("ROLE_PROFESSIONAL")
                .antMatchers(HttpMethod.GET,"/turn/api/v1/").permitAll()
                .antMatchers(HttpMethod.GET,"/turn/api/v1/turns/high").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/turn/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/firebase/uploadImage").permitAll()
                .antMatchers(HttpMethod.POST,"/profession").permitAll()
                .antMatchers(HttpMethod.GET,"/profession").permitAll()
                .antMatchers(HttpMethod.PUT,"/profession/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/profession/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/professional/register").permitAll()
                .antMatchers(HttpMethod.POST,"/professional/login").permitAll()
                .antMatchers(HttpMethod.GET,"/professional/all").permitAll()
                .antMatchers(HttpMethod.GET,"/professional/{idProfession}").permitAll()
                .antMatchers(HttpMethod.GET,"/professional").permitAll()
                .antMatchers(HttpMethod.DELETE,"/professional/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/professional/professional/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/news").permitAll()
                .antMatchers(HttpMethod.GET,"/news/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/news/all").permitAll()
                .antMatchers(HttpMethod.DELETE,"/news/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/news/{id}").permitAll()
                .antMatchers(publicEndpoint).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtRequestFilters, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
    }
}
