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

import android.content.Context;

/**
 * The {@link Screen} represents a view part of an application. Normally, the {@link Screen}
 * interface can be implemented by {@link android.app.Activity}, {@link android.app.Fragment},
 * {@link android.view.View}, or whatever can display views and have {@link Context}.
 * You can define your needed methods in the Screen implementation for your needs, for example
 * {@code setItems(List)} for RecyclerView/ListView adapter, {@code showPrettyAnimation(int)},
 * {@code showDialog(String)} or whatever must be done there.
 * {@link Screen} is controlled by {@link Presenter} instance.
 * {@link Screen} is attached to {@link Presenter} within the {@link com.yotadevices.viscera.di.Module}
 * object.
 *
 * @author Vitalii Dmitriev
 * @since 17.11.2016
 */
public interface Screen {
    /**
     * Since the {@link Screen} is something that holds/is/contains {@link Context}, allow to get
     * it from some {@link Presenter}, which controls the view.
     *
     * @return instance of {@link Context} of a view.
     */
    Context getContext();
}
