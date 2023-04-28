package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Class SharedMemory represents the shared memory
 * It contains a list of tokens
 */

public class SharedMemory {
    private final ArrayList<Token> tokens = new ArrayList<>();

    public SharedMemory(){}

    public SharedMemory(int n) {
        for(int i = 0; i<n*n; i++){
            Token t = new Token(i);
            tokens.add(t);
        }

    }

    /**
     * Method "extractTokens" extracts a number of tokens from the list and shuffles them.
     * @param howMany
     * @return a list of tokens
     */
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            Collections.shuffle(tokens);
            extracted.add(tokens.get(i));

        }
        return extracted;
    }
}
