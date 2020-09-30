package com.example.clickable_links;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    // Initialize the variable.
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning the variable.
        textView = findViewById(R.id.text_view);

        // Initialize spannable string.
        SpannableString spannableString = new SpannableString(
                "Click on Google\n\nOR\n\nClick on Android Developer"
        );

        // Initialize Clickable span.
        ClickableSpan span1 =new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                // Initialize the intent.
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com"));

                // Set flag.
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // Start Activity.
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);

                // Set text color.
                ds.setColor(Color.RED);

                // Set underline.
                ds.setUnderlineText(false);
            }
        };

        // Initialize the clickable span.
        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                // Initialize the Intent.
                Intent intent = new Intent(Intent.ACTION_VIEW
                        ,Uri.parse("https://developers.google.com"));

                // Set flag.
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                // Start Activity.
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);

                // Set text color.
                ds.setColor(Color.BLUE);

                // Set Underline.
                ds.setUnderlineText(true);
            }
        };

        // Set span.
        spannableString.setSpan(span1,9,15
        ,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(span2, 30,35
        ,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Set text.
        textView.setText(spannableString);

        // Set link movement method.
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}