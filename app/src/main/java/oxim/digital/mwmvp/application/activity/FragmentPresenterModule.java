package oxim.digital.mwmvp.application.activity;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPictureContract;
import oxim.digital.mwmvp.ui.PictureInPicture.PictureInPicturePresenter;
import oxim.digital.mwmvp.ui.fragmented.FragmentedContract;
import oxim.digital.mwmvp.ui.fragmented.MainFragmentPresenter;
import oxim.digital.mwmvp.ui.router.Router;

@Module
public final class FragmentPresenterModule {

    private final Fragment fragment;

    public FragmentPresenterModule(final Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public FragmentedContract.Presenter provideFragmentedPresenter() {
        return new MainFragmentPresenter();
    }

    @Provides
    @FragmentScope
    public PictureInPictureContract.Presenter providePictureInPicturePresenter(final Router router) {
        return new PictureInPicturePresenter(router);
    }
}
