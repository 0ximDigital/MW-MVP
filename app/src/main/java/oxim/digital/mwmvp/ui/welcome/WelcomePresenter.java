package oxim.digital.mwmvp.ui.welcome;

import oxim.digital.mwmvp.ui.BasePresenter;
import oxim.digital.mwmvp.ui.router.Router;

public final class WelcomePresenter extends BasePresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    private final Router router;

    public WelcomePresenter(final Router router) {
        this.router = router;
    }

    @Override
    public void showSingleActivity() {
        router.showSingleActivity();
    }

    @Override
    public void showActivityInNewWindow() {
        router.showActivityInNewWindow();
    }

    @Override
    public void showPictureInPicture() {
        router.showPictureInPicture();
    }

    @Override
    public void showDragAndDrop() {
        router.showDragAndDrop();
    }
}
