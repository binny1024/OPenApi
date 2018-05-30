package com.binny.openapi.mvp.ui.fgpicture;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import com.binny.openapi.R;
import com.binny.openapi.mvp.bean.PictureBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.smart.holder.iinterface.IViewHolder;
import com.smart.holder.iinterface.IViewHolderHelper;

import java.util.List;

/**
 * author  binny
 * date 5/30
 */
public class PictureViewHolderHelper implements IViewHolderHelper<PictureViewHolder, PictureBean.DataBean> {


    @Override
    public IViewHolder initItemViewHolder(PictureViewHolder viewHolder, final View convertView) {
        viewHolder = new PictureViewHolder();
        viewHolder.mTextView = convertView.findViewById(R.id.picture_item_title_tv);
        viewHolder.mImageView = convertView.findViewById(R.id.picture_item_img);
        return viewHolder;
    }

    @Override
    public void bindListDataToView(final Context context, final List<PictureBean.DataBean> iBaseBeanList, final PictureViewHolder viewHolder, final int position) {
        Glide.with(context).load(iBaseBeanList.get(position).getUrl())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存所有尺寸的图片
                .thumbnail(0.1f)//先加载原图大小的十分之一
                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

                        viewHolder.mImageView.setImageBitmap(resource);
                    }
                });
        viewHolder.mTextView.setText("第 " + position + " 张" + iBaseBeanList.get(position).getPublishedAt());
    }
}
