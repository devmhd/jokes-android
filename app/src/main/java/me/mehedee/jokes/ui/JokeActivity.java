package me.mehedee.jokes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import me.mehedee.jokes.JokeLoadingFragment;
import me.mehedee.jokes.NoJokeFragment;
import me.mehedee.jokes.R;
import me.mehedee.jokes.SingleJokeFragment;
import me.mehedee.jokes.TwoPartJokeFragment;
import me.mehedee.jokes.data.Joke;
import me.mehedee.jokes.data.SingleJoke;
import me.mehedee.jokes.data.TwoPartJoke;
import me.mehedee.jokes.databinding.ActivityJokeBinding;

public class JokeActivity extends AppCompatActivity {

    private JokeActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityJokeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joke);

        vm = new ViewModelProvider(this).get(JokeActivityViewModel.class);

        binding.setVm(vm);
        binding.setLifecycleOwner(this);

        vm.status.observe(this, status -> {
            switch (status){
                case JokeActivityViewModel.STATUS_NO_JOKE:
                    showNoJoke();
                    break;
                case JokeActivityViewModel.STATUS_LOADING_JOKE:
                    showLoading();
                    break;

                case JokeActivityViewModel.STATUS_SHOWING_JOKE:
                    showJoke(vm.currentJoke.getValue());
                    break;
                case JokeActivityViewModel.STATUS_NO_INTRENET:
                    showNoInternet();
            }
        });
    }

    private void showNoJoke(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, NoJokeFragment.newInstance(), "NOJOKE").commit();
    }

    private void showLoading(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, JokeLoadingFragment.newInstance(), "LOADINGJOKE").commit();
    }

    private void showNoInternet(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new NoInternetFragment(), "NONET").commit();
    }

    private void showJoke(Joke joke){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, prepare(joke), "JOKE").commit();
    }

    private Fragment prepare(Joke joke){
        if (joke instanceof SingleJoke)
            return SingleJokeFragment.newInstance((SingleJoke) joke);
        return TwoPartJokeFragment.getInstance((TwoPartJoke) joke);
    }
}
