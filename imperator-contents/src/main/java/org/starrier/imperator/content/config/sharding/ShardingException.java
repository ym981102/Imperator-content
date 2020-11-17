package org.starrier.imperator.content.config.sharding;

import javax.naming.NamingException;

/**
 * @author starrier
 * @date 2020/11/17
 */
public class ShardingException extends Throwable {

    public ShardingException(String s, ReflectiveOperationException ex) {

    }

    public ShardingException(String s, NamingException exception) {

    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
