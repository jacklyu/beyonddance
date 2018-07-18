package com.example.android.BeyondDancing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<BasicVideo>{
    public ArrayList<MessageAdapterListener> listeners;
    public MessageAdapter(Context context, int resources, List<BasicVideo> messages) {
        super(context, resources, messages);
        listeners = new ArrayList<>();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.video_item, parent, false);
        }
        ImageView thumbnailView = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
        TextView titleView = (TextView) convertView.findViewById(R.id.list_item_title);
        TextView uploaderTextView = (TextView) convertView.findViewById((R.id.list_item_uploader));
        TextView timeTextView = (TextView) convertView.findViewById((R.id.list_item_video_time));
        TextView likesTextView = (TextView) convertView.findViewById((R.id.list_item_likes));
        TextView dislikesTextView = (TextView) convertView.findViewById((R.id.list_item_dislikes));

        BasicVideo video = getItem(position);
        titleView.setText(video.getTitle());
        uploaderTextView.setText(video.getUploader());
        timeTextView.setText(video.getVideoTime());
        likesTextView.setText(Integer.toString(video.getLikes()));
        dislikesTextView.setText(Integer.toString(video.getDislikes()));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PlaybackActivity.class);
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }

    public interface MessageAdapterListener{

    }
}
