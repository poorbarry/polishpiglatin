package com.poorbarry.polishpiglatin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PigLatinGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void generatorExists() throws Exception {
		PigLatinGenerator generator = new PigLatinGenerator();
		Assert.assertTrue(generator != null);
	}

	@After
	public void tearDown() throws Exception {
	}

}
