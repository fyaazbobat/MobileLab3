// Fyaaz Bobat - 301071094 - 002

package fyaaz.bobat.s301071094.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;


import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fyaaz.bobat.s301071094.R;

public class S301071094Fragment extends Fragment {

    private S301071094ViewModel s301071094ViewModel;


    public ImageView moon;
    private Animation an;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        s301071094ViewModel =
                ViewModelProviders.of(this).get(S301071094ViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        Button start = root.findViewById(R.id.btnstart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moon = root.findViewById(R.id.moon);
                // Load the appropriate animation
                an =  AnimationUtils.loadAnimation(getContext(), R.anim.moonintro);
                // Start the animation
                moon.startAnimation(an);
            }
        });

        Button stop = root.findViewById(R.id.btnstop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moon.clearAnimation();
            }
        });

        return root;
    }
}



