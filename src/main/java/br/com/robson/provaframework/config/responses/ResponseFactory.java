package br.com.robson.provaframework.config.responses;


import static br.com.robson.provaframework.config.responses.StatusResponseEnum.SUCESSO;

public class ResponseFactory  {

    public EvenlopResponse returnEnvelopSucesso(Object o, String msg){
        return new EvenlopResponse(SUCESSO,msg,o);
    }

    public EvenlopResponse returnEnvelopSucessoList(Object o,long totalPages,long totalElements,String msg){
        return new EvenlopResponse(SUCESSO,totalPages,totalElements,msg,o);
    }

    public EvenlopResponse returnEnvelopError(String msg){
        return new EvenlopResponse(StatusResponseEnum.ERRO,msg);
    }

}