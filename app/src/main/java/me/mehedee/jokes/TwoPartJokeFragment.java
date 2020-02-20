package me.mehedee.jokes;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.mehedee.jokes.data.TwoPartJoke;


public class TwoPartJokeFragment extends Fragment {

    private TwoPartJoke twoPartJoke;

    public TwoPartJokeFragment() {
        // Required empty public constructor
    }

    public static TwoPartJokeFragment getInstance(TwoPartJoke joke){
        return new TwoPartJokeFragment(joke);
    }

    private TwoPartJokeFragment(TwoPartJoke twoPartJoke) {
        this.twoPartJoke = twoPartJoke;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two_part_joke, container, false);
    }

}
