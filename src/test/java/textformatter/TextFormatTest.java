package textformatter;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextFormatTest {

	@Test
	public void test1() {
		FormattedText text = new FormattedText();
		text.add("abc");
		text.add("defghi");
		assertEquals(2, text.numlines());
	}

	@Test
	public void test2() {
		FormattedText text = new FormattedText();
		assertEquals(0, text.numlines());
	}

	@Test
	public void test3() {
		FormattedText text = new CenteredText(30);
		text.add("Help!");
		text.add("Et tu, Brute?");
		assertEquals(2, text.numlines());
	}

	@Test
	public void test4() {
		FormattedText text = new CenteredText(30);
		text.add("Help!");
		text.add("Et tu, Brute?");
		String expectedOutput = "            Help!             \n" + "        Et tu, Brute?         \n";
		// note that \n denotes a new line
		// and is not considered part of the line width
		assertEquals(expectedOutput, text.toString());
	}

	@Test
	public void test5() {
		FormattedText text = new CenteredText(30);
		text.add("1234567890 1234567890 123456789 012345.");
		String expectedOutput = "    1234567890 1234567890     \n" + "      123456789 012345.       \n";
		assertEquals(expectedOutput, text.toString());
	}

	@Test
	public void test6() {
		FormattedText text = new CenteredText(10);
		text.add("abcdefghijkl");
		String expectedOutput = "abcdefghijkl\n";
		assertEquals(expectedOutput, text.toString());
	}

	@Test
	public void test7() {
		FormattedText text = new CenteredText(10);
		text.add("abcd abcdefghijkl");
		String expectedOutput = "   abcd   \n" + "abcdefghijkl\n";
		assertEquals(expectedOutput, text.toString());
	}

	@Test
	public void test8() {
		FormattedText text = new CenteredText(30);
		text.add("123 456 789 1011 121314 15161718");
		String expectedOutput = "   123 456 789 1011 121314    \n" + "           15161718           \n";
		assertEquals(expectedOutput, text.toString());
		assertEquals(2, text.numlines());
	}

	@Test
	public void test9() {
		FormattedText text = new CenteredText(11);
		text.add("111");
		text.add("222");
		text.add("333");
		text.add("4444444");
		String expectedOutput = "    111    \n" + "    222    \n" + "    333    \n" + "  4444444  \n";
		assertEquals(expectedOutput, text.toString());
	}

	@Test
	public void test10() {
		FormattedText text = new CenteredText(11);
		assertEquals(false, text.add(""));
	}

}
