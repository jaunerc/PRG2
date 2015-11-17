/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jaunerc.prg2.oop9;

/**
 *
 * @author Cyrill Jauner
 */
public class KnockKnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;
    private static final int NUMJOKES = 5;
    
    private int state = WAITING;
    private int currJoke = 0;
    
    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
    private String[] answers = { "Turnip the heat, it's cold in here!",
                                 "I didn't know you could yodel!",
                                 "Bless you!",
                                 "Is there an owl in here?",
                                 "Is there an echo in here?" };
    
    public String processInput(String input) {
        String output = null;
        
        if (state == WAITING) {
            output = "Knock! Knock!";
            state = SENTKNOCKKNOCK;
        } else if (state == SENTKNOCKKNOCK) {
            if (input.equalsIgnoreCase("Who's there?")) {
                output = clues[currJoke];
                state = SENTCLUE;
            } else {
                output = "You're supposed to say \"Who's there?\"! " +
			    "Try again. Knock! Knock!";
            }
        } else if (state == SENTCLUE) {
            if (input.equalsIgnoreCase(clues[currJoke] + " who?")) {
                output = answers[currJoke] + " Want another? (y/n)";
                state = ANOTHER;
            } else {
                output = "You're supposed to say \"" + 
			    clues[currJoke] + 
			    " who?\"" + 
			    "! Try again. Knock! Knock!";
                state = SENTKNOCKKNOCK;
            }
        } else if (state == ANOTHER) {
            if (input.equalsIgnoreCase("y")) {
                output = "Knock! Knock!";
                if (currJoke == (NUMJOKES - 1))
                    currJoke = 0;
                else
                    currJoke++;
                state = SENTKNOCKKNOCK;
            } else {
                output = "Bye.";
                state = WAITING;
            }
        }
        
        return output;
    }
}
