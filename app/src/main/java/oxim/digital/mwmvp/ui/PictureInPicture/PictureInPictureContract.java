package oxim.digital.mwmvp.ui.PictureInPicture;

import oxim.digital.mwmvp.ui.BaseView;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public interface PictureInPictureContract {

    interface View extends BaseView {

    }

    interface Presenter extends ScopedPresenter<View> {

        void handlePictureInPictureButtonClick();

    }
}
