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

import com.yotadevices.viscera.Presenter;
import com.yotadevices.viscera.Screen;

/**
 * The {@code GenericModule} is some module, which has only one view and only one presenter,
 * implements detaching and updating logic. If some extra logic for {@link #update(Screen)} or
 * for {@link #detach(Screen)} is needed, just override them.
 *
 * @author Vitalii Dmitriev
 * @see Module
 * @since 17.11.2016
 */
public abstract class GenericModule<T extends Screen> implements Module<T> {
    /**
     * An appropriate presenter. Protected as must be accessible inside children.
     */
    protected Presenter<T> mPresenter;

    @Override
    public Module update(T screen) {
        if (null == mPresenter) {
            throw new IllegalStateException("Presenter must be instantiated first!");
        }
        mPresenter.updateView(screen);
        return this;
    }

    @Override
    public Module detach(T screen) {
        mPresenter = null;
        return this;
    }
}
