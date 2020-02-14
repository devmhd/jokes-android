package me.mehedee.jokes.data.network;

import io.reactivex.Single;
import me.mehedee.jokes.data.network.model.JokeResponse;
import retrofit2.http.GET;

public interface JokesApiService {

    @GET("notes/all")
    Single<JokeResponse> getAJoke();
}
