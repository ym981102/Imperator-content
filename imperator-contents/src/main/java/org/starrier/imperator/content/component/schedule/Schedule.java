package org.starrier.imperator.content.component.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Starrier
 * @date 2019/05/07
 */
@Slf4j
@Component
public class Schedule {

    @Async("imperatorExcutor")
    @Scheduled(fixedDelay = 5000)
    public void updateSensitiveWords() {
        log.info("update content sensitive words");
    }
}
