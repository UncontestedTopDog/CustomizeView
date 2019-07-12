package wil.liam.demo.iosloadingview;

import android.os.Build;
import android.support.annotation.RequiresApi;

public class LoadingView implements LoadingFragment.OnFragmentCreatedListener{

    private LoadingOptions loadingOptions;
    private LoadingFragment loadingFragment;

    public LoadingView(LoadingOptions loadingOptions) {
        this.loadingOptions = loadingOptions;
        initView();
    }

    private void initView() {
        loadingFragment = new LoadingFragment();
        loadingFragment.addOnFragmentCreatedListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public void onFragemntCreated() {
        if (loadingOptions.loadText!=null)
            loadingFragment.setLoadText(loadingOptions.loadText);
    }

    public void show(){
        if (loadingFragment != null)
            loadingFragment.show(loadingOptions.activity.getSupportFragmentManager(),"");
    }
}
