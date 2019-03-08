package hu.wirthandras.owl.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hu.wirthandras.owl.service.OwlService;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class IndexControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OwlService service;

	@Before
	public void setUp() {
		when(service.getBestTen()).thenReturn(Collections.emptyList());
		when(service.getFrequentTen()).thenReturn(Collections.emptyList());
		when(service.getRareTen()).thenReturn(Collections.emptyList());
		when(service.getWorstTen()).thenReturn(Collections.emptyList());
	}

	@Test
	public void homeEndpointShouldNavigateToIndexView() throws Exception {
		mockMvc.perform(get("/"))
		.andExpect(status().isOk()).andExpect(view().name("index"))
		.andExpect(model().hasNoErrors());
	}

}
