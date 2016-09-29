package oxim.digital.mwmvp.ui.PictureInPicture;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.FragmentComponent;
import oxim.digital.mwmvp.application.activity.MwFragment;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public final class PictureInPictureFragment extends MwFragment implements PictureInPictureContract.View {

    @Inject
    PictureInPictureContract.Presenter presenter;

    public static PictureInPictureFragment newInstance() {
        PictureInPictureFragment fragment = new PictureInPictureFragment();
        return fragment;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_picture_in_picture, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showMessage(final String message) {
        // No-op
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @OnClick(R.id.card_picture_in_picture)
    public void onPictureInPictureButtonClick() {
        presenter.handlePictureInPictureButtonClick();
    }

    @NonNull
    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }
}
