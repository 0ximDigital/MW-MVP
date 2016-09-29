package oxim.digital.mwmvp.application.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import oxim.digital.mwmvp.ui.PresenterRelay;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public abstract class MwActivity extends DaggerActivity {

    @Inject
    PresenterRelay presenterRelay;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterRelay.attachPresenter(getPresenter());
        Log.e("LIFE", "onCreate");
    }

    @Override
    public void onMultiWindowModeChanged(final boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        Log.e("LIFE", "OnMWMChanged ->  " + isInMultiWindowMode);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LIFE", "onStart");
        presenterRelay.onStart();
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        Log.e("LIFE", "onConfigurationChange");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LIFE", "onResime");
        presenterRelay.onResume();
    }

    @NonNull
    protected abstract ScopedPresenter getPresenter();

    @Override
    protected void onPause() {
        Log.e("LIFE", "onPause");
        presenterRelay.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("LIFE", "onStop");
        presenterRelay.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("LIFE", "onDestroy");
        super.onDestroy();
    }
}
