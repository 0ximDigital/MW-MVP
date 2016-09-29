package oxim.digital.mwmvp.ui.single;

import oxim.digital.mwmvp.ui.BaseView;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public interface SingleContract {

    interface View extends BaseView {

        void runTask();

        void stopTask();

    }

    interface Presenter extends ScopedPresenter<View> {

    }
}
