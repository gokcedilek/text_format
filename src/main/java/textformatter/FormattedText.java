package textformatter;

public class FormattedText {

	// we use a recursive list definition for our formatted text
	private String firstLine;
	private FormattedText remainingText;
	private FormattedText lastLine;

	/* ** Rep Invariant
	      - true (weakest invariant)
	   ** Abstraction Function
	      - the text is firstLine + remainingText.toString() when firstLine and remainingText are not null
	      - if firstLine is null then the text represented is empty text
	      - if firstLine is not null and remainingText is null then text is only firstLine
	 */


	/**
	 * Create a new FormattedText object
     * @param line is the text to add, is not null,
     *             and does not contain the newline or carriage return characters
	 */
	public FormattedText(String line) {
		firstLine = line;
		remainingText = null;
		lastLine = this;
	}

	/**
	 * 
	 * @param line
	 *            represents a line of text
	 * @return true after the new line of text has been added to the existing
	 *         except when line is null or "" in which case nothing is added and
	 *         false is returned
	 */
	public boolean add(String line) {
		if (line == null)
			return false;
		if (line.equals(""))
			return false;

		if (firstLine == null) {
			firstLine = line;
			lastLine = this;
		} else {
			FormattedText newline = new FormattedText();
			newline.firstLine = line;
			lastLine.remainingText = newline;
			lastLine = newline;
		}
		return true;
	}

	/**
	 * @return the number of lines in the FormattedText
	 */
	public int numlines() {
		// TODO: Implement this method
		int cnt = 0;
		return cnt;
	}

	@Override
	public String toString() {
		FormattedText currline = this;
		StringBuilder text = new StringBuilder();
		while (currline.firstLine != null) {
			text.append(currline.firstLine);
			text.append("\n");
			currline = currline.remainingText;
			if (currline == null) {
			    break;
            }
		}
		return text.toString();
	}

}
