package com.github.nachomezzadra.activemqclient.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReceiver implements MessageListener {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MessageReceiver.class);

	public void onMessage(Message message) {
		LOGGER.info("Message received: {}", message);
		if (message instanceof ObjectMessage) {
			try {
				LOGGER.info("Is a Custom Object: {}", ((ObjectMessage) message)
						.getObject().getClass());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			LOGGER.info("Is some other thing: {}", message.getClass());
		}

	}
}
