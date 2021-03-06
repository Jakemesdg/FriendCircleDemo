package com.share.jack.friendcircledemo.main.viewholder;

import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.share.jack.cygtool.recyclerview.holder.CygBaseViewHolder;
import com.share.jack.cygtool.util.CygTimeUtil;
import com.share.jack.friendcircledemo.R;
import com.share.jack.friendcircledemo.main.bean.CommentData;

/**
 *
 */
public class CommentHolder extends CygBaseViewHolder<CommentData> {

    public ImageView avatar;
    public TextView nickName;
    public TextView content;
    public TextView time;
    public RelativeLayout rcMain;

    public CommentHolder(ViewGroup parent, @LayoutRes int layoutId) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
        avatar = getView(R.id.ic_iv_avatar);
        nickName = getView(R.id.ic_tv_nick_name);
        content = getView(R.id.ic_tv_content);
        time = getView(R.id.ic_tv_time);
        rcMain = getView(R.id.ic_rv_main);
    }

    @Override
    public void setData(CommentData commentData) {
        if (!commentData.isRootComment()) {
            avatar.setImageResource(R.mipmap.icon_avatar_man);
            nickName.setText(getSpannString(commentData.getFromName() + "回复" + commentData.getToName()));
        } else {
            avatar.setImageResource(R.mipmap.icon_avatar_woman);
            nickName.setText(commentData.getFromName());
        }
        content.setText(commentData.getContent());
        time.setText(CygTimeUtil.getTimeByLong(commentData.getTime()));
    }

    private SpannableString getSpannString(String str) {
        SpannableString ss = new SpannableString(str);
        int start = str.indexOf("回");
        ss.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.color_black_light)), start, start + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }
}
