package com.card.consumer.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Tenece on 14/03/2020.
 */
public interface MessageStream {

    String INPUT = "input";

    @Input(INPUT)
    SubscribableChannel inboundMessage();;

}
