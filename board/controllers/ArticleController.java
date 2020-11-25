package board.controllers;

import board.domains.ArticleDTO;
import board.domains.ReplyDTO;
import board.impls.ArticleServiceImpl;
import board.services.ArticleService;

public class ArticleController {
    private ArticleService service;
    public ArticleController(){
        service = new ArticleServiceImpl();
    }
    public void postArticle(ArticleDTO article){
        service.addArticle(article);
    }
    public void putArticle(ArticleDTO article){
        service.updateArticle(article);
    }
    public void deleteArticle(int artId){
        service.deleteArticle(artId);
    }   
    public void postReply(ReplyDTO reply){
        service.addReply(reply);
    }
    public void deleteReply(ReplyDTO reply){
        service.deleteReply(reply);
    }
    public ArticleDTO getArticle(int artId){
        return service.readArticle(artId);
    }
    public ArticleDTO[] getArticleList(){
        return service.readArticleList();
    }
    public ReplyDTO[] getReply(int artId){
        return service.readReply(artId);
    }
}
