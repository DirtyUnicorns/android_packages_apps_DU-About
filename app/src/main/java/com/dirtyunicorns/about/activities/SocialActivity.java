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

package com.dirtyunicorns.about.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.dirtyunicorns.about.R;
import com.dirtyunicorns.about.helpers.Util;

public class SocialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_layout);

        Util social = (Util) getIntent().getSerializableExtra("social");
        final com.dirtyunicorns.about.helpers.Util uri = social.getUri();

        ImageView googleplus = (ImageView) findViewById(R.id.google_plus);
        ImageView twitter = (ImageView) findViewById(R.id.twitter);
        ImageView github = (ImageView) findViewById(R.id.github);

        googleplus.setVisibility(uri.getGooglePlus().equals("") ? View.GONE : View.VISIBLE);
        github.setVisibility(uri.getGithub().equals("") ? View.GONE : View.VISIBLE);
        twitter.setVisibility(uri.getTwitter().equals("") ? View.GONE : View.VISIBLE);

        if (uri.getGooglePlus().equals("") && uri.getTwitter().equals("") && uri.getGithub().equals("")) {
            setContentView(R.layout.no_contact);
        }

        googleplus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent googleplusIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri.getGooglePlus()));
                    startActivity(googleplusIntent);
                } catch (ActivityNotFoundException e) {
                    SnackBar();
                }
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent githubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri.getGithub()));
                    startActivity(githubIntent);
                } catch (ActivityNotFoundException e) {
                    SnackBar();
                }
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri.getTwitter()));
                    startActivity(twitterIntent);
                } catch (ActivityNotFoundException e) {
                    SnackBar();
                }
            }
        });
    }

    public void SnackBar() {
        Snackbar.make(this.findViewById(R.id.google_plus), getString(R.string.no_browser_installed), Snackbar.LENGTH_LONG).show();
    }
}