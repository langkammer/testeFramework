package br.com.robson.provaframework.postagen;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {
    Page<Post> findByNomeContaining(String nome, Pageable paginacao);
}
