package oxim.digital.mwmvp.ui.view;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import oxim.digital.mwmvp.R;

public final class DraggableView extends FrameLayout {

    private static final String CLIP_DATA_TITLE = "DRAGGABLE_TITLE";

    @Bind(R.id.draggable_view)
    CardView content;

    @Bind(R.id.draggable_text)
    TextView draggableText;

    public DraggableView(final Context context) {
        this(context, null);
    }

    public DraggableView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DraggableView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public String getText() {
        return draggableText.getText().toString();
    }

    private void init(final Context context) {
        final View view = inflate(context, R.layout.view_draggable, this);
        ButterKnife.bind(this, view);

        setupListener();
    }

    private void setupListener() {
        setOnLongClickListener(new DragListener());
    }

    public void setText(final String text) {
        draggableText.setText(text);
    }

    private final class DragListener implements OnLongClickListener {

        @Override
        public boolean onLongClick(final View view) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                startDragAndDropEvent(view);
            } else {
                startDragEvent(view);
            }
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        private void startDragAndDropEvent(final View view) {
            final ClipData data = ClipData.newPlainText(CLIP_DATA_TITLE, draggableText.getText().toString());
            final DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDragAndDrop(data, shadowBuilder, view, DRAG_FLAG_GLOBAL);
            view.setVisibility(View.INVISIBLE);
        }

        private void startDragEvent(final View view) {
            final ClipData data = ClipData.newPlainText(CLIP_DATA_TITLE, draggableText.getText().toString());
            final DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
        }
    }
}
