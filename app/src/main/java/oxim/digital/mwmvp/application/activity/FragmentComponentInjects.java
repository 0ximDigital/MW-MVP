package oxim.digital.mwmvp.application.activity;

import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPictureFragment;
import oxim.digital.mwmvp.ui.drag.DragAndDropFragment;
import oxim.digital.mwmvp.ui.fragmented.MainFragment;

public interface FragmentComponentInjects {

    void inject(MainFragment mainFragment);

    void inject(PictureInPictureFragment pictureInPictureFragment);

    void inject(DragAndDropFragment dragAndDropFragment);
}
