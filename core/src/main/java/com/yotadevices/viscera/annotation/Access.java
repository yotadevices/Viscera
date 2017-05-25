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

import com.yotadevices.viscera.Screen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Method, which is annotated with this annotation will be used to generate the {@link Screen}
 * interface for a class, which marked as {@link View}. Such methods will be accessible inside
 * {@link Presenter}.
 *
 * @author Vitalii Dmitriev
 * @since 25.05.2017
 */
@Target({ElementType.METHOD})
public @interface Access {
}
