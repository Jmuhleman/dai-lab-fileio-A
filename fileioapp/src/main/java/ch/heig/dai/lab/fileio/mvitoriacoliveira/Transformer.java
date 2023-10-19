package ch.heig.dai.lab.fileio.mvitoriacoliveira;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with 
     * and the number of words per line to use when wrapping the text.
     * @param newName the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        // TODO: Implement the method body here.
        if(!source.isEmpty()) {
            return source.replaceAll("Chuck Norris", newName);
        }
        return "";
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {
        // TODO: Implement the method body here.
        if(!source.isEmpty()) {
            String[] words = source.split(" ");
            StringBuilder capitalizedWords = new StringBuilder();

            for (String word : words) {
                capitalizedWords.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
            }
            return capitalizedWords.toString().trim();
        }
        return "";
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // TODO: Implement the method body here.
        // Use the StringBuilder class to build the result string.
        if(!source.isEmpty() & numWordsPerLine != 0) {
            String[] words = source.split(" ");

            StringBuilder result = new StringBuilder();
            int wordsCounter = 0;
            int lineNb = 0;

            for(String word : words){
                if(wordsCounter % numWordsPerLine == 0){
                    if(lineNb != 0){
                        //Replaces last blank space of a line with a line break.
                        result.replace(result.length() - 1, result.length(), "\n");
                    }
                    result.append(++lineNb).append(". ");
                }
                result.append(word).append(" ");
                ++wordsCounter;
            }
            // Replaces very last blank space with a line break.
            result.replace(result.length() - 1, result.length(), "\n");

            return result.toString();
        }
        return "";
    }
}   