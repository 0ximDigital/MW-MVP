package oxim.digital.mwmvp.ui.single;

import oxim.digital.mwmvp.ui.BasePresenter;

public final class SinglePresenter extends BasePresenter<SingleContract.View> implements SingleContract.Presenter {

    @Override
    public void activate() {
        super.activate();
        doIfViewNotNull(SingleContract.View::runTask);
    }

    @Override
    public void deactivate() {
        doIfViewNotNull(SingleContract.View::stopTask);
        super.deactivate();
    }
}
