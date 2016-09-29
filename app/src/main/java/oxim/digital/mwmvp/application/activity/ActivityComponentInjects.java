package oxim.digital.mwmvp.application.activity;

import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPictureHolderActivity;
import oxim.digital.mwmvp.ui.drag.DragAndDropHolderActivity;
import oxim.digital.mwmvp.ui.fragmented.FragmentHolderActivity;
import oxim.digital.mwmvp.ui.single.SingleActivity;
import oxim.digital.mwmvp.ui.welcome.WelcomeActivity;

public interface ActivityComponentInjects {

    void inject(SingleActivity singleActivity);

    void inject(FragmentHolderActivity fragmentHolderActivity);

    void inject(PictureInPictureHolderActivity pictureInPictureHolderActivity);

    void inject(WelcomeActivity welcomeActivity);

    void inject(DragAndDropHolderActivity dragAndDropHolderActivity);
}
