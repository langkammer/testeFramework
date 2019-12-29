package br.com.robson.provaframework.postagen;

import br.com.robson.provaframework.config.responses.EvenlopResponse;
import br.com.robson.provaframework.config.responses.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/post")
public class PostController extends ResponseFactory {

    @Autowired
    private PostService postService;


    @PostMapping
    public EvenlopResponse postar(@RequestBody PostVO postVO){
        try{
            return returnEnvelopSucesso(postService.criarPost(postVO),"Operação Realizada com Sucesso");
        }
        catch (AuthenticationException e){
            return returnEnvelopError("Erro ao realizar a Operação " + e.getMessage());
        }
    }

    @GetMapping
    public EvenlopResponse list(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @PageableDefault(sort = "id",direction = Sort.Direction.DESC, page = 0,size = 10) Pageable paginacao){
        try{

            Page<Post> list = postService.find(paginacao,nome);

            return returnEnvelopSucessoList(list,list.getTotalPages(),list.getTotalElements(),
                    "Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

}
