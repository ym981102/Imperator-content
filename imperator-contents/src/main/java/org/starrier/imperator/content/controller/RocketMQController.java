package org.starrier.imperator.content.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starrier.common.result.Result;

/**
 * @author starrier
 * @date 2020/11/22
 */
@Slf4j
@RestController
@RequestMapping("api/mq")
public class RocketMQController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping
    public Result getTest() {
        SendResult result = rocketMQTemplate.syncSend("71a7af1fd698", "这是一条同步消息", 10000);
        return Result.builder().data(result).build();
    }
}
