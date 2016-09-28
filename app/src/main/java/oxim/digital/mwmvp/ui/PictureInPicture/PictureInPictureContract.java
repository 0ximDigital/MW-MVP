package oxim.digital.mwmvp.ui.PictureInPicture;

import oxim.digital.mwmvp.ui.BaseView;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public interface PictureInPictureContract {

    interface View extends BaseView {

        void changeBackgroundColor();

    }

    interface Presenter extends ScopedPresenter {

        void handleButtonClick();
    }
}
