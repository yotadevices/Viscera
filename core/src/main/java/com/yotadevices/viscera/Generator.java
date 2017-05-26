package com.yotadevices.viscera;

import java.util.List;

/**
 * @author Vitalii Dmitriev
 * @since 26.05.2017
 */
public abstract class Generator {

    private Generator() { /* NOP */ }

    public static void main(String[] args) {
        // TODO: 26.05.17 recursively find classes in path
        // TODO: 26.05.17 find all annotations
        // TODO: 26.05.17 generate main structure
        // TODO: 26.05.17 extend/implement objects in existing classes
    }

    /**
     * if directory
     *      find({path cd directory})
     * else
     *      iter (f.annotated():files)
     *          elems <- ModuleElement(f)
     * return elems
     */
    private static List<ModuleElement> find(String path) {
        throw new UnsupportedOperationException("Stub!");
    }

    private class ModuleElement {

        Type type;
        String aPackage;
        String moduleName;
        String classContent;

        public ModuleElement(Type type, String aPackage, String moduleName, String classContent) {
            this.type         = type;
            this.aPackage     = aPackage;
            this.moduleName   = moduleName;
            this.classContent = classContent;
        }
    }

    private enum Type {
        ELEMENT, PRESENTER, VIEW
    }
}
