package core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
   // @Autowired
    //private DataSource dataSource;


   /* public DataSource getDataSource() {
        String dbUrl = "jdbc:mysql://" + System.getenv("SPRING_APP_DB_HOST") + ":3306/" + System.getenv("SPRING_APP_DB_NAME") + "?serverTimezone=UTC";

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(System.getenv("SPRING_APP_DB_USR"));
        dataSourceBuilder.password(System.getenv("SPRING_APP_DB_PASSWD"));
        return dataSourceBuilder.build();
    }*/

  /*  @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
          throws Exception {
      auth.jdbcAuthentication()
              .dataSource(dataSource)
              .withDefaultSchema()
              .withUser(User.withUsername("user")
                      .password(passwordEncoder().encode("pass"))
                      .roles("USER"));
  }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   */

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}pass") // Spring Security 5 requires specifying the password storage format
                .roles("USER");
    }
}