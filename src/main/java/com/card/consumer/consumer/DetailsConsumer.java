package com.card.consumer.consumer;

import com.card.consumer.channels.MessageStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by Tenece on 14/03/2020.
 */
@Component
@Slf4j
public class DetailsConsumer {

    @StreamListener(MessageStream.INPUT)
    public void getCardDetails(String cardNo) {

        System.out.println("message receiaved" + cardNo);
        log.debug("sending card details {} to the consumer", cardNo);
    }
}
