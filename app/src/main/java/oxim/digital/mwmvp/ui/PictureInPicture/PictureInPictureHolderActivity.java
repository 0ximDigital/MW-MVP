package oxim.digital.mwmvp.ui.PictureInPicture;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.ActivityComponent;
import oxim.digital.mwmvp.application.activity.DaggerActivity;

public final class PictureInPictureHolderActivity extends DaggerActivity {

    @Inject
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_fragments_holder);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            final Fragment topFragment = PictureInPictureFragment.newInstance();
            final Fragment bottomFragment = PictureInPictureFragment.newInstance();
            fragmentManager.beginTransaction()
                           .add(R.id.top_container, topFragment)
                           .add(R.id.bottom_container, bottomFragment)
                           .commit();
        }
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
