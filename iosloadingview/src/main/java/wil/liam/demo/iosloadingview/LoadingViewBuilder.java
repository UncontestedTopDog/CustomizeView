package wil.liam.demo.iosloadingview;


import android.support.v7.app.AppCompatActivity;

public class LoadingViewBuilder {
    private LoadingOptions loadingOptions;

    public LoadingViewBuilder(AppCompatActivity activity){
        loadingOptions = new LoadingOptions();
        loadingOptions.activity = activity;
    }

    public LoadingViewBuilder setLoadText(String loadText){
        loadingOptions.loadText = loadText;
        return this;
    }

    public LoadingView build(){
        return new LoadingView(loadingOptions);
    }

}
