package mockingApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mockingApi.controller.BookRestController;
import mockingApi.entities.Book;
import mockingApi.service.BookService;

@WebMvcTest(value=BookRestController.class)
public class BookControllerTest {
	@MockBean
	private BookService bookService;
	@Autowired
	private MockMvc mockMvc;
	//Unit testing for post method
	@Test
	public void savebookTest() throws Exception {
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);
		
		Book b=new Book();
		b.setBookName("poems");
		b.setBooPrice(500);
		//To convert Book Object to JSON
		ObjectMapper mapper=new ObjectMapper();
		
		String stringJson = mapper.writeValueAsString(b);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/savebook")
		                      .contentType(MediaType.APPLICATION_JSON)//To set the Type
		                      .content(stringJson);//To store the content
		
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult result = perform.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int actual = response.getStatus();
	assertEquals(201, actual);
	
	}
	@Test
	public void deleteOneBookTest() throws Exception {
		 Long id = 1L;
	        Mockito.when(bookService.deleteBook(id)).thenReturn(true);

	        mockMvc.perform(MockMvcRequestBuilders.delete("/api/{id}", id)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.content().string("Deleted successfully"));
	}
	@Test
	public void savebookTest2() throws Exception {
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(false);
		
		Book b=new Book();
		b.setBookName("poems");
		b.setBooPrice(500);
		//To convert Book Object to JSON
		ObjectMapper mapper=new ObjectMapper();
		
		String stringJson = mapper.writeValueAsString(b);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/savebook")
		                      .contentType(MediaType.APPLICATION_JSON)//To set the Type
		                      .content(stringJson);//To store the content
		
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult result = perform.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int actual = response.getStatus();
	assertEquals(400, actual);
	
	}
	


}
