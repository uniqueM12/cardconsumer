package com.card.consumer;

import com.card.consumer.channels.MessageStream;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableBinding(MessageStream.class)
public class CardconsumerApplication {


	@Value("${card.detail.service}")
	private String cardEndpoint;

	public static void main(String[] args) {
		SpringApplication.run(CardconsumerApplication.class, args);
	}

	@Bean
	public WebClient webClient() {

		TcpClient tcpClient = TcpClient
				.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
				.doOnConnected(connection -> {
					connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
					connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
				});

		WebClient webClient = WebClient
				.builder()
				//.baseUrl(cardEndpoint)
				.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
//				.defaultCookie("cookieKey", "cookieValue")
				//.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				//.defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
				.build();

		return webClient;
	}
}
