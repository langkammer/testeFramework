package br.com.robson.provaframework.postagen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PostService {

    @Autowired
    PostRepository repository;


    public Post criarPost(PostVO postVO) {
        Post post = postVO.converterParaPost();
        return  repository.saveAndFlush(post);
    }

    public Page<Post> find(Pageable paginacao, String nome){
        Page<Post> listPage = repository.findByNomeContaining(nome, paginacao);
        return listPage;
    }
}
