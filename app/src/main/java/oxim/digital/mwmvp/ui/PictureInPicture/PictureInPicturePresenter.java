package oxim.digital.mwmvp.ui.PictureInPicture;

import android.util.Log;

import javax.inject.Inject;

import oxim.digital.mwmvp.interactor.LeWildUseCase;
import oxim.digital.mwmvp.ui.BasePresenter;

public final class PictureInPicturePresenter extends BasePresenter<PictureInPictureContract.View> implements PictureInPictureContract.Presenter {

    @Inject
    LeWildUseCase leWildUseCase;

    public PictureInPicturePresenter(final PictureInPictureContract.View view) {
        super(view);
    }

    @Override
    public void handleButtonClick() {
        doIfViewNotNull(PictureInPictureContract.View::changeBackgroundColor);
        Log.d("kurschina", String.valueOf(leWildUseCase.execute("String")));
    }
}
