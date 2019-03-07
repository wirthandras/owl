package hu.wirthandras.owl.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.MockRestServiceServer;

import hu.wirthandras.owl.domain.Translation;

public class RemoteServiceTest {

	private static final String RESULT = "[{\"id\":15,\"base\":\"sleek\",\"translation\":\"sima\",\"occurences\":8,\"answered\":5,\"correct\":5,\"disabled\":false,\"percent\":100}]";

	private RemoteService service = new RemoteService();

	private MockRestServiceServer mockServer;

	@Before
	public void setUp() {
		mockServer = MockRestServiceServer.bindTo(service.getRestTemplate()).build();

		mockServer.expect(requestTo("/api/json")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess(RESULT, MediaType.APPLICATION_JSON));

		ReflectionTestUtils.setField(service, "path", "/api/json");
	}

	@Test
	public void testGetTexts() {
		Translation[] arr = service.getTexts();
		assertNotNull(arr);
		assertEquals(1, arr.length);
		assertEquals(100, arr[0].getPercent());
		assertEquals("sleek", arr[0].getBase());
		assertEquals("sima", arr[0].getTranslation());
	}

}
