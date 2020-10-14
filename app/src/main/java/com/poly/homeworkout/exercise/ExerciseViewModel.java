package com.poly.homeworkout.exercise;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExerciseViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ExerciseViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is view eeee");
    }
    public LiveData<String> getText() {
        return mText;
    }
}
