package oxim.digital.mwmvp.ui.welcome;

import oxim.digital.mwmvp.ui.BaseView;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public interface WelcomeContract {

    interface View extends BaseView {

    }

    interface Presenter extends ScopedPresenter<View> {

        void showSingleActivity();

        void showActivityInNewWindow();

        void showPictureInPicture();

        void showDragAndDrop();
    }
}
