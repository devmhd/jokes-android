package me.mehedee.jokes.data;

import me.mehedee.jokes.data.network.model.JokeResponse;

public class Joke {
    public boolean isNSFW;
    public boolean isReligious;
    public boolean isPolitical;
    public boolean isSexist;
    public boolean isRacist;

    public Joke(JokeResponse response) {
        isNSFW = response.flags.nsfw;
        isReligious = response.flags.religious;
        isPolitical = response.flags.political;
        isSexist = response.flags.sexist;
        isRacist = response.flags.racist;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "isNSFW=" + isNSFW +
                ", isReligious=" + isReligious +
                ", isPolitical=" + isPolitical +
                ", isSexist=" + isSexist +
                ", isRacist=" + isRacist +
                '}';
    }
}
