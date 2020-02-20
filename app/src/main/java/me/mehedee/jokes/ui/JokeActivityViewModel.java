package me.mehedee.jokes.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import me.mehedee.jokes.data.Joke;
import me.mehedee.jokes.data.JokesRepository;
import me.mehedee.jokes.data.SingleJoke;

public class JokeActivityViewModel extends ViewModel {

    public MutableLiveData<Integer> status;
    public MutableLiveData<Joke> currentJoke;
    private JokesRepository repository;

    public static final int STATUS_NO_JOKE = 0;
    public static final int STATUS_LOADING_JOKE = 1;
    public static final int STATUS_SHOWING_JOKE = 2;

    public JokeActivityViewModel() {
        status = new MutableLiveData<>(STATUS_NO_JOKE);
        repository = JokesRepository.getInstance();
        currentJoke = new MutableLiveData<>();
    }

    public void loadJoke() {
        status.setValue(STATUS_LOADING_JOKE);

        repository.getOne(joke -> {
            currentJoke.postValue(joke);

            status.postValue(STATUS_SHOWING_JOKE);
        });


    }
}
