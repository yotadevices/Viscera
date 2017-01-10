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

import com.yotadevices.viscera.Screen;

/**
 * The {@link ExampleScreen} is an interface for the {@link ExamplePresenter} to interact with the
 * {@link MainActivity}. It contains some methods to change an activity's views content and states.
 *
 * @author Vitalii Dmitriev
 * @since 17.12.2016
 */
public interface ExampleScreen extends Screen {

    /**
     * Check whether a {@link android.widget.Toast} must be shown or not.
     *
     * @return true if it is enabled, false otherwise.
     */
    boolean isToastEnabled();

    /**
     * Setup a {@link android.widget.TextView} with some text and some color.
     *
     * @param textResource  String resource to set to the TextView.
     * @param colorResource color resource to set to the TextView.
     */
    void setupText(int textResource, int colorResource);

    /**
     * Sets a background color of an {@link android.app.Activity}.
     *
     * @param colorResource color resource to set to the Activity's root view.
     */
    void setBackground(int colorResource);

    /**
     * Show {@link android.widget.Toast} message to the user.
     *
     * @param text         to be shown.
     * @param durationLong whether a toast must be created and shown with
     *                     {@link android.widget.Toast#LENGTH_LONG} or
     *                     {@link android.widget.Toast#LENGTH_SHORT} value.
     */
    void showToast(CharSequence text, boolean durationLong);

    /**
     * Sets an {@link android.view.View.OnClickListener} to the {@link android.widget.Button}.
     *
     * @param listener to be set.
     */
    void setButtonClickListener(View.OnClickListener listener);

    /**
     * Setup a {@link android.widget.Button} with some text and some color.
     *
     * @param textResource  String resource to set to the Button.
     * @param colorResource color resource to set to the Button.
     */
    void setupButton(int textResource, int colorResource);
}
