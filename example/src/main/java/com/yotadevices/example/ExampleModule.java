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

import com.yotadevices.viscera.Presenter;
import com.yotadevices.viscera.di.Module;

/**
 * The {@link ExampleModule} is a core of this module. Wires together the {@link ExampleScreen} and
 * the {@link ExamplePresenter} instances. This module was developed to show how does it work, but
 * normally in such common cases can be used the {@link com.yotadevices.viscera.di.GenericModule} as
 * it does updating, detaching by itself and holds a link to a {@link Presenter}.
 *
 * @author Vitalii Dmitriev
 * @see com.yotadevices.viscera.di.GenericModule
 * @since 17.12.2016
 */
public class ExampleModule implements Module<ExampleScreen> {

    private Presenter<ExampleScreen> mPresenter;

    @Override
    public Module attach(ExampleScreen screen) {
        mPresenter = new ExamplePresenter();
        mPresenter.addView(screen);
        return this;
    }

    @Override
    public Module update(ExampleScreen screen) {
        mPresenter.updateView(screen);
        return this;
    }

    @Override
    public Module detach(ExampleScreen screen) {
        mPresenter = null;
        return this;
    }
}
