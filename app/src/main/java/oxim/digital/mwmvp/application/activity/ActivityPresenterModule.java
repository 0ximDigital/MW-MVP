package oxim.digital.mwmvp.application.activity;

import dagger.Module;
import dagger.Provides;
import oxim.digital.mwmvp.ui.single.SingleContract;
import oxim.digital.mwmvp.ui.single.SinglePresenter;
import oxim.digital.mwmvp.ui.router.Router;
import oxim.digital.mwmvp.ui.welcome.WelcomeContract;
import oxim.digital.mwmvp.ui.welcome.WelcomePresenter;

@Module
public final class ActivityPresenterModule {

    @Provides
    @ActivityScope
    SingleContract.Presenter provideMainContractPresenter() {
        return new SinglePresenter();
    }

    @Provides
    @ActivityScope
    WelcomeContract.Presenter provideWelcomePreesnter(final Router router) {
        return new WelcomePresenter(router);
    }
}
