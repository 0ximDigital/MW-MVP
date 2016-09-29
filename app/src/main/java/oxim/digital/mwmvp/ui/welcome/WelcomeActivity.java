package oxim.digital.mwmvp.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.ActivityComponent;
import oxim.digital.mwmvp.application.activity.DaggerActivity;

public final class WelcomeActivity extends DaggerActivity implements WelcomeContract.View {

    @Inject
    WelcomeContract.Presenter presenter;

    public static Intent createIntent(final Context context) {
        final Intent intent = new Intent(context, WelcomeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        presenter.setView(this);
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showMessage(final String message) {

    }

    @OnClick({R.id.card_one, R.id.card_two, R.id.card_three, R.id.card_four})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_one:
                presenter.showSingleActivity();
                break;
            case R.id.card_two:
                presenter.showPictureInPicture();
                break;
            case R.id.card_three:
                presenter.showActivityInNewWindow();
                break;
            case R.id.card_four:
                presenter.showDragAndDrop();
                break;
        }
    }
}
