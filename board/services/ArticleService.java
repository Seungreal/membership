package board.services;

import board.domains.ArticleDTO;
import board.domains.ReplyDTO;

public interface ArticleService {
    public void addArticle(ArticleDTO article);
    public void updateArticle(ArticleDTO article);
    public void deleteArticle(int artId);
    public void addReply(ReplyDTO reply);
    public void deleteReply(ReplyDTO reply);
    public ArticleDTO readArticle(int artId);
    public ArticleDTO[] readArticleList();
    public ReplyDTO[] readReply(int artId);
}
