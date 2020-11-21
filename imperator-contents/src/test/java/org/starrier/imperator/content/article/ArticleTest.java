package org.starrier.imperator.content.article;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.starrier.imperator.content.ImperatorContent;
import org.starrier.imperator.content.service.ArticleService;

import static org.junit.Assert.assertEquals;

/**
 * @author starrier
 * @date 2020/11/16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImperatorContent.class)
public class ArticleTest {

    @MockBean
    private ArticleService articleService;

    @RepeatedTest(2)
    public void testArticleCache() {
        assertEquals("success", articleService.test());
    }
}
