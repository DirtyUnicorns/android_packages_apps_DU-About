/*
 * Copyright (C) 2017 The Dirty Unicorns Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dirtyunicorns.about.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dirtyunicorns.about.R;

public class GeneralInfo extends PreferenceFragmentCompat {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ImageView googleplus = (ImageView) rootView.findViewById(R.id.google_plus);
        googleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent googleplus = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.google_plus_link)));
                    startActivity(googleplus);
                } catch (ActivityNotFoundException e) {
                    SnackBar();
                }
            }
        });
        ImageView github = (ImageView) rootView.findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.github_link)));
                    startActivity(github);
                } catch (ActivityNotFoundException e) {
                    SnackBar();
                }
            }
        });
        ImageView twitter = (ImageView) rootView.findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent twitter = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.twitter_link)));
                    startActivity(twitter);
                } catch (ActivityNotFoundException e) {
                    SnackBar();
                }
            }
        });

        return rootView;
    }

    public void SnackBar() {
        Snackbar.make(getActivity().findViewById(R.id.fragment), getString(R.string.no_browser_installed), Snackbar.LENGTH_LONG).show();
    }
}