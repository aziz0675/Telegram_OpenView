package com.example.telegram_openview.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
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

public class FifthsFragment extends Fragment {

    TextView tv_second;
    TextView tv_third;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fifths,container,false);
        tv_second = view.findViewById(R.id.tv_second);
        tv_third = view.findViewById(R.id.tv_third);
        changeStyleText(tv_second);

        return view;
    }

    public void changeStyleText(TextView textOne){

        String text1 = "Telegram keeps your messages";

        SpannableString ss = new SpannableString(text1);


        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        StyleSpan bold = new StyleSpan(Typeface.BOLD);

        ss.setSpan(boldSpan,0,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textOne.setText(ss);

    }
}
