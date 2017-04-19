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

	@Test
	public void theLetterYAtTheEndOfATwoLetterWord_isTreatedAsAConsonant() throws Exception {
		assertThat(generator.translate("my"), is("y-may"));
	}

	@Ignore
	@Test
	public void theLetterYAtTheStartOfAWord_isTreatedAsAConsonant() throws Exception {
		assertThat(generator.translate("yellow"), is("ellow-yay"));
	}

	@Ignore
	@Test
	public void multipleWords_produceMultipleConvertedWords() throws Exception {
		assertThat(generator.translate("dog day"), is("og-day ay-day"));
	}

	@Ignore
	@Test
	public void startsWithConsonantCluster_MovesConsonantClusterToEndAndAddsAy() throws Exception {
		assertThat(generator.translate("frog"), is("og-fray"));
		assertThat(generator.translate("fruit smoothie"), is("uit-fray oothie-smay"));
	}

	@Ignore
	@Test
	public void theLetterYAtTheEndOfAConsonantCluster_isTreatedAsAVowel() throws Exception {
		assertThat(generator.translate("rhythm"), is("ythm-rhay"));
	}

	@Ignore
	@Test
	public void makesCompoundWordsLessComprehensible() throws Exception {
		assertThat(generator.translate("bedroom"), is("ed-bay oom-ray"));
		assertThat(generator.translate("toothbrush"), is("ooth-tay ush-bray"));
	}
}
