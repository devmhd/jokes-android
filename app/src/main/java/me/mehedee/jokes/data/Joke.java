package me.mehedee.jokes.data;

import me.mehedee.jokes.data.network.model.JokeResponse;

public class Joke {
    public String joke;
    public String setup;
    public String delivery;
    public String type;
    public boolean isNSFW;
    public boolean isReligious;
    public boolean isPolitical;
    public boolean isSexist;
    public boolean isRacist;

    public Joke(JokeResponse response) {
        type = response.type;
        setup = response.setup;
        delivery = response.delivery;
        joke = response.joke;
        isNSFW = response.flags.nsfw;
        isReligious = response.flags.religious;
        isPolitical = response.flags.political;
        isSexist = response.flags.sexist;
        isRacist = response.flags.racist;
    }
}
