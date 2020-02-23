package me.mehedee.jokes.data;

import android.util.Log;

import androidx.core.util.Consumer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import me.mehedee.jokes.data.network.ApiClient;
import me.mehedee.jokes.data.network.JokesApiService;
import me.mehedee.jokes.data.network.model.JokeResponse;

public class JokesRepository {

    private static JokesRepository instance;
    private JokesApiService jokesApiService;

    private JokesRepository() {

        jokesApiService = ApiClient.getClient()
                .create(JokesApiService.class);
    }

    public static JokesRepository getInstance() {
        if (instance == null)
            instance = new JokesRepository();

        return instance;
    }

    public void getOne(final Consumer<Joke> jokeConsumer, final Runnable onError) {
        jokesApiService.getAJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<JokeResponse>() {
                    @Override
                    public void onSuccess(JokeResponse jokeResponse) {
                        Joke j = categorize(jokeResponse);
                        jokeConsumer.accept(j);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(this.getClass().getName(), "ERROR IN NETWORK", e);
                        onError.run();
                    }
                });
    }

    private Joke categorize(JokeResponse response){
        if (response.type.equals("single")){
            SingleJoke joke = new SingleJoke(response);
            joke.joke = response.joke;

            return joke;
        } else {
            TwoPartJoke joke = new TwoPartJoke(response);
            joke.setup = response.setup;
            joke.delivery = response.delivery;

            return joke;
        }
    }
}
