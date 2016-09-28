package oxim.digital.mwmvp.application.activity;

import dagger.Module;
import dagger.Provides;
import oxim.digital.mwmvp.ui.main.MainContract;
import oxim.digital.mwmvp.ui.main.MainPresenter;

@Module
public final class ActivityPresenterModule {

    private final DaggerActivity daggerActivity;

    public ActivityPresenterModule(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    private ActivityComponent getActivityComponent() {
        return daggerActivity.getActivityComponent();
    }

    @Provides
    @ActivityScope
    MainContract.Presenter provideMainContractPresenter() {
        final MainPresenter mainPresenter = new MainPresenter((MainContract.View) daggerActivity);
        getActivityComponent().inject(mainPresenter);
        return mainPresenter;
    }

}