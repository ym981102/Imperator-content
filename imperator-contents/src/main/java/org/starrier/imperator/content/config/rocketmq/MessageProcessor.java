package org.starrier.imperator.content.config.rocketmq;


import org.apache.rocketmq.common.message.MessageExt;

/**
 * Created by eggyer on 2017/3/25.
 */
public interface MessageProcessor {
    /**
     * 处理消息的接口
     * @param messageExt
     * @return
     */
    boolean handleMessage(MessageExt messageExt);
}