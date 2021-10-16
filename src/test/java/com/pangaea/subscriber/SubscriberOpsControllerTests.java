package com.pangaea.subscriber;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pangaea.subscriber.controllers.SubscriberOpsController;

@RunWith(SpringRunner.class)
@WebMvcTest(SubscriberOpsController.class)
public class SubscriberOpsControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testThatListener1ReturnsBadRequestWhenNoRequestBodyIsPassed() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/test1")).andExpect(status().isBadRequest());
	}

	@Test
	public void testThatListener1ReturnsOk() throws Exception {
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("topic", "topic1");
		payload.put("data", Collections.EMPTY_LIST);
		mockMvc.perform(MockMvcRequestBuilders.post("/test1").content(objectMapper.writeValueAsString(payload))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testThatListener1ReturnsBadMediaTypeWhenContentTypeIsNotCorrect() throws Exception {
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("topic", "topic1");
		payload.put("data", Collections.EMPTY_LIST);
		mockMvc.perform(MockMvcRequestBuilders.post("/test1").content(objectMapper.writeValueAsString(payload))
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isUnsupportedMediaType());
	}


	@Test
	public void testThatListener2ReturnsBadRequestWhenNoRequestBodyIsPassed() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/test2")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void testThatListener2ReturnsOk() throws Exception {
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("topic", "topic1");
		payload.put("data", Collections.EMPTY_LIST);
		mockMvc.perform(MockMvcRequestBuilders.post("/test2").content(objectMapper.writeValueAsString(payload))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testThatListener2ReturnsBadMediaTypeWhenContentTypeIsNotCorrect() throws Exception {
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("topic", "topic1");
		payload.put("data", Collections.EMPTY_LIST);
		mockMvc.perform(MockMvcRequestBuilders.post("/test2").content(objectMapper.writeValueAsString(payload))
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isUnsupportedMediaType());
	}


}
