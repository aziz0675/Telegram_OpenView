package com.example.telegram_openview.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telegram_openview.R;

public class FirstFragment extends Fragment {

    TextView tv_second;
    TextView tv_third;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        tv_second = view.findViewById(R.id.tv_second);
        tv_third = view.findViewById(R.id.tv_third);
        changeStyleText(tv_second,tv_third);

        return view;
    }

    public void changeStyleText(TextView textOne, TextView textTwo){

        String text1 = "The world's fastest messaging app.";
        String text2 = "It's free and secure.";

        SpannableString ss = new SpannableString(text1);
        SpannableString bb = new SpannableString(text2);


        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        StyleSpan bold = new StyleSpan(Typeface.BOLD);

        ss.setSpan(boldSpan,12,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        bb.setSpan(boldSpan,5,9,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        bb.setSpan(bold,14,20,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textOne.setText(ss);
        textTwo.setText(bb);
    }
}
