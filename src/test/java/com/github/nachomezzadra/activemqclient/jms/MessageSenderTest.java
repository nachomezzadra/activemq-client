package com.github.nachomezzadra.activemqclient.jms;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.nachomezzadra.activemqclient.BaseSpringTest;

public class MessageSenderTest extends BaseSpringTest {

	@Autowired
	private MessageSender messageSender;

	@Test
	public void shouldSendAMessage() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Nacho");
		messageSender.send(map);
	}
}
