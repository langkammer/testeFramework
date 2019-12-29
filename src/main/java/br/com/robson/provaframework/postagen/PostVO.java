package br.com.robson.provaframework.postagen;

import br.com.robson.provaframework.comment.Comentario;
import br.com.robson.provaframework.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PostVO {

    private Long id;

    private String nome;

    private String descricao;

    public PostVO(){}

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    private List<Comentario> comentarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Post converterParaPost() {
        Post post = new Post();

        post.setNome(post.getNome());
        post.setDescricao(post.getDescricao());
        if (comentarios != null && !comentarios.isEmpty()) {
            post.setComentarios(new ArrayList<Comentario>());
            post.setComentarios(comentarios);
        }
        if(usuario != null) {
            post.setAutor(usuario);
        }
        return post;
    }
}
