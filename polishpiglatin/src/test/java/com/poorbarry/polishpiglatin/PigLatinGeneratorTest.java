package com.poorbarry.polishpiglatin;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

	@Test
	public void theLetterYAtTheStartOfAWord_isTreatedAsAConsonant() throws Exception {
		assertThat(generator.translate("yellow"), is("ellow-yay"));
	}

	@Test
	public void multipleWords_produceMultipleConvertedWords() throws Exception {
		assertThat(generator.translate("dog day"), is("og-day ay-day"));
		assertThat(generator.translate("apple pie"), is("apple-yay ie-pay"));
		assertThat(generator.translate("apple orange"), is("apple-yay orange-yay"));
	}

	@Test
	public void startsWithConsonantCluster_MovesConsonantClusterToEndAndAddsAy() throws Exception {
		assertThat(generator.translate("frog"), is("og-fray"));
		assertThat(generator.translate("fruit smoothie"), is("uit-fray oothie-smay"));
	}

	@Test
	public void theLetterYAtTheEndOfAConsonantCluster_isTreatedAsAVowel() throws Exception {
		assertThat(generator.translate("rhythm"), is("ythm-rhay"));
		assertThat(generator.translate("hype"), is("ype-hay"));
		assertThat(generator.translate("hymnal"), is("ymnal-hay"));
		assertThat(generator.translate("Bryme"), is("yme-Bray"));
	}

	@Ignore
	@Test
	public void makesCompoundWordsLessComprehensible() throws Exception {
		assertThat(generator.translate("bedroom"), is("ed-bay oom-ray"));
		assertThat(generator.translate("toothbrush"), is("ooth-tay ush-bray"));
	}
}
