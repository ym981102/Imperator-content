package org.starrier.imperator.content.service.Impl;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Service;

/**
 * @author Starrier
 * @date 2019/05/13
 */
@Service
public class ControllerService {

    private static final Counter USER_COUNTER = Metrics.counter("user.counter.total", "services", "demo");

    public void processCollectResult() {
        USER_COUNTER.increment(1D);
    }
}
