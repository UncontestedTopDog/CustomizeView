package wil.liam.demo.iosloadingview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;


public class LoadingFragment extends DialogFragment {

    OnFragmentCreatedListener listener;

    ProgressBar loadProgress;
    TextView loadText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, R.style.LoadingStyle);
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.fragment_loading_view, container, false);
        loadText = view.findViewById(R.id.load_text);
        loadProgress = view.findViewById(R.id.load_progress);
        setCancelable(false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (listener != null)
            listener.onFragemntCreated();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Window win = getDialog().getWindow();
        // 一定要设置Background，如果不设置，window属性设置无效
        win.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        WindowManager.LayoutParams params = win.getAttributes();
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width = dip2px(getContext(),100);
        params.height = dip2px(getContext(),100);
        win.setAttributes(params);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void setLoadText(String text) {
        loadText.setText(text);
    }

    //点击返回按钮也不会消失
    public void setCancleable(boolean cancleable){
        setCancelable(cancleable);
    }

    //点击返回按钮会消失
    public void setCanceledOnTouchOutside(boolean cancleable){
        getDialog().setCanceledOnTouchOutside(cancleable);
    }

    void addOnFragmentCreatedListener(OnFragmentCreatedListener fragmentCreatedListener) {
        listener = fragmentCreatedListener;
    }

    interface OnFragmentCreatedListener {
        void onFragemntCreated();
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
