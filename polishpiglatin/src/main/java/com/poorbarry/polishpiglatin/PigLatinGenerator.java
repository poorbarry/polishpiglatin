package com.poorbarry.polishpiglatin;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.regex.Pattern;

class PigLatinGenerator {
	// Rules for Pig Latin:
	// http://www.wikihow.com/Speak-Pig-Latin

	private static final String YAY = "-yay";
	private static final Pattern STARTS_WITH_VOWEL = Pattern.compile("^[aeiou]", CASE_INSENSITIVE);

	String translate(String text) {
		return Arrays.stream(text.split(" ")).map(word -> toPigLatin(word)).collect(joining(" "));
	}

	private String toPigLatin(String word) {
		return startsWithVowel(word) ? word + YAY : convertWordStartingWithConsonant(word);
	}

	private String convertWordStartingWithConsonant(String text) {
		return text.replaceAll("^([^aeiouAEIOU][^aeiouy]*)(.+)$", "$2-$1ay");
	}

	private boolean startsWithVowel(String text) {
		return STARTS_WITH_VOWEL.matcher(text).find();
	}
}