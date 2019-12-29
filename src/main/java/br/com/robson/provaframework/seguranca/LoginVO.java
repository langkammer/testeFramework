package br.com.robson.provaframework.seguranca;

import br.com.robson.provaframework.usuario.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginVO {

    private String email;

    private String pass;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(email,pass);
    }

    public UsernamePasswordAuthenticationToken convertUsuarioAuthApplication(Usuario usuario){
        this.email = usuario.getEmail();
        this.pass = usuario.getPass();
        return this.convert();
    }
}
