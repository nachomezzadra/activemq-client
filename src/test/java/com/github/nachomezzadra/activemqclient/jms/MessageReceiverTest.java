package com.github.nachomezzadra.activemqclient.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import com.github.nachomezzadra.activemqclient.BaseSpringTest;

public class MessageReceiverTest extends BaseSpringTest {

	@Autowired
	private MessageSender<String> messageSender;

	@Autowired
	private ConnectionFactory connectionFactory;

	@Autowired
	private ActiveMQQueue defaultDestination;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MessageReceiverTest.class);

	@Test
	public void shouldProperlyReceiveAStringMessage() throws Exception {
		SimpleMessageListenerContainer listener = new SimpleMessageListenerContainer();
		listener.setConnectionFactory(connectionFactory);
		listener.setDestination(defaultDestination);
		MessageReceiver messageListener = new MessageReceiver();
		listener.setMessageListener(messageListener);

		listener.start();

		LOGGER.info("Sending message");
		messageSender.send("Testing!");
		LOGGER.info("Message sent");
	}

}
