package com.github.nachomezzadra.activemqclient.jms;

import org.springframework.jms.core.JmsTemplate;

public class MessageSender<T> {

	private final JmsTemplate jmsTemplate;

	public MessageSender(final JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send(final T object) {
		jmsTemplate.convertAndSend(object);
	}
}
