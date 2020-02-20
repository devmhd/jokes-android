package me.mehedee.jokes;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.mehedee.jokes.data.SingleJoke;
import me.mehedee.jokes.databinding.SingleJokeFragmentBinding;

public class SingleJokeFragment extends Fragment {

    private SingleJokeViewModel mViewModel;
    private SingleJoke joke;

    public static SingleJokeFragment newInstance(SingleJoke singleJoke) {
        return new SingleJokeFragment(singleJoke);
    }

    public SingleJokeFragment(SingleJoke joke) {
        this.joke = joke;
    }

    public SingleJokeFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        SingleJokeFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.single_joke_fragment, container, false);
        binding.setJoke(joke);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SingleJokeViewModel.class);
    }

}
