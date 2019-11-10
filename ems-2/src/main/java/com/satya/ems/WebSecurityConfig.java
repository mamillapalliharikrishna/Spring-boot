package com.satya.ems;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	PasswordEncoder    encoder;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            
            .antMatchers("/deleteEmpl**").hasAnyRole("ADMIN","MANAGER")
            .antMatchers("/registerEmpl**").hasAnyRole("ADMIN","MANAGER")
            .antMatchers("/updateEmpl**").hasAnyRole("ADMIN","MANAGER")
            .anyRequest().permitAll()
            .and()
            .formLogin()
           /* .loginPage("/login")
            .failureUrl("/login?error=yes")*/
            
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/index.jsp").permitAll()
            .and()
            .csrf().disable();
        
           http.sessionManagement().maximumSessions(1);
          
        
    }

    @Autowired
    public   void   configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       /* auth
          .inMemoryAuthentication()
          .withUser("shekher").password(encoder.encode("123456")).roles("USER")
          .and()
          .withUser("tanish").password(encoder.encode("654321")).roles("ADMIN", "MANAGER", "CEO")
          .and()
          .withUser("satish").password(encoder.encode("satish123")).roles("ACCOUNTANT");*/
    	
    	auth.jdbcAuthentication().dataSource(dataSource())
        .usersByUsernameQuery("select username, password, enabled"
            + " from users where username=?")
        .authoritiesByUsernameQuery("select username, authority "
            + "from authorities where username=?")
        .passwordEncoder(encoder);
         
   }
    
    @Bean
    public  DataSource   dataSource() {
    	DriverManagerDataSource   ds =new  DriverManagerDataSource();
    	ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    	ds.setUsername("system");
    	ds.setPassword("tiger");
    	return ds;
    }
    
    
    
    @Bean
    public  PasswordEncoder    encodePwd() {
    	return  new   BCryptPasswordEncoder();
    }
}




