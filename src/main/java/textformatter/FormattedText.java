package textformatter;

public class FormattedText {

	// we use a recursive list definition for our formatted text
	private String firstLine;
	private FormattedText remainingText;
	private FormattedText lastLine;
	private static final String EMPTY = "";

	/* ** Rep Invariant
	      - firstLine is not null
	      - lastLine is not null
	   ** Abstraction Function
	      - the text is firstLine + remainingText.toString() when firstLine and remainingText are not null
	      - if firstLine is null then the text represented is empty text
	      - if firstLine is not null and remainingText is null then text is only firstLine
	 */


	public FormattedText() {
	    firstLine = EMPTY;
	    lastLine = this;
	    remainingText = null;
    }

	/**
	 * Create a new FormattedText object
     * @param line is the text to add, is not null,
     *             and does not contain the newline or carriage return characters
	 */
	public FormattedText(String line) {
		firstLine = line;
		lastLine = this;
        remainingText = null;
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
		if (line.equals(EMPTY))
			return false;

		if (firstLine == EMPTY) {
			firstLine = line;
			lastLine = this;
		} else {
            FormattedText newline = new FormattedText(line);
            lastLine = newline;
            FormattedText next = remainingText;
            FormattedText prev = this;
            while (next != null) {
                prev = next;
                next = next.remainingText;
                prev.lastLine = newline;
            }
            prev.remainingText = newline;
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
		while (currline != null) {
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
