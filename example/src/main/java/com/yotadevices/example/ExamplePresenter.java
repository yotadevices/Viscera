package com.yotadevices.example;

/*
 * Copyright (C) 2016 Yota Devices LLC
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

import android.view.View;

import com.yotadevices.viscera.Presenter;

import java.lang.ref.WeakReference;

/**
 * @author Vitalii Dmitriev
 * @since 17.12.2016
 */
public class ExamplePresenter extends Presenter<ExampleScreen> {

    /**
     * State of colors. Whether a background,
     * text and button colors were set or not.
     */
    private boolean mIsColorSet;
    /**
     * An instance of a {@link ExampleScreen} to interact later.
     */
    private WeakReference<ExampleScreen> mViewReference;

    @Override
    public void addView(ExampleScreen screen) {
        mViewReference = new WeakReference<>(screen);
    }

    @Override
    public void updateView(final ExampleScreen screen) {
        screen.setupText(R.string.message_click, android.R.color.black);
        screen.setupButton(R.string.button_click, android.R.color.black);
        screen.setButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBackground();
            }
        });
    }

    private void changeBackground() {
        ExampleScreen screen = mViewReference.get();
        if (null != screen) {
            int mainColor = mIsColorSet ? android.R.color.black : android.R.color.white;
            int background = mIsColorSet ? android.R.color.white : android.R.color.holo_red_dark;
            int buttonText = mIsColorSet ? R.string.button_click : R.string.button_click_again;
            if (screen.isToastEnabled()) {
                screen.showToast(screen.getContext().getText(R.string.toast), false);
            }
            screen.setBackground(background);
            screen.setupText(R.string.message_click, mainColor);
            screen.setupButton(buttonText, mainColor);
            mIsColorSet = !mIsColorSet;
        }
    }
}
