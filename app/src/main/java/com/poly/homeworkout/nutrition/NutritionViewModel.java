package com.poly.homeworkout.nutrition;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NutritionViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public NutritionViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is nutrition");
    }
    public LiveData<String> getText() {
        return mText;
    }
}
