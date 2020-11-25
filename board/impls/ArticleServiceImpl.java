package board.impls;

import board.domains.ArticleDTO;
import board.domains.ReplyDTO;
import board.services.ArticleService;

public class ArticleServiceImpl implements ArticleService {
    private ArticleDTO[] articleList;
    private ReplyDTO[] replyList;
    private int artId;
    private int replyId;

    public ArticleServiceImpl(){
        articleList = new ArticleDTO[0];
        replyList = new ReplyDTO[0];
        artId=1;
        replyId=1;
    }
    @Override
    public void addArticle(ArticleDTO article) {
        int size = articleList.length;
        ArticleDTO[] temp = new ArticleDTO[size+1];
        for(int i=0;i<size;i++){
            temp[i]=articleList[i];
        }
        article.setArtId(artId++);
        temp[size]=article;
        articleList=temp;
    }

    @Override
    public void updateArticle(ArticleDTO article) {
        for(int i=0;i<articleList.length;i++){
            if(article.getArtId()==articleList[i].getArtId()){
                articleList[i].setTitle(article.getTitle());
                articleList[i].setContent(article.getContent());
                break;
            }
        }
    }

    @Override
    public void deleteArticle(int artId) {
        int size = articleList.length;
        int index=-1;
        for(int i=0;i<size;i++){
            if(artId==articleList[i].getArtId()){
                index=i;
                break;
            }
        }
        if(index!=-1){
            ArticleDTO[] temp = new ArticleDTO[size-1];
            for(int i=0;i<index;i++){
                temp[i]=articleList[i];
            }
            for(int i=index;i<size-1;i++){
                temp[i]=articleList[i+1];
            }
            articleList=temp;
        }
    }

    @Override
    public void addReply(ReplyDTO reply) {
        int size = replyList.length;
        ReplyDTO[] temp = new ReplyDTO[size+1];
        for(int i=0;i<size;i++){
            temp[i]=replyList[i];
        }
        reply.setArtId(replyId++);
        temp[size]=reply;
        replyList=temp;
    }

    @Override
    public void deleteReply(ReplyDTO reply) {
    }

    @Override
    public ArticleDTO readArticle(int artId) {
        for(int i=0;i<articleList.length;i++){
            if(artId==articleList[i].getArtId()){
                return articleList[i];
            }
        }
        return null;
    }

    @Override
    public ArticleDTO[] readArticleList() {
        return articleList;
    }

    @Override
    public ReplyDTO[] readReply(int artId) {
        ReplyDTO[] temp = new ReplyDTO[10];
        int index=0;
        for(int i=0;i<replyList.length;i++){
            if(artId==replyList[i].getArtId()){
                temp[index++]=replyList[i];
            }
        }
        return temp;
    }
}
