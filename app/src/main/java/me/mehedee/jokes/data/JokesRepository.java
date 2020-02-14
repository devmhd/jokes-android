package me.mehedee.jokes.data;

import android.content.Context;
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

    private JokesRepository(Context ctx){

        jokesApiService = ApiClient.getClient(ctx)
                .create(JokesApiService.class);
    }
    public static JokesRepository getInstance(Context ctx){
        if (instance == null)
            instance = new JokesRepository(ctx);

        return instance;
    }

    public void getOne(final Consumer<Joke> jokeConsumer){
        jokesApiService.getAJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<JokeResponse>() {
                    @Override
                    public void onSuccess(JokeResponse jokeResponse) {
                        Joke j = new Joke(jokeResponse);
                        jokeConsumer.accept(j);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(this.getClass().getName(), "ERROR IN NETWORK", e);
                    }
                });
    }
}
