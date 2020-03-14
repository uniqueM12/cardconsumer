package com.card.consumer.config;

import com.card.consumer.channels.MessageStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by Tenece on 14/03/2020.
 */
//@Configuration
//@EnableBinding({Source.class})
@EnableBinding(MessageStream.class)
public class KafkaConfig {


}
