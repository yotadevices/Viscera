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

import java.util.HashMap;

/**
 * The {@code Container} contains a {@code List} of all modules as an objects,
 * implementing the {@code Module} interface.
 *
 * @author Vitalii Dmitriev
 * @see Module
 * @see GenericModule
 */
public class Container {

    /**
     * Contains all modules of this application.
     */
    private HashMap<String, Module> mModules;

    private Container() {
        mModules = new HashMap<>();
    }

    public static Container getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * Puts module implementation to the modules map.
     *
     * @param module some {@code Module}, which is already wired
     *               or supposed to attach all its objects.
     * @return this injector.
     */
    public Container put(Module module) {
        String moduleName = module.getClass().getSimpleName();
        if (mModules.containsKey(moduleName)) {
            mModules.remove(moduleName);
        }
        mModules.put(moduleName, module);
        return this;
    }

    /**
     * Returns a {@code Module}, which name is given as a parameter.
     *
     * @param clazz the class of the needed module.
     * @return required module.
     * @throws IllegalAccessError if there is no such module.
     */
    public Module get(Class clazz) {
        if (!mModules.containsKey(clazz.getSimpleName())) {
            throw new IllegalAccessError("Module " + clazz.getSimpleName()
                    + " wasn't injected or You are trying to get the nonexistent module!");
        }
        return mModules.get(clazz.getSimpleName());
    }

    /**
     * Returns amount of modules in the system.
     *
     * @return modules count.
     */
    public int getCount() {
        return mModules.size();
    }

    private static class InstanceHolder {
        private static final Container INSTANCE = new Container();
    }
}
