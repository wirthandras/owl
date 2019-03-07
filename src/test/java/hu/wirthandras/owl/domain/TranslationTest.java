package hu.wirthandras.owl.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class TranslationTest {

	private Translation a;
	private Translation b;

	@Before
	public void setup() {
		a = new Translation();
		b = new Translation();
		a.setPercent(10);
		b.setPercent(50);
	}

	@Test
	public void testComparePercentageLessThan() {
		Assert.assertEquals(-1, a.compareTo(b));
	}

	@Test
	public void testComparePercentageEquals() {
		a.setPercent(50);
		Assert.assertEquals(0, a.compareTo(b));
		Assert.assertEquals(0, b.compareTo(a));
	}

	@Test
	public void testComparePercentageGreaterThan() {
		Assert.assertEquals(1, b.compareTo(a));
	}

	@Test
	public void testGetterSetter() {
		PojoClass pojoclass = PojoClassFactory.getPojoClass(Translation.class);
		Validator validator = ValidatorBuilder.create()
				.with(new SetterMustExistRule())
				.with(new GetterMustExistRule())
				.with(new SetterTester())
				.with(new GetterTester()).build();
		validator.validate(pojoclass);
	}
}
