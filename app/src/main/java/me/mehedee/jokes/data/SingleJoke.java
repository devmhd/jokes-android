package me.mehedee.jokes.data;

import me.mehedee.jokes.data.network.model.JokeResponse;

public class SingleJoke extends Joke{
    public String joke;

    public SingleJoke(JokeResponse response) {
        super(response);


    }
}
