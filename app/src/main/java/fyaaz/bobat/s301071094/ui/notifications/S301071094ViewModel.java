// Fyaaz Bobat - 301071094 - 002

package fyaaz.bobat.s301071094.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class S301071094ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S301071094ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}