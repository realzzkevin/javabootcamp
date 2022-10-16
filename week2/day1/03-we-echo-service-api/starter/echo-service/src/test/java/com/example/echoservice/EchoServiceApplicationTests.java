package com.example.echoservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@WebMvcTest(EchoServiceApplication.class)
@SpringBootTest
public class EchoServiceApplicationTests {
//	@Autowired
//	private MockMvc mockMvc;
//
//	private ObjectMapper mapper = new ObjectMapper();
//
//	@Before
//	public void setUp () {
//	}
//
//	@Test
//	public void shouldReturnInput() throws Exception {
//	}

}
