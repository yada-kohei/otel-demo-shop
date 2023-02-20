package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  // ユーザIDとパスワードを取得するSQL文
	private static final String USER_SQL = "SELECT" + " user_id," + " password," + " true" + " FROM" + " user"
			+ " WHERE" + " user_id = ?";

	// ユーザのロールを取得するSQL文
	private static final String ROLE_SQL = "SELECT" + " user_id," + " role" + " FROM" + " user" + " WHERE"
			+ " user_id = ?";

  @Override
  public void configure(WebSecurity web) throws Exception {

    // 静的リソースへのアクセスには、セキュリティを適用しない
    web.ignoring().antMatchers("/webjars/**", "/css/**", "/images/**", "/js/**");

  }
  @Bean
  public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // ログイン不要ページの設定
    http.authorizeRequests()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/css/**").permitAll()
        .antMatchers("/images/**").permitAll()
        .antMatchers("/js/**").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/signup").permitAll()
        .antMatchers("/itemList").hasAuthority("ROLE_ADMIN")
        .antMatchers("/userList").hasAuthority("ROLE_ADMIN")
        .anyRequest().authenticated();

    // ログイン処理
    http.formLogin()
        .loginProcessingUrl("/login")
        .loginPage("/login")
        .failureUrl("/login")
        .usernameParameter("userId")
        .passwordParameter("password")
        .defaultSuccessUrl("/home", true);

    // ログアウト処理
    http.logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login");

    // RESTのみCSRF対策を無効にする場合
    // http.csrf().disable();
  }

  @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// ログイン処理時のユーザ情報を、DBから取得する
    auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(USER_SQL)
        .passwordEncoder(passwordEncoder())
        .authoritiesByUsernameQuery(ROLE_SQL);
	}

}
