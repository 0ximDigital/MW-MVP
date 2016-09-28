package oxim.digital.mwmvp.application.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import dagger.Module;
import dagger.Provides;
import oxim.digital.mwmvp.ui.MultiWindowPresenterRelay;
import oxim.digital.mwmvp.ui.PresenterRelay;
import oxim.digital.mwmvp.ui.SingleWindowPresenterRelay;
import oxim.digital.mwmvp.ui.router.Router;
import oxim.digital.mwmvp.ui.router.RouterImpl;

@Module
public final class ActivityModule {

    private final DaggerActivity daggerActivity;

    public ActivityModule(DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Provides
    @ActivityScope
    @ForActivity
    Context provideActivityContext() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {
        return daggerActivity.getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    Router provideRouter() {
        return new RouterImpl();
    }

    @Provides
    PresenterRelay providePresenterRelay() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return new MultiWindowPresenterRelay(daggerActivity.isInMultiWindowMode());
        } else {
            return new SingleWindowPresenterRelay();
        }
    }

    interface Exposes {

        Router router();

        FragmentManager fragmentManager();

        PresenterRelay presenterRelay();
    }
}
