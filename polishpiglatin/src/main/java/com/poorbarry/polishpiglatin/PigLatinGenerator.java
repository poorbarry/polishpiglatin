package com.poorbarry.polishpiglatin;

import java.util.regex.Pattern;

public class PigLatinGenerator {
//	Rules for Pig Latin:
//	http://www.wikihow.com/Speak-Pig-Latin

	private static final String DASH = "-";
	private static final String AY = "ay";
	private static final String YAY = DASH + "yay";
	private static final Pattern STARTS_WITH_VOWEL = Pattern.compile("^[aeiouy]", Pattern.CASE_INSENSITIVE);

	public String translate(String text) {
		if (startsWithVowel(text)) {
			return text + YAY;
		}
		return convertWordStartingWithConsonant(text);
	}

	private String convertWordStartingWithConsonant(String text) {
		char leadingConsonant = text.charAt(0);
		return text.substring(1) + DASH + leadingConsonant + AY;
	}

	private boolean startsWithVowel(String text) {
		return STARTS_WITH_VOWEL.matcher(text).find();
	}
}
