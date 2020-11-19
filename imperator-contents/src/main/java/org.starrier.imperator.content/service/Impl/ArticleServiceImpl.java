package org.starrier.imperator.content.service.Impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starrier.common.result.Result;
import org.starrier.common.result.ResultCode;
import org.starrier.imperator.content.entity.Article;
import org.starrier.imperator.content.entity.ArticleVote;
import org.starrier.imperator.content.repository.dao.ArticleDao;
import org.starrier.imperator.content.service.ArticleService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


/**
 * <p>Article Service</p>
 *
 * @author Starrier
 * @date 2018/10/27.
 */
@Slf4j
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDao articleDao;

    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * <p>Insert Article with Id</p>
     *
     * @param article 数据实体
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertArticle(Article article) {

        log.info(" ThreadContextService, Current thread:[{}]", Thread.currentThread().getId());
        articleDao.insertArticle(article);
    }

    @Override
    public List<Article> listArticle(int page, int limit) {
        PageHelper.startPage(page, limit);
        return articleDao.listArticle();
    }

    /**
     * 点赞
     *
     * @param articleVote {@link Article#getId()}
     * @return Article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Article createVote(ArticleVote articleVote) {

        Article optionalArticle = articleDao.getArticleById(articleVote.getArticleId());
        Article originalBlog = null;
        return null;
    }

    /**
     * 取消点赞
     *
     * @param articleId 文章 id
     * @param likeId    点赞 用户 id
     */
    @Override
    public void removeVote(int articleId, int likeId) {
    }

    @Override
    public Optional<List<Article>> getArticlesByCategoryId(int id) {
        return Optional.ofNullable(articleDao.getArticlesByCategoryId(id));
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public List<Article> getArticlesByKeyword(String keyword) {
        return articleDao.getArticlesByKeyword(keyword);
    }

    @Retryable(value = NotFoundException.class, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    @Override
    public Article getArticleById(Long id) {
        return articleDao.getArticleById(id);
    }

    @Recover
    public Result getArticleByIdRecovery(NotFoundException e) {
        log.debug("Request has got exception:[{}]", e.getMessage());
        return Result.error(ResultCode.RESULE_DATA_NONE, "Request timeout");
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateArticle(final Article article) {
        articleDao.updateArticle(article);
    }

    @Override
    @Async("imperatorExcutor")
    @SneakyThrows(InterruptedException.class)
    public void executeAsynchronous() {
        log.info(" Start Execute Asynchronous task....");
        Thread.sleep(1000);
        log.info(" Aysn task has been done! ");
    }

    /**
     * Global Collapse.
     *
     * @return {@link Future}
     */
    @Override
    public Future<Article> collapsingGlobal(final Long id) {
        log.info("Single Request:[{}]", id);
        log.info("The real method invoked is getArticleById()");
        return null;
    }

    @Override
    public List<String> listAllAuthorName() {
        return articleDao.getAllAuthorName().stream().map(Article::getAuthor).collect(Collectors.toList());
    }

    @Override
    public Optional<Article> findById(Long articleId) {
        return Optional.empty();
    }

    @Override
    public List<Article> searchArticles(String key) {
        return articleDao.findAllByKey(key);
    }

    @Override
    public List<Article> findAllByIds(List<Integer> articleIds) {
        return articleDao.findAllByIds(articleIds);
    }

    @Override
    public void updateArticleById(Long id) {
        articleDao.updateArticleById(id);
    }

    @Override
    public String test() {
       /* ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        String test = valueOperations.get("test");
        if (test == null) {
            valueOperations.set("test","test");
            return "failed";
        }
        return "success";*/
        return null;
    }

    /**
     * @param articleParam List<Long>
     * @return return the List<Article>
     */
    public Optional<List<Article>> getArticleById(final List<Long> articleParam) {
        log.info("The current thread :[{}]", Thread.currentThread().getName());
        log.info("The request param:[{}]", articleParam);
        List<Article> articleList = Lists.newArrayListWithExpectedSize(articleParam.size());
        articleParam.parallelStream().forEach(articleId -> articleList.add(articleDao.getArticleById(articleId)));
        log.info("Result :[{}]", articleList);
        return Optional.of(articleList);
    }

    public List<Article> getArticleByIdError(final List<Long> articleParam) {
        return null;
    }

    /**
     * @param id Long
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(final Long id) {
        articleDao.deleteById(id);
    }

    /**
     * Delete Article By Author.
     *
     * @param author String
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteArticleByAuthor(final String author) {
        articleDao.deleteArticleByAuthor(author);
    }

    /**
     * Delete Article.
     *
     * @param article Article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteArticle(final Article article) {
        articleDao.deleteArticle(article);
    }

    @Override
    public List<Article> getArticlesByAuthor(final String author) {
        List<Article> articles = Lists.newArrayList();
        return articleDao.getArticlesByAuthor(author);
    }

}
