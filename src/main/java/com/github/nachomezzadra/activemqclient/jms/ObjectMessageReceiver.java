package com.github.nachomezzadra.activemqclient.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectMessageReceiver<T> implements MessageListener {

	private T receivedObject = null;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ObjectMessageReceiverTest.class);

	@SuppressWarnings("unchecked")
	public void onMessage(Message message) {
		LOGGER.info("Message received: {}", message);
		try {
			this.receivedObject = (T) ((ObjectMessage) message).getObject();
			LOGGER.info("Is a Custom Object: {}", receivedObject.getClass());
		} catch (JMSException e) {
			throw new ClassCastException(
					"Received message is not a Custom Object");
		}
	}

	public T getReceivedObject() {
		return receivedObject;
	}

	public void setReceivedObject(T receivedObject) {
		this.receivedObject = receivedObject;
	}

}
