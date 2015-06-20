package com.fwj.recyclerviewdemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fwj.recyclerviewdemo.R;

import java.util.List;

/**
 * ================================
 * 文件名：com.fwj.recyclerviewdemo.Adapter
 * <p/>
 * 描    述：
 * <p/>
 * 作    者：傅文江
 * <p/>
 * 时    间：2015/6/20 15:34
 * <p/>
 * 版    权：©个人开发者 傅文江 版权所有
 * ================================
 */
public class SimpleAdapter extends RecyclerView.Adapter<MViewHolder> {
    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater mInflater;

    public SimpleAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view =mInflater.inflate(R.layout.item_recyclev_view,viewGroup,false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, int postion) {
        holder.textView.setText(mDatas.get(postion));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MViewHolder extends RecyclerView.ViewHolder {
     TextView textView;
    public MViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.item_textview);

    }
}
