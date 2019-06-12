package com.example.retrofitapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofitapplication.presenter.MainActivityPresenter;
import com.example.retrofitapplication.view.MainActivityView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainActivityView {
    private Button button;
    private TextView textView;
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter = new MainActivityPresenter(this);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        button.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                onButtonClick();
                break;
        }
    }

    @Override
    public void onButtonClick() {
        mainActivityPresenter.updateButtonClick();
    }

    @Override
    public void onUpdateData(String quota_max) {
        textView.setText(quota_max);
    }


}
