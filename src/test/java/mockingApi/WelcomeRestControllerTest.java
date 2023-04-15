package mockingApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import mockingApi.controller.WelcomeRestController;
import mockingApi.service.WelcomeService;

@WebMvcTest(value=WelcomeRestController.class)
public class WelcomeRestControllerTest {
	@MockBean
	private WelcomeService welcomeService;
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void welcomeMsgTest() throws Exception {
		when(welcomeService.getWelcomeMsg()).thenReturn("Welcome!");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int actual = response.getStatus();
		assertEquals(200, actual);
		
	}

}
