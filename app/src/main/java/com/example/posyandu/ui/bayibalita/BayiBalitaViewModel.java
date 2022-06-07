package com.example.posyandu.ui.bayibalita;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BayiBalitaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BayiBalitaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}