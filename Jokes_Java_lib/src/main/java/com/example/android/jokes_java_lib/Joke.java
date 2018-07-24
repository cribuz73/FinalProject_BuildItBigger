package com.example.android.jokes_java_lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Joke {

    private static ArrayList<String> jokesArray;

    public static final String[] JOKES = {"A brunette says,'Look, there's a dead bird.' A blonde looks up and asks, 'Where?'",
            "A dumb blonde, a smart blonde and  Santa Claus are walking down the street when they spot a $100 bill.Who picks it up? The dumb blonde -- the other two are make-believe.",
            "What about the blonde who stayed up all night studying for a urine test?",
            "Did you hear about the blonde who was two hours late getting home because the escalator got stuck?",
            "How does a blonde kill a fish? She drowns it.",
            "Why did the blond climb over the glass wall? To see what was on the other side.",
            "What do blondes and beer bottles have in common? They are both empty from the neck up.",
            "What do you call three blondes in a freezer? Frosted flakes.",
            "What do you do if a blonde throws a hand grenade at you? Pull the pin and throw it back."};

    public Joke() {
        jokesArray = new ArrayList<>(Arrays.asList(JOKES));
    }

    public ArrayList<String> getJokesArray (){
        return jokesArray;
    }
}
