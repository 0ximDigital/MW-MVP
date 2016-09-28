package oxim.digital.mwmvp.application.activity;

import android.support.v4.app.Fragment;

import dagger.Component;
import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPictureFragment;

@FragmentScope
@Component(
        dependencies = {ActivityComponent.class},
        modules = {
                FragmentModule.class,
                FragmentPresenterModule.class,
        }
)
public interface FragmentComponent extends FragmentComponentInjects, FragmentComponentExposes {

    final class Initializer {

        static public FragmentComponent init(Fragment fragment, ActivityComponent activityComponent) {
            return DaggerFragmentComponent.builder()
                                          .activityComponent(activityComponent)
                                          .fragmentModule(new FragmentModule(fragment))
                                          .fragmentPresenterModule(new FragmentPresenterModule(fragment))
                                          .build();
        }

        // No instances
        private Initializer() {
        }
    }
}
