package br.com.robson.provaframework.seguranca;

import br.com.robson.provaframework.config.responses.EvenlopResponse;
import br.com.robson.provaframework.config.responses.ResponseFactory;
import br.com.robson.provaframework.usuario.UserService;
import br.com.robson.provaframework.usuario.Usuario;
import br.com.robson.provaframework.usuario.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController extends ResponseFactory {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService token;

    @Autowired
    private UserService userService;

    @PostMapping
    public EvenlopResponse sigin(@RequestBody @Valid LoginVO loginVO){
        UsernamePasswordAuthenticationToken formLogin = loginVO.convert();
        try{
            Authentication authentication = authenticationManager.authenticate(formLogin);

            String token = this.token.gerarToken(authentication);

            return returnEnvelopSucesso(new TokenDto(token,"Bearer"),"Logado com Sucesso");

        }
        catch (AuthenticationException e){
            return returnEnvelopError(ResponseEntity.badRequest().build() + " Erro ao Logar " + e.getCause());

        }


    }




}
