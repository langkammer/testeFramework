package br.com.robson.provaframework.postagen;

import br.com.robson.provaframework.comment.Comentario;
import br.com.robson.provaframework.usuario.Usuario;

import java.util.List;

public class PostVO {

    private Long id;

    private String nome;

    private String descricao;

    private Usuario autor;

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
        if (!comentarios.isEmpty()) {
            post.setComentarios(comentarios);
        }
        post.setAutor(autor);
        return post;
    }
}
