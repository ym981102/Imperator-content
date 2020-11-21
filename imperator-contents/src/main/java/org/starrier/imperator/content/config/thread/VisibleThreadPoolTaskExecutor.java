package org.starrier.imperator.content.config.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author Starrier
 * @date 2018/12/10.
 */
@Slf4j
public class VisibleThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    private void showThreadPoolInfo(String prefix) {
        ThreadPoolExecutor threadPoolTaskExecutor = getThreadPoolExecutor();
        if (null == threadPoolTaskExecutor) {
            return;
        }
        log.info("{},{},taskCount [{}],completeTaskCount[{}],activeCount[{}]");
    }

}