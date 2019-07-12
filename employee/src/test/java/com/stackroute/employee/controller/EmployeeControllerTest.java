/**
 * 
 *//*
package com.stackroute.employee.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.employee.model.Employee;
import com.stackroute.employee.service.EmployeeService;

*//**
 * @author 26647
 *
 *//*
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	private static final int iD = Integer.MAX_VALUE;
	@Mock
	private EmployeeService empService;
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	
	@InjectMocks
	private EmployeeController empController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(empController).addFilters(new CorsFilter()).build();
	}

	@Test
	public void test_getAll() throws Exception {
		List<Employee> rest = Arrays.asList(new Employee());
		when(empService.findAll()).thenReturn(rest);
		mockMvc.perform(get("/api/getall")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(2)))
				.andExpect(jsonPath("$[0].name", is("Ajay"))).andExpect(jsonPath("$[0].location", is("itc")))
				.andExpect(jsonPath("$[0].cuisines", is("veg"))).andExpect(jsonPath("$[0].image", is("img")))
				.andExpect(jsonPath("$[0].review", is("good")));
		verify(empService, times(1)).findAll();
		verifyNoMoreInteractions(empService);
	}

	@Test
	public void createNewUser_test() throws Exception {
		String url = "http://localhost:8081/api/restaurant";
		Employee rest = new Employee();
		rest.setId(3);
		rest.setFirstName("");
		Gson gson = new Gson();
		String json = gson.toJson(rest);
		mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk())
				.andReturn();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_update_user() throws Exception {
		// String url = "http://localhost:8081/api/update";
		Employee rest = new Employee();
		rest.setId(3);
		rest.setFirstName("Ajay");
		when(empService.findById(rest.getId())).thenReturn(rest);
		// doNothing().when(restaurentService).update(rest);
		mockMvc.perform(put("/api/update/{id}", rest.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(rest))).andExpect(status().isOk());
		// verify(restaurentService, times(1)).findById(rest.getId());
		verify(empService, times(1)).update(Matchers.refEq(rest));
		verifyNoMoreInteractions(empService);
	}

	@Test
	public void test_update_fail_404_not_found() throws Exception {
		Employee rest = new Employee();
		when(empService.findById(rest.getId())).thenReturn(null);
		mockMvc.perform(put("/api/update/{id}", rest.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(rest))).andExpect(status().isOk());
		// .andExpect(status().isOk());
		// verify(restaurentService, times(1)).findById(rest.getId());
		verify(empService, times(1)).update(Matchers.refEq(rest));
		verifyNoMoreInteractions(empService);
	}

	@Test
	public void test_getRest_ById() throws Exception {
		Employee rest = new Employee();
		rest.setId(3);
		rest.setFirstName("Ajay");

		when(empService.findById(3)).thenReturn(rest);
		mockMvc.perform(get("/api/getall/{id}", 3)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.id", is(3)));
		verify(empService, times(1)).findById(3);
		verifyNoMoreInteractions(empService);

	}

	@Test
	public void test_deleteRest() throws Exception {
		Employee rest = new Employee();
		rest.setId(1);
		rest.setFirstName("Ajay");

		when(empService.findById(rest.getId())).thenReturn(rest);
		// doNothing().when(restaurentService).delete(rest.getId());
		mockMvc.perform(delete("/api/delete/{id}", rest.getId())).andExpect(status().isOk());
		// verify(restaurentService, times(1)).findById(rest.getId());
		verify(empService, times(1)).delete(rest.getId());
		verifyNoMoreInteractions(empService);
	}

	
	 * converts a Java object into JSON representation
	 
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
*/