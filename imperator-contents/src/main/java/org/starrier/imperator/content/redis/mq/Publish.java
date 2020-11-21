package org.starrier.imperator.content.redis.mq;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.starrier.imperator.content.redis.mq.Consts.TopicName;

@Component
public class Publish {
    @Autowired
    private RedissonClient redissonClient;

    //发布
    public long publish(MyObjectDTO myObjectDTO) {
        RTopic rTopic = redissonClient.getTopic(TopicName);
        return rTopic.publish(myObjectDTO);
    }

}
