package oxim.digital.mwmvp.ui.PictureInPicture;

import oxim.digital.mwmvp.ui.BasePresenter;

public final class PictureInPicturePresenter extends BasePresenter<PictureInPictureContract.View> implements PictureInPictureContract.Presenter {

    public PictureInPicturePresenter() {

    }

    @Override
    public void handleButtonClick() {
        doIfViewNotNull(PictureInPictureContract.View::changeBackgroundColor);
    }
}
