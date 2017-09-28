package carousel.pl_itto.commenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GroupAdapter<ViewHolder> mGroupAdapter;
    GridLayoutManager mLayoutManager;
    RecyclerView mCommentList;
    List<CommentItem> mCommentItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCommentList = (RecyclerView) findViewById(R.id.rv_comments);
        mGroupAdapter = new GroupAdapter<>();
        mLayoutManager = new GridLayoutManager(this, mGroupAdapter.getSpanCount());
        mLayoutManager.setSpanSizeLookup(mGroupAdapter.getSpanSizeLookup());
        mCommentList.setLayoutManager(mLayoutManager);
        mCommentList.setAdapter(mGroupAdapter);
        initData();
    }

    void initData() {
        mCommentItems = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            CommentItem item = new CommentItem();
            item.setAuthor("PL_itto");
            item.setBody("Some thing here");
            List<CommentItem> list = new ArrayList<>();
            item.setDelpth(2);
            for (int j = 0; j < 2; j++) {
                CommentItem subItem = new CommentItem();
                subItem.setAuthor("Author" + (j + 1));
                subItem.setBody("SubITem");
                subItem.setDelpth(1);
                list.add(subItem);
            }
            item.setSubCommentList(list);
            mGroupAdapter.add(new ExpandableCommentGroup(new ExpandableCommentItem(0, item)));
            mGroupAdapter.notifyDataSetChanged();
        }
    }

}
