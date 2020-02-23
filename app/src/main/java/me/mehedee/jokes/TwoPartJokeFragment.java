package me.mehedee.jokes;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import me.mehedee.jokes.data.TwoPartJoke;
import me.mehedee.jokes.databinding.FragmentTwoPartJokeBinding;


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
//        TwoPart DataBindingUtil.inflate(inflater, R.layout.fragment_two_part_joke, container, false);

        FragmentTwoPartJokeBinding binding= DataBindingUtil.inflate(inflater, R.layout.fragment_two_part_joke, container, false);

        binding.setJoke(twoPartJoke);
        GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                animateDelivery(binding);
                return true;
            }
        });

        binding.getRoot().setOnTouchListener((v,e) -> gestureDetector.onTouchEvent(e));


        return binding.getRoot();
    }

    private void animateDelivery(FragmentTwoPartJokeBinding binding) {
        long duration = 500;

        ObjectAnimator scaleUpDelivery = ObjectAnimator.ofFloat(binding.tvDelivery,
                "scaleX", 1f);
        scaleUpDelivery.setInterpolator(new OvershootInterpolator());
        scaleUpDelivery.setDuration(duration);

        ObjectAnimator scaleUpDelivery2 = ObjectAnimator.ofFloat(binding.tvDelivery,
                "scaleY", 1f);
        scaleUpDelivery2.setInterpolator(new OvershootInterpolator());
        scaleUpDelivery2.setDuration(duration);


        ObjectAnimator fadeOutLabel = ObjectAnimator.ofFloat(binding.textView2,
                "alpha", 0);
        fadeOutLabel.setDuration(duration);

        ObjectAnimator fadeInDelivery = ObjectAnimator.ofFloat(binding.tvDelivery,
                "alpha", 1);
        fadeInDelivery.setInterpolator(new OvershootInterpolator());
        fadeInDelivery.setDuration(duration);

        ObjectAnimator slideUpDelivery = ObjectAnimator.ofFloat(binding.tvDelivery,
                "translationY", 0f);
        slideUpDelivery.setInterpolator(new OvershootInterpolator());
        slideUpDelivery.setDuration(duration);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(fadeOutLabel).with(scaleUpDelivery);
        animatorSet.play(fadeOutLabel).with(scaleUpDelivery2);
        animatorSet.play(fadeOutLabel).with(slideUpDelivery);
        animatorSet.play(fadeOutLabel).with(fadeInDelivery);
        animatorSet.start();
    }

}
