package com.example.azurlanekantaibrowser;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yihan on 26/9/2017.
 */

public class KantaiAdapter extends BaseAdapter {
    private Context context;
    private List<Kantai> myKantaiList;
    //private int[] positionCheck;

    public KantaiAdapter(Context context, List<Kantai> cardList) {
        this.context = context;
        this.myKantaiList = cardList;
        //positionCheck = new int[cardList.size()];
    }

    @Override
    public int getCount() {
        return myKantaiList.size();
    }

    @Override
    public Object getItem(int position) {
        return myKantaiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myKantaiList.indexOf(getItem(position));
    }

    private class ViewHolder {
        ImageView ivImage;
        TextView tvName;
        TextView tvNo;
        TextView tvType;
        TextView tvCamp;
    }

    /*
    public int getPosition(int position)
    {
        int check = 0;
        boolean checkAvailable = true;

        if(positionCheck != null) {
            for (int i = 0; i < positionCheck.length; i++) {
                if(positionCheck[i] == position)
                {
                    checkAvailable = false;
                }
            }

            while (checkAvailable == false) {
                check
            }
        }
        return position;
    }
    */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder;

        LayoutInflater myInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = myInflater.inflate(R.layout.list_feature, null);
            holder = new ViewHolder();

            holder.ivImage = (ImageView) convertView.findViewById(R.id.item_image);
            holder.tvName = (TextView) convertView.findViewById(R.id.item_name);
            holder.tvNo = (TextView) convertView.findViewById(R.id.item_no);
            holder.tvType = (TextView) convertView.findViewById(R.id.item_type);
            holder.tvCamp = (TextView) convertView.findViewById(R.id.item_camp);

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        Kantai row_pos = myKantaiList.get(position);

        Resources res = context.getResources();
        String mDrawableName = row_pos.getNo();
        int resID = res.getIdentifier(mDrawableName, "drawable", context.getPackageName());
        Drawable drawable = res.getDrawable(resID);

        holder.ivImage.setImageDrawable(drawable);
        holder.tvName.setText(row_pos.getName());
        holder.tvNo.setText(mDrawableName);
        holder.tvType.setText(row_pos.getType());
        holder.tvCamp.setText(row_pos.getCamp());


        return convertView;
    }
}
