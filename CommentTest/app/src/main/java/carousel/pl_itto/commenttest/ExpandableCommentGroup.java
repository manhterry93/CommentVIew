package carousel.pl_itto.commenttest;

import com.xwray.groupie.ExpandableGroup;

/**
 * Created by PL_itto on 9/29/2017.
 */

public class ExpandableCommentGroup extends ExpandableGroup {
    CommentItem mCommentItem;
    int mDelpth = 0;

    public ExpandableCommentGroup(ExpandableCommentItem expandableItem) {
        super(expandableItem);
        mCommentItem = expandableItem.mCommentItem;
        mDelpth = expandableItem.mdepth;
        for (CommentItem item : mCommentItem.getSubCommentList()) {
            add(new ExpandableCommentItem(1, item));
        }
    }
}
