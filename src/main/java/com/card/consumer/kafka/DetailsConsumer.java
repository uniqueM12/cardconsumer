package com.card.consumer.kafka;

import com.card.consumer.channels.MessageStream;
import com.card.consumer.model.CardResponse;
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
    public void getCardDetails(CardResponse cardResponse) {

        System.out.println("message receiaved" + cardResponse.getPayload());
        log.debug("sending card details {} to the kafka", cardResponse);

    }
}
