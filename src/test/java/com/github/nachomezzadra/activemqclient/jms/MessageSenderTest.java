package com.github.nachomezzadra.activemqclient.jms;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.nachomezzadra.activemqclient.BaseSpringTest;
import com.github.nachomezzadra.activemqclient.domain.CustomPojo;

public class MessageSenderTest extends BaseSpringTest {

	@Autowired
	private MessageSender<Map<String, String>> mapMessageSender;

	@Autowired
	private MessageSender<CustomPojo> messageSender;

	@Test
	public void shouldSendAMessage() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Nacho");
		map.put("name", "Nati");
		map.put("name", "Tomi");
		mapMessageSender.send(map);
	}

	@Test
	public void shouldSendACustomPojo() throws Exception {
		CustomPojo pojo = new CustomPojo("nacho", "Some Description");
		messageSender.send(pojo);
	}
}
