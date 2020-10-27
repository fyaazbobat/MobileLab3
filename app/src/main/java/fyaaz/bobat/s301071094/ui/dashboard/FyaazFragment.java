// Fyaaz Bobat - 301071094 - 002
package fyaaz.bobat.s301071094.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fyaaz.bobat.s301071094.R;

public class FyaazFragment extends Fragment {

    private FyaazViewModel fyaazViewModel;
    ImageView imgage;
    AnimationDrawable mframeAnimation;
    int animationspeed;


    private void startAnimation()
    {


        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.img4);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.img6);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.img7);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.img8);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.img9);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);


        imgage.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fyaazViewModel =
                ViewModelProviders.of(this).get(FyaazViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        imgage =  (ImageView) root.findViewById(R.id.ImageView_Boy);
        Button start = root.findViewById(R.id.ButtonStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner timer = root.findViewById(R.id.spinnerTimer);
                TextView timerText = (TextView) timer.getSelectedView();
                String text = timerText.getText().toString();
                switch (text) {
                    case "0.2 sec":
                        animationspeed = 200;
                        break;
                    case "0.4 sec":
                        animationspeed = 400;
                        break;
                    case "0.6 sec":
                        animationspeed = 600;
                        break;
                    case "0.8 sec":
                        animationspeed = 800;
                        break;
                    default:
                        break;
                }
                startAnimation();

                Button stop = root.findViewById(R.id.ButtonStop);
                stop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopAnimation();
                    }
                });

            }

            // Handle Stop Button
        });


        return root;
    }
}