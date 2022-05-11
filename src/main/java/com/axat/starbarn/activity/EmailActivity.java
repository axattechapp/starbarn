package com.axat.starbarn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.axat.starbarn.R;
import com.axat.starbarn.databinding.ActivityEmailBinding;

public class EmailActivity extends AppCompatActivity {
    ActivityEmailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_email);


        Spannable word = new SpannableString("By Continuing you agree to our ");

        word.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tabbg_unselected, null)), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        binding.textcondition.setText(word);
        Spannable wordTwo = new SpannableString("Terms of Service\n");

        wordTwo.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white, null)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.textcondition.append(wordTwo);
        Spannable wordThree = new SpannableString(" and");

        wordThree.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tabbg_unselected, null)), 0, wordThree.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.textcondition.append(wordThree);
        Spannable wordfour = new SpannableString(" Privacy Policy");

        wordfour.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white, null)), 0, wordfour.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.textcondition.append(wordfour);

        binding.textcontinue.setOnClickListener(view -> {
//            startActivity(new Intent(EmailActivity.this,CreatePasswordActivity.class));
            Intent intent=new Intent(EmailActivity.this,CreatePasswordActivity.class);
            intent.putExtra("email",binding.editemailedittext.getText().toString());
            startActivity(intent);
        });

    }
}