// Fyaaz Bobat - 301071094 - 002

package fyaaz.bobat.s301071094.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FyaazViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FyaazViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}