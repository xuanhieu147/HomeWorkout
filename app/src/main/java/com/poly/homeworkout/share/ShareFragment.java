package com.poly.homeworkout.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.poly.homeworkout.R;
import com.poly.homeworkout.databinding.FragmentShareBinding;


public class ShareFragment extends Fragment {
    private ShareViewModel shareViewModel;
    FragmentShareBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        shareViewModel =
//                ViewModelProviders.of(this).get(ShareViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_share, container, false);
//
//
//        return root;
        binding = FragmentShareBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.imgMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
