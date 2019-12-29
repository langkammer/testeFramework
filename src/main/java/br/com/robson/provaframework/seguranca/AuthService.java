package br.com.robson.provaframework.seguranca;

import br.com.robson.provaframework.usuario.Usuario;
import br.com.robson.provaframework.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService  implements UserDetailsService {


    @Autowired
    UsuarioRepository repository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Usuario> u = repository.findByEmail(s);

        if(u.isPresent())
            return u.get();

        throw  new UsernameNotFoundException("Usuario ou senha Localizado!");
    }
}
