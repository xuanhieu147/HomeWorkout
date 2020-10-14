package com.poly.homeworkout.exercise;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.poly.homeworkout.R;

public class ExerciseFragment extends Fragment {

    private ExerciseViewModel exerciseViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        exerciseViewModel =
                ViewModelProviders.of(this).get(ExerciseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exercise, container, false);
        final  CardView cardView = (CardView) root.findViewById(R.id.onClickNutrition);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return root;
    }

}
