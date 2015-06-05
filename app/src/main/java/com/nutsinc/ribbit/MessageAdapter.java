package com.nutsinc.ribbit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Ali on 6/5/15.
 */
public class MessageAdapter extends ArrayAdapter<ParseObject>{
    protected Context mContext;
    protected List<ParseObject> mMessages;

    public MessageAdapter (Context mContext,List<ParseObject>mMessages){
        super(mContext,R.layout.message_item,mMessages);
        this.mContext = mContext;
        this.mMessages = mMessages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.message_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.messageIcon);
            holder.nameLabel = (TextView) convertView.findViewById(R.id.senderLabel);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        ParseObject message = mMessages.get(position);
        if (message.getString(ParseConstants.KEY_FILE_TYPE).equals(ParseConstants.TYPE_IMAGE)) {
            holder.iconImageView.setImageResource(R.mipmap.ic_action_picture);

        }
        else {
            holder.iconImageView.setImageResource(R.mipmap.ic_action_play);
        }
        holder.nameLabel.setText(message.getString(ParseConstants.KEY_SENDER_NAME));
        return convertView;
    }

    public static class ViewHolder{
        ImageView iconImageView;
        TextView nameLabel;
    }
}
