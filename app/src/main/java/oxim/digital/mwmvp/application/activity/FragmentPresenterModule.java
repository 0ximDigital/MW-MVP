package oxim.digital.mwmvp.application.activity;

import dagger.Module;
import dagger.Provides;
import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPictureContract;
import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPicturePresenter;
import oxim.digital.mwmvp.ui.fragmented.FragmentedContract;
import oxim.digital.mwmvp.ui.fragmented.MainFragmentPresenter;

@Module
public final class FragmentPresenterModule {

    private final DaggerFragment daggerFragment;

    public FragmentPresenterModule(final DaggerFragment daggerFragment) {
        this.daggerFragment = daggerFragment;
    }

    private FragmentComponent getFragmentComponent() {
        return daggerFragment.getFragmentComponent();
    }

    @Provides
    @FragmentScope
    public FragmentedContract.Presenter provideFragmentedPresenter() {
        final MainFragmentPresenter mainFragmentPresenter = new MainFragmentPresenter((FragmentedContract.View) daggerFragment);
        getFragmentComponent().inject(mainFragmentPresenter);
        return mainFragmentPresenter;
    }

    @Provides
    @FragmentScope
    public PictureInPictureContract.Presenter providePictureInPicturePresenter() {
        final PictureInPicturePresenter pictureInPicturePresenter = new PictureInPicturePresenter((PictureInPictureContract.View) daggerFragment);
        getFragmentComponent().inject(pictureInPicturePresenter);
        return pictureInPicturePresenter;
    }
}
