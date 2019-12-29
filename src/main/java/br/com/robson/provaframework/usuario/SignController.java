package br.com.robson.provaframework.usuario;


import br.com.robson.provaframework.config.responses.EvenlopResponse;
import br.com.robson.provaframework.config.responses.ResponseFactory;
import br.com.robson.provaframework.seguranca.LoginVO;
import br.com.robson.provaframework.seguranca.TokenDto;
import br.com.robson.provaframework.seguranca.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/sign")
public class SignController extends ResponseFactory {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService token;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<TokenDto> sigin(@RequestBody UsuarioVO usuarioVO){
        try{
            Usuario u = this.userService.criaLogin(usuarioVO);

            if  (u!=null) {
                LoginVO form = new LoginVO();

                form.setPass(usuarioVO.getPass());
                form.setEmail(usuarioVO.getEmail());

                UsernamePasswordAuthenticationToken formLogin = form.convert();

                Authentication authentication = authenticationManager.authenticate(formLogin);

                String token = this.token.gerarToken(authentication);

                return ResponseEntity.ok(new TokenDto(token,"Bearer"));
            }

            return ResponseEntity.badRequest().build();


        }
        catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }


    }


    @GetMapping
    public EvenlopResponse get(
            @RequestParam(value = "idUser", required = true, defaultValue = "") Long idUser)    {

        try{
            Optional<Usuario> u = userRepository.findById(idUser);

            if(u.isPresent()){
                return returnEnvelopSucesso(u,"Dado ok");
            }

            return returnEnvelopError("Error ....");


        }
        catch (Exception e){
            return returnEnvelopError("Error ....");
        }


    }


}
