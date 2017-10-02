package com.example.android.miwok.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.Pojo.Word;
import com.example.android.miwok.R;

import java.util.ArrayList;

/**
 * Created by Ashish on 9/30/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;

    public WordAdapter(Activity context, ArrayList<Word> list, int backgroundColor) {
        super(context, 0, list);
        mBackgroundColor = backgroundColor;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        LinearLayout layout = (LinearLayout) listItemView.findViewById(R.id.item_layout);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        layout.setBackgroundColor(color);


        TextView defaultWord = (TextView) listItemView.findViewById(R.id.english_word);
        defaultWord.setText(currentWord.getDefaultTranslation());

        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_word);
        miwokWord.setText(currentWord.getMiwokTranslation());

        ImageView img = (ImageView) listItemView.findViewById(R.id.image_icon);
        if(currentWord.hasImage()) {
            img.setImageResource(currentWord.getImageResource());
            img.setVisibility(View.VISIBLE);
        } else  {
            img.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
