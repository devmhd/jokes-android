package me.mehedee.jokes.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import me.mehedee.jokes.data.JokesRepository;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<Integer> status;
    public MutableLiveData<String> currentJoke;
    JokesRepository repository;

    public static final int STATUS_NO_JOKE = 0;
    public static final int STATUS_LOADING_JOKE = 1;
    public static final int STATUS_SHOWING_JOKE = 2;

    public MainActivityViewModel() {
        status = new MutableLiveData<>(STATUS_NO_JOKE);
        currentJoke = new MutableLiveData<>("CLICK THE BUTTON already!");

        repository = JokesRepository.getInstance();
    }

    public void loadJoke() {
        status.setValue(STATUS_LOADING_JOKE);

        repository.getOne(joke -> {
            currentJoke.postValue(joke.joke);

            status.postValue(STATUS_SHOWING_JOKE);
        });


    }
}
