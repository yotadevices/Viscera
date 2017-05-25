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

/**
 * The {@link Presenter} is an object, which takes the main control of views. Can either work with
 * only one * {@link Screen} instance or with several instances, depending on an implementation.
 *
 * @author Vitalii Dmitriev
 * @see Screen
 * @see com.yotadevices.viscera.di.Module
 */
public abstract class Presenter<T extends Screen> {

    /**
     * Saves a {@link Screen} locally to perform some operations later (e.g. it can be used in some
     * callback methods, which are out of this method's scope). Also, a Screen can be configured
     * here by calling its appropriate methods (which are intended to be called once or seldom).
     *
     * @param screen a screen instance.
     */
    public abstract void addView(T screen);

    /**
     * Here can be performed some operations like getting data from database (using model classes,
     * e.g. repository), or initiated downloading from a server, and after that either
     * a {@link Screen} can be updated here for synchronous work or can be set some callback for
     * other model objects to update a given Screen instance asynchronously.
     *
     * @param screen a screen instance.
     */
    public abstract void updateView(T screen);
}
