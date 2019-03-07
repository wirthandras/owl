package hu.wirthandras.owl.service;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import hu.wirthandras.owl.domain.Translation;

@RunWith(SpringRunner.class)
public class OwlServiceTest {

	private OwlService service;

	@MockBean
	private RemoteService remoteService;

	@Before
	public void setUp() {
		service = new OwlService();

		Translation[] translations = generateTestData();

		when(remoteService.getTexts()).thenReturn(translations);

		ReflectionTestUtils.setField(service, "remoteService", remoteService);
	}

	private Translation[] generateTestData() {
		Translation[] translations = new Translation[20];
		for (int i = 0; i < 20; i++) {
			Translation t = new Translation();
			t.setOccurences(i);
			t.setPercent(i);
			translations[i] = t;
		}
		return translations;
	}

	@Test
	public void testBestTen() {
		List<Translation> translations = service.getBestTen();

		Assert.assertNotNull(translations);
		Assert.assertEquals(10, translations.size());
		Assert.assertEquals(19, translations.get(0).getPercent());
		Assert.assertEquals(10, translations.get(9).getPercent());
		Assert.assertTrue(translations.get(0).getPercent() > translations.get(9).getPercent());
	}

	@Test
	public void testWorstTen() {
		List<Translation> translations = service.getWorstTen();

		Assert.assertNotNull(translations);
		Assert.assertEquals(10, translations.size());
		Assert.assertEquals(0, translations.get(0).getPercent());
		Assert.assertEquals(9, translations.get(9).getPercent());
		Assert.assertTrue(translations.get(9).getPercent() > translations.get(0).getPercent());
	}

	@Test
	public void testFrequentTen() {
		List<Translation> translations = service.getFrequentTen();

		Assert.assertNotNull(translations);
		Assert.assertEquals(10, translations.size());
		Assert.assertTrue(translations.get(0).getOccurences() > translations.get(9).getOccurences());
	}

	@Test
	public void testRareTen() {
		List<Translation> translations = service.getRareTen();

		Assert.assertNotNull(translations);
		Assert.assertEquals(10, translations.size());
		Assert.assertTrue(translations.get(9).getOccurences() > translations.get(0).getOccurences());
	}

}
