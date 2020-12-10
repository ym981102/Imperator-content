package org.starrier.imperator.content.config.rocketmq;


import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by eggyer on 2017/3/25.
 */
@Component
public class MessageListener implements MessageListenerConcurrently {

    private final MessageProcessor messageProcessor;

    public MessageListener(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (MessageExt msg : msgs) {
            boolean result = messageProcessor.handleMessage(msg);
            if (!result) {
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}