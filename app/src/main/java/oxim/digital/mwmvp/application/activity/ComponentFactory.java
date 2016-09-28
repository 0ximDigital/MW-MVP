package oxim.digital.mwmvp.application.activity;

import oxim.digital.mwmvp.application.ApplicationComponent;
import oxim.digital.mwmvp.application.MwMvpApplication;

public final class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(MwMvpApplication rosettaApplication) {
        return ApplicationComponent.Initializer.init(rosettaApplication);
    }

    public static ActivityComponent createActivityComponent(DaggerActivity daggerActivity, MwMvpApplication mwMvpApplication) {
        return ActivityComponent.Initializer.init(daggerActivity, mwMvpApplication.getApplicationComponent());
    }

    public static FragmentComponent createFragmentComponent(DaggerFragment fragment, DaggerActivity daggerActivity) {
        return FragmentComponent.Initializer.init(fragment, daggerActivity.getActivityComponent());
    }
}
