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
package com.yotadevices.viscera;

import android.view.ViewGroup;

/**
 * The state of the {@code Screen}. Fills a root view of a screen with other views, can also set
 * custom data (text, images etc), sizes, colors and so on.
 *
 * @author Vitalii Dmitriev
 * @since 24.11.2016
 */
public abstract class State<T extends Presenter> {
    /**
     * Apply state: fill a {@link ViewGroup} with other views, change their state, set some content,
     * which could be got from an appropriate {@link Presenter}.
     *
     * @param root      ViewGroup, containing views to be filled or a stub root to fill with
     *                  dynamically inflated views.
     * @param presenter attached presenter, used to get data or interact using presenter's methods.
     */
    public abstract void apply(ViewGroup root, T presenter);
}
