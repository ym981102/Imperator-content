package org.starrier.imperator.content.config.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * Created by eggyer on 2017/3/26.
 */
@Slf4j
@Component
public class MessageProcessorImpl implements MessageProcessor {

    @Override
    public boolean handleMessage(MessageExt messageExt) {
        log.info("receive : " + messageExt.toString());
        log.info("消息内容：{}", new String(messageExt.getBody()));
        return true;
    }
}