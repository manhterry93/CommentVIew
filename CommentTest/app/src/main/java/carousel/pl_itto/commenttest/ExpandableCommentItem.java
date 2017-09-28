package carousel.pl_itto.commenttest;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xwray.groupie.ExpandableGroup;
import com.xwray.groupie.ExpandableItem;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

/**
 * Created by PL_itto on 9/29/2017.
 */

public class ExpandableCommentItem extends Item<ViewHolder> implements ExpandableItem {
    private static final String TAG = "PL_itto.ExpandableCommentItem";
    ExpandableGroup mExpandableGroup;
    CommentItem mCommentItem;
    int mdepth = 1;
    LinearLayout mSeparatorContainer;
    TextView mBodyText;

    public ExpandableCommentItem(int mdepth, CommentItem commentItem) {
        this.mdepth = mdepth;
        mCommentItem = commentItem;
    }

    @Override
    public void setExpandableGroup(@NonNull ExpandableGroup onToggleListener) {
        this.mExpandableGroup = onToggleListener;
    }

    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        Log.i(TAG, "bind: " + position);
        addingDelpthViews(viewHolder);
        if (mdepth == 0)
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mExpandableGroup.onToggleExpanded();
                    return true;
                }
            });

        mBodyText.setText(mCommentItem.getBody());

    }

    void addingDelpthViews(ViewHolder viewHolder) {
        mSeparatorContainer = (LinearLayout) viewHolder.itemView.findViewById(R.id.separatorContainer);
        mBodyText = (TextView) viewHolder.itemView.findViewById(R.id.body);
        mSeparatorContainer.removeAllViews();
        Log.i(TAG, "addingDelpthViews: delpth: " + mdepth);

        if (mdepth > 0) {
            mSeparatorContainer.setVisibility(View.VISIBLE);
        } else {
            mSeparatorContainer.setVisibility(View.GONE);
        }
        LayoutInflater inflater = LayoutInflater.from(viewHolder.itemView.getContext());
        for (int i = 0; i < mdepth; i++) {
            View v = inflater.inflate(R.layout.separator_view, mSeparatorContainer,false);
            mSeparatorContainer.addView(v);
        }
        Log.i(TAG, "Separator visiblr: " + mSeparatorContainer.getVisibility() + " " + mSeparatorContainer.getChildCount());
        mBodyText.requestLayout();
    }

    @Override
    public int getLayout() {
        return R.layout.item_expandable_comment;
    }
}
