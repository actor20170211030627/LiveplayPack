/*
 * Copyright (C) 2016 hejunlin <hejunlin2013@gmail.com>
 *
 * Github:https://github.com/hejunlin2013/LivePlayback
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
package com.hejunlin.liveplayback.ui;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hejunlin.liveplayback.OptionItemAdapter;
import com.hejunlin.liveplayback.R;

import java.util.Locale;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView version = findViewById(R.id.version);
//        version.setText(getVersionName());
        RecyclerView recyclerView  = findViewById(R.id.ry_menu_item);
        OptionItemAdapter adapter = new OptionItemAdapter(this, R.layout.detail_menu_item);
        recyclerView.setAdapter(adapter);
    }

    private String getVersionName() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String versionName = packageInfo.versionName;
            int    versionCode = packageInfo.versionCode;
            return String.format(Locale.getDefault(), "版本 : %s.%d", versionName, versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
