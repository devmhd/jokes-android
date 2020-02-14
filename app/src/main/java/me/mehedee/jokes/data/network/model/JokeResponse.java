package me.mehedee.jokes.data.network.model;

public class JokeResponse {
    public Boolean error;
    public String joke;
    public String category;
    public String setup;
    public String delivery;
    public String type;
    public Flags flags;

    @Override
    public String toString() {
        return "JokeResponse{" +
                "error=" + error +
                ", joke='" + joke + '\'' +
                ", category='" + category + '\'' +
                ", setup='" + setup + '\'' +
                ", delivery='" + delivery + '\'' +
                ", type='" + type + '\'' +
                ", flags=" + flags +
                '}';
    }

    public static class Flags{
        public Boolean nsfw;
        public Boolean religious;
        public Boolean political;
        public Boolean racist;
        public Boolean sexist;

        @Override
        public String toString() {
            return "Flags{" +
                    "nsfw=" + nsfw +
                    ", religious=" + religious +
                    ", political=" + political +
                    ", racist=" + racist +
                    ", sexist=" + sexist +
                    '}';
        }
    }
}
