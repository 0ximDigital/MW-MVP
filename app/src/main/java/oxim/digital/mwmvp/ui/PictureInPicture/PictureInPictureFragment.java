package oxim.digital.mwmvp.ui.PictureInPicture;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.FragmentComponent;
import oxim.digital.mwmvp.application.activity.MwFragment;
import oxim.digital.mwmvp.ui.ScopedPresenter;

public final class PictureInPictureFragment extends MwFragment implements PictureInPictureContract.View {

    @Inject
    PictureInPictureContract.Presenter presenter;

    @Bind(R.id.content_root)
    View view;

    @ColorRes
    private final int[] colors = {R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark};

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
    public void changeBackgroundColor() {
        final Random random = new Random();
        view.setBackgroundResource(colors[random.nextInt(colors.length)]);
    }

    @Override
    public void showMessage(final String message) {
        // No-op
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @OnClick(R.id.click_me_button)
    public void onClickMeButtonClick() {
        presenter.handleButtonClick();
    }

    @NonNull
    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }
}
