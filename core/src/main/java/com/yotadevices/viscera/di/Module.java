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
package com.yotadevices.viscera.di;

import android.app.Activity;
import android.app.Fragment;

import com.yotadevices.viscera.Screen;

/**
 * The {@code Module} interface is a simple implementation of dependency injection.
 * Each implementation of this interface is a module separation, can contain all needed objects in
 * it and provide all dependencies needed by all objects. After that, each implementation of the
 * {@code Module} interface must be added to {@code Container} by {@link Container#put(Module)}.
 * It is intended to perform an injection in a class, extending the {@code android.app.Application}.
 *
 * @author Vitalii Dmitriev
 * @see GenericModule
 * @see Container
 */
public interface Module<T extends Screen> {

    /**
     * Wires all classes in a project and attaches the given activity. Here You can initialize all
     * objects you need and put all dependencies. This method should be called either in
     * {@link android.app.Activity#onCreate}, {@link android.app.Fragment#onCreate} or somewhere
     * else, where you are creating your {@link Screen} after all initializations of widgets.
     *
     * @param screen to be attached.
     * @return the module object itself.
     */
    Module attach(T screen);

    /**
     * Update data or a state of a view. Normally calls the
     * {@link com.yotadevices.viscera.Presenter#updateView(Screen)} method, and if needed,
     * also some update operations in an app structure could be performed here (e.g. adding
     * something to presenter). If no "expensive" operations performed in Presenter's updateView
     * method and if it does only data updating, can be called from the {@link Activity#onResume()}
     * (or from some similar method of some other view). Also can be called every time an update is
     * required: some callback was called, some view added, some method, which is under control of
     * the {@link com.yotadevices.viscera.Presenter} and so on.
     *
     * @param screen to be updated.
     * @return the module object itself.
     */
    Module update(T screen);

    /**
     * Detach all wired classes, related to an exact {@link Screen}. If in the {@link #attach(Screen)}
     * method was "injected" something to a {@link com.yotadevices.viscera.Presenter} or to model
     * objects, or even to the {@link Screen} itself, it could be destroyed here.
     * Normally called from the {@link android.app.Activity#onDestroy()}, or {@link Fragment#onDestroy()},
     * or whatever view objects are used, call this when they are destroying.
     *
     * @param screen to be detached.
     * @return the module object itself.
     */
    Module detach(T screen);
}
