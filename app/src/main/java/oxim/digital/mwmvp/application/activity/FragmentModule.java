package oxim.digital.mwmvp.application.activity;

import dagger.Module;

@Module
public final class FragmentModule {

    private final DaggerFragment fragment;

    public FragmentModule(DaggerFragment fragment) {
        this.fragment = fragment;
    }
}
