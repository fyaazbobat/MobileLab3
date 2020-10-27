// Fyaaz Bobat - 301071094 - 002

package fyaaz.bobat.s301071094.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Spinner;
import android.graphics.Color;




import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fyaaz.bobat.s301071094.R;

public class BobatFragment extends Fragment {

    public BobatCanvasView Canvas;
    private BobatViewModel bobatViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bobatViewModel =
                ViewModelProviders.of(this).get(BobatViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        Canvas  = (BobatCanvasView) root.findViewById(R.id.canvas);
        Button select = root.findViewById((R.id.select));
        select.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Spinner colors = root.findViewById(R.id.brushcolor);
                TextView colorText = (TextView) colors.getSelectedView();
                Spinner thicknessbrush = root.findViewById(R.id.thicknessbrush);
                TextView brushText = (TextView) thicknessbrush.getSelectedView();
                String thickness = brushText.getText().toString();
                String color = colorText.getText().toString();
                Canvas.getSelectedOptions(color, thickness);

            }
        });
        Button cancelButton = root.findViewById((R.id.cancel));
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Canvas.clearPath();
            }
        });


        bobatViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;


    }
}