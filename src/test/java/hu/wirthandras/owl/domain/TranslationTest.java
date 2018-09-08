package hu.wirthandras.owl.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TranslationTest {
	
	private Translation a;
	private Translation b;
	
	@Before
	public void setup() {
		a = new Translation();
		b = new Translation();
		a.percent = 10;
		b.percent = 50;
	}

	@Test
	public void testComparePercentageLessThan() {
		Assert.assertEquals(-1, a.compareTo(b));
	}
	
	@Test
	public void testComparePercentageEquals() {
		a.percent = 50;
		Assert.assertEquals(0, a.compareTo(b));
		Assert.assertEquals(0, b.compareTo(a));
	}
	
	@Test
	public void testComparePercentageGreaterThan() {
		Assert.assertEquals(1, b.compareTo(a));
	}
}
