package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dk-dev on 9/17/17.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private int mBackgroundResourceId;

    private MediaPlayer mMediaPlayer = null;

    public WordAdapter(Context context, ArrayList<Word> items, int backgroundResourceId){
        super(context, 0, items);
        mBackgroundResourceId = backgroundResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.word_list_item, parent, false);
        }

        ConstraintLayout layout = (ConstraintLayout) listItemView.findViewById(R.id.linear_layout);
        layout.setBackgroundResource(mBackgroundResourceId);

        final Word currentWord = getItem(position);
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);


        if(currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }else {
            image.setVisibility(View.GONE);
        }


        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_text);
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.translation_text);
        defaultTranslation.setText(currentWord.getDefaultTranslation());
        return listItemView;
    }


}
