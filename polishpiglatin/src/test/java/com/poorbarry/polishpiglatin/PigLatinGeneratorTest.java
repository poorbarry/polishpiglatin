package com.poorbarry.polishpiglatin;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PigLatinGeneratorTest {

	private PigLatinGenerator generator;

	@Before
	public void setUp() throws Exception {
		generator = new PigLatinGenerator();
	}
	
	@Test
	public void generatorExists() throws Exception {
		Assert.assertTrue(generator != null);
	}
	
	@Test
	public void startsWithVowel_AddsYay() throws Exception {
		assertThat(generator.translate("a"), is("a-yay"));
		assertThat(generator.translate("e"), is("e-yay"));
		assertThat(generator.translate("i"), is("i-yay"));
		assertThat(generator.translate("o"), is("o-yay"));
		assertThat(generator.translate("u"), is("u-yay"));
		assertThat(generator.translate("apple"), is("apple-yay"));
	}
	
	@Test
	public void startsWithConsonant_MovesConsonantToEndAndAddsAy() throws Exception {
		assertThat(generator.translate("dog"), is("og-day"));
	}

	@Ignore
	@Test
	public void startsWithConsonantCluster_MovesConsonantClusterToEndAndAddsAy() throws Exception {
		assertThat(generator.translate("frog"), is("og-fray"));
	}
}
