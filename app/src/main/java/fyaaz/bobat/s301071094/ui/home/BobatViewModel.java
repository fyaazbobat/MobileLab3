// Fyaaz Bobat - 301071094 - 002

package fyaaz.bobat.s301071094.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BobatViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BobatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}