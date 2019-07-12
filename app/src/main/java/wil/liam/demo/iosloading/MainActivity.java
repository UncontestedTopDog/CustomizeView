package wil.liam.demo.iosloading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wil.liam.demo.iosloadingview.LoadingView;
import wil.liam.demo.iosloadingview.LoadingViewBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new LoadingViewBuilder(this).setLoadText("HYAHAHA").build().show();
    }
}
