package oxim.digital.mwmvp.ui.drag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.ActivityComponent;
import oxim.digital.mwmvp.application.activity.DaggerActivity;

public final class DragAndDropHolderActivity extends DaggerActivity {

    @Inject
    FragmentManager fragmentManager;

    public static Intent createIntent(final Context context) {
        final Intent intent = new Intent(context, DragAndDropHolderActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);

        if (savedInstanceState == null) {
            final Fragment fragment = DragAndDropFragment.newInstance();
            fragmentManager.beginTransaction()
                           .add(R.id.fragment_container, fragment)
                           .commit();
        }
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
