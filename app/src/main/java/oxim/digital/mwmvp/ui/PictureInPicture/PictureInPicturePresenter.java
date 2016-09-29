package oxim.digital.mwmvp.ui.PictureInPicture;

import oxim.digital.mwmvp.ui.BasePresenter;
import oxim.digital.mwmvp.ui.router.Router;

public final class PictureInPicturePresenter extends BasePresenter<PictureInPictureContract.View> implements PictureInPictureContract.Presenter {

    private final Router router;

    public PictureInPicturePresenter(final Router router) {
        this.router = router;
    }

    @Override
    public void handlePictureInPictureButtonClick() {
        router.enterPictureInPicture();
    }
}
