package oxim.digital.mwmvp.ui.main;

import oxim.digital.mwmvp.ui.BasePresenter;

public final class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(final MainContract.View view) {
        super(view);
    }

    @Override
    public void activate() {
        super.activate();
        doIfViewNotNull(MainContract.View::runTask);
    }

    @Override
    public void deactivate() {
        doIfViewNotNull(MainContract.View::stopTask);
        super.deactivate();
    }
}
