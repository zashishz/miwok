package com.example.android.miwok.Fragments;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.miwok.Adapters.WordAdapter;
import com.example.android.miwok.Helpers.Helper;
import com.example.android.miwok.Pojo.Word;
import com.example.android.miwok.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        Helper.mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("father","әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother","әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son","angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter","tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother","taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother","chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister","teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother","ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather","paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Helper.releaseMediaPlayer();
                int result = Helper.mAudioManager.requestAudioFocus(Helper.mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Helper.mMediaPlayer = MediaPlayer.create(getActivity(), words.get(i).getAudioResource());
                    Helper.mMediaPlayer.start();
                    Helper.mMediaPlayer.setOnCompletionListener(Helper.mOnCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        Helper.releaseMediaPlayer();
    }

}
