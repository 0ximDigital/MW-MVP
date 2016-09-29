package oxim.digital.mwmvp.ui.drag;

import oxim.digital.mwmvp.ui.BaseView;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public interface DragAndDropContract {

    interface View extends BaseView {

    }

    interface Presenter extends ScopedPresenter<View> {

    }
}
