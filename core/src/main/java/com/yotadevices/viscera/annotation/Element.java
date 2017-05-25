/*
 * Copyright (C) 2017 Yota Devices LLC
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
package com.yotadevices.viscera.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Class, annotated with this annotation will be injected into the module and accessed in
 * a {@link Presenter} of the module.
 * Normally, it can be some data class (e.g. DAO, Repository, DatabaseHelper etc), or some util
 * class, which requires instantiating and other objects, which must be accessed by Presenter.
 *
 * @author Vitalii Dmitriev
 * @since 25.05.2017
 */
@Target({ElementType.TYPE})
public @interface Element {
    /**
     * The name of the {@link com.yotadevices.viscera.di.Module}.
     */
    String value();
}
