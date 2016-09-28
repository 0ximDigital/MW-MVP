package oxim.digital.mwmvp.application.activity;

import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPictureFragment;
import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPicturePresenter;
import oxim.digital.mwmvp.ui.fragmented.MainFragment;
import oxim.digital.mwmvp.ui.fragmented.MainFragmentPresenter;

public interface FragmentComponentInjects {

    void inject(MainFragment mainFragment);

    void inject(PictureInPictureFragment pictureInPictureFragment);

    void inject(MainFragmentPresenter mainFragmentPresenter);

    void inject(PictureInPicturePresenter pictureInPicturePresenter);
}
