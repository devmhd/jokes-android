package me.mehedee.jokes.data;

import me.mehedee.jokes.data.network.model.JokeResponse;

public class TwoPartJoke extends Joke{
    public String setup;
    public String delivery;


    public TwoPartJoke(JokeResponse response) {
        super(response);
    }
}
