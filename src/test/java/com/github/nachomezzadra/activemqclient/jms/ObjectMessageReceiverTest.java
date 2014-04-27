package com.github.nachomezzadra.activemqclient.jms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.jms.ConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import com.github.nachomezzadra.activemqclient.BaseSpringTest;
import com.github.nachomezzadra.activemqclient.domain.CustomPojo;

public class ObjectMessageReceiverTest extends BaseSpringTest {

	@Autowired
	private MessageSender<CustomPojo> messageSender;

	@Autowired
	private ConnectionFactory connectionFactory;

	@Autowired
	private ActiveMQQueue defaultDestination;

	@Test
	public void shouldProperlyReceiveACustomObject() throws Exception {
		SimpleMessageListenerContainer listener = new SimpleMessageListenerContainer();
		listener.setConnectionFactory(connectionFactory);
		listener.setDestination(defaultDestination);
		ObjectMessageReceiver<CustomPojo> messageListener = new ObjectMessageReceiver<CustomPojo>();
		listener.setMessageListener(messageListener);

		listener.start();

		CustomPojo expectedCustomPojo = new CustomPojo("nacho",
				"Some Description");
		messageSender.send(expectedCustomPojo);

		assertNotNull(messageListener.getReceivedObject());
		assertEquals(expectedCustomPojo, messageListener.getReceivedObject());
	}
}
