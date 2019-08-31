package org.starrier.imperator.content.config.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Starrier
 * @date 2018/11/10.
 */
@Slf4j
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    /**
     * 1. Set the number of core threads
     * 2. Set the maximum number of threads
     * 3. Set the queue capacity
     * 4. Set the thread active time(seconds)
     * 5. Set the default thread name
     * 6. Set the rejection policy
     * 6. Close the thread pool after all the tasks have ended.
     */
    @Bean
    public TaskExecutor imperatorExcutor() {
        log.info(" ThreadPool is using ....");
        log.info(" Asynchronous task is about to execute ");
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("Service-Article-");
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        /*
         * 1. Wait for all the tasks to end before closing the thread pool
         * 2. Set the wait time for the tasks in the thread pool,
         *    and if there is no destruction in the thread pool,
         *    force it to be destroyed to ensure that all the application is
         *    finally closed and blocked from time to time.
         * 3. Initialize the thread pool
         * */
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
