package oxim.digital.mwmvp.ui.drag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.annimon.stream.Stream;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import oxim.digital.mwmvp.R;
import oxim.digital.mwmvp.application.activity.FragmentComponent;
import oxim.digital.mwmvp.application.activity.MwFragment;
import oxim.digital.mwmvp.ui.ScopedPresenter;
import oxim.digital.mwmvp.ui.view.DraggableView;

public final class DragAndDropFragment extends MwFragment implements DragAndDropContract.View {

    @Inject
    DragAndDropContract.Presenter presenter;

    @Bind(R.id.drop_view_container)
    ViewGroup dropViewConatiner;

    public static DragAndDropFragment newInstance() {
        DragAndDropFragment fragment = new DragAndDropFragment();
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
        final View view = inflater.inflate(R.layout.fragment_drag_and_drop, container, false);
        ButterKnife.bind(this, view);
        addDraggableViews();
        return view;
    }

    private void addDraggableViews() {
        Stream.rangeClosed(1, 3)
              .map(value -> {
                  final DraggableView draggableView = new DraggableView(getContext());
                  draggableView.setText(String.valueOf("Draggable view " + value));
                  return draggableView;
              })
              .forEach(dropViewConatiner::addView);
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void showMessage(final String message) {
        // No-op
    }

    @NonNull
    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }
}
