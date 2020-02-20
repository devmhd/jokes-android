package me.mehedee.jokes;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class JokeLoadingFragment extends Fragment {



    public JokeLoadingFragment() {
        // Required empty public constructor
    }


    public static JokeLoadingFragment newInstance() {
        return new JokeLoadingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_joke_loading, container, false);
    }

}
