package oxim.digital.mwmvp.ui.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public final class DropViewContainer extends LinearLayout {

    public DropViewContainer(final Context context) {
        this(context, null);
    }

    public DropViewContainer(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropViewContainer(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnDragListener(new DropItemsHandler(this));
    }

    private static final class DropItemsHandler implements OnDragListener {

        private final ViewGroup viewsContainer;

        public DropItemsHandler(final ViewGroup viewsContainer) {
            this.viewsContainer = viewsContainer;
        }

        @Override
        public boolean onDrag(final View view, final DragEvent event) {
            final int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    // Accept the new view
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        handleDroppedView(event);
                    } else {
                        acceptDroppedView(event);
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    removeLostView(event);
                    break;
            }
            return true;
        }

        private void removeLostView(final DragEvent event) {
            int removeIndex = -1;
            for (int i = 0, size = viewsContainer.getChildCount(); i < size; i++) {
                final View view = viewsContainer.getChildAt(i);
                if (view.getVisibility() == INVISIBLE) {
                    removeIndex = i;
                    break;
                }
            }
            if (removeIndex != -1) {
                viewsContainer.removeViewAt(removeIndex);
            }
        }

        @TargetApi(Build.VERSION_CODES.N)
        private void handleDroppedView(final DragEvent event) {
            final Context context = viewsContainer.getContext();
            if (!(context instanceof Activity)) {
                return;
            }
            final Activity activity = (Activity) context;
            activity.requestDragAndDropPermissions(event);
            final ClipData.Item clip = event.getClipData().getItemAt(0);
            final DraggableView newDraggableView = new DraggableView(context);
            newDraggableView.setText(clip.getText().toString());
            viewsContainer.addView(newDraggableView);
        }

        private void acceptDroppedView(final DragEvent event) {
            final View droppedView = (View) event.getLocalState();
            final ViewGroup owner = (ViewGroup) droppedView.getParent();
            owner.removeView(droppedView);
            viewsContainer.addView(droppedView);
            droppedView.setVisibility(View.VISIBLE);
        }
    }
}
