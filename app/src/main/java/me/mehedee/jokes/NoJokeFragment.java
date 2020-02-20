package me.mehedee.jokes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class NoJokeFragment extends Fragment {

    public NoJokeFragment() {
        // Required empty public constructor
    }

    public static NoJokeFragment newInstance() {
        return new NoJokeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_no_joke, container, false);
    }
}
