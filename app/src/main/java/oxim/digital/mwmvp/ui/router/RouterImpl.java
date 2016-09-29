package oxim.digital.mwmvp.ui.router;

import android.content.Intent;
import android.os.Build;

import oxim.digital.mwmvp.application.activity.DaggerActivity;
import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPictureHolderActivity;
import oxim.digital.mwmvp.ui.drag.DragAndDropHolderActivity;
import oxim.digital.mwmvp.ui.single.SingleActivity;
import oxim.digital.mwmvp.ui.welcome.WelcomeActivity;

public final class RouterImpl implements Router {

    private final DaggerActivity daggerActivity;

    public RouterImpl(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Override
    public void showSingleActivity() {
        final Intent intent = SingleActivity.createIntent(daggerActivity);
        daggerActivity.startActivity(intent);
    }

    @Override
    public void showActivityInNewWindow() {
        final Intent intent = WelcomeActivity.createIntent(daggerActivity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        daggerActivity.startActivity(intent);
    }

    @Override
    public void showPictureInPicture() {
        final Intent intent = PictureInPictureHolderActivity.createIntent(daggerActivity);
        daggerActivity.startActivity(intent);
    }

    @Override
    public void showDragAndDrop() {
        final Intent intent = DragAndDropHolderActivity.createIntent(daggerActivity);
        daggerActivity.startActivity(intent);
    }

    @Override
    public void enterPictureInPicture() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            daggerActivity.enterPictureInPictureMode();
        }
    }
}
