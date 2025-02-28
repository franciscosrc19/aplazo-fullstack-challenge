package com.aplazo.msprptakehome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // Configura las autorizaciones de las rutas y la autenticación básica
    http
      .csrf(csrf -> csrf.disable())  // Deshabilitar CSRF solo para fines de demostración, no recomendado en producción
      .authorizeHttpRequests(auth -> auth
                                       .anyRequest().authenticated()  // Cualquier solicitud debe estar autenticada
      )
      .httpBasic(withDefaults());  // Autenticación HTTP básica

    return http.build();
  }

  // Configuración de usuarios en memoria (puedes reemplazar esto con una base de datos si es necesario)
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.builder()
                         .username("user")
                         .password("{noop}password")  // {noop} indica que no se debe aplicar codificación de contraseñas
                         .roles("USER")
                         .build();

    return new InMemoryUserDetailsManager(user);
  }
}
