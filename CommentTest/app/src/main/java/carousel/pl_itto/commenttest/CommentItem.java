package carousel.pl_itto.commenttest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by PL_itto on 9/29/2017.
 */

public class CommentItem {
    private String mAuthor;
    private String mBody;
    private long mId;
    private List<CommentItem> mSubCommentList;
    private int delpth;
    public CommentItem() {
        mId =UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        mSubCommentList = new ArrayList<>();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public List<CommentItem> getSubCommentList() {
        return mSubCommentList;
    }

    public void setSubCommentList(List<CommentItem> subCommentList) {
        mSubCommentList = subCommentList;
    }

    public int getDelpth() {
        return delpth;
    }

    public void setDelpth(int delpth) {
        this.delpth = delpth;
    }
}
