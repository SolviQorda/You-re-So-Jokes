package com.example;


import java.util.Random;

public class JokesJavaLibrary {

    public String jokeOne = "Q: How do you get Pikachu on a bus? A: Pokémon!";
    public String jokeTwo = "Knock knock.\n" +
            "Who\'s there?\n" +
            "Bare.\n" +
            "Bare who?\n" +
            "Bare bum.";

    public String[] jokesArray = {
            "Q: What does a nosey pepper do? \nA: Gets jalapeno business!",
            "Q: What do you call a fake noodle? \nA: An Impasta",
            "Q: What happens if you eat yeast and shoe polish? \nA: Every morning you'll rise and shine! ",
            "Q: What's the difference between a guitar and a fish? \nA: You can't tuna fish.",
            "Q: What is it called when a cat wins a dog show? \nA: A CAT-HAS-TROPHY!",
            "Q: Why can't you give Elsa a balloon? \nA: Because she will Let it go.",
            "Q: How do you get Pikachu on a bus? \nA: Pokémon!",
            "Knock knock.\n" +
                    "Who\'s there?\n" +
                    "Bare.\n" +
                    "Bare who?\n" +
                    "Bare bum."
    };

    int index = new Random().nextInt(jokesArray.length);
    public String randomJoke = (jokesArray[index]);

}
