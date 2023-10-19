package ch.heig.dai.lab.fileio.samuelroland;

public class Transformer {

	private final String newName;
	private final int numWordsPerLine;
	private final String chuckNorris = "Chuck Norris";

	/**
	 * Constructor
	 * Initialize the Transformer with the name to replace "Chuck Norris" with
	 * and the number of words per line to use when wrapping the text.
	 * 
	 * @param newName         the name to replace "Chuck Norris" with
	 * @param numWordsPerLine the number of words per line to use when wrapping the
	 *                        text
	 */
	public Transformer(String newName, int numWordsPerLine) {
		this.newName = newName;
		this.numWordsPerLine = numWordsPerLine;
	}

	/**
	 * Replace all occurrences of "Chuck Norris" with the name given in the
	 * constructor.
	 * 
	 * @param source the string to transform
	 * @return the transformed string
	 */
	public String replaceChuck(String source) {
		Integer index;
		while ((index = source.indexOf(chuckNorris)) != -1) {
			source = source.substring(0, index) + newName
					+ source.substring(index + chuckNorris.length());
		}
		return source;
	}

	/**
	 * Capitalize the first letter of each word in the string.
	 * 
	 * @param source the string to transform
	 * @return the transformed string
	 */
	public String capitalizeWords(String source) {
		String[] pieces = source.split(" ");
		StringBuilder sentence = new StringBuilder("");
		// Extract each word, make the first letter uppercase and add the removed space
		for (var piece : pieces) {
			sentence.append(piece.substring(0, 1).toUpperCase()).append(piece.substring(1)).append(" ");
		}
		sentence = sentence.deleteCharAt(sentence.length() - 1);// remove last extra space
		return sentence.toString();
	}

	/**
	 * Wrap the text so that there are at most numWordsPerLine words per line.
	 * Number the lines starting at 1.
	 * 
	 * @param source the string to transform
	 * @return the transformed string
	 */
	public String wrapAndNumberLines(String source) {
		StringBuilder sentence = new StringBuilder("");
		Integer wordsOnLine = 0;
		Integer lineNumber = 1;
		String[] words = source.split(" ");

		for (var word : words) {
			if (wordsOnLine == 0) {
				// This the start of the line
				sentence.append(lineNumber++).append(".");
				sentence.append(" ").append(word);
				++wordsOnLine;
			} else if (wordsOnLine + 1 == numWordsPerLine) {
				// This is the end of the line
				sentence.append(" ").append(word).append('\n');
				wordsOnLine = 0;
			} else {
				// This is in the middle of the line
				++wordsOnLine;
				sentence.append(" ").append(word);
			}
		}
		sentence.append("\n");
		return sentence.toString();
	}
}
