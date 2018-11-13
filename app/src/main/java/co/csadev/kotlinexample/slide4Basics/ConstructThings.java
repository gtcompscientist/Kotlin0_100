package co.csadev.kotlinexample.slide4Basics;

import co.csadev.kotlinexample.slide2Migration.ExampleClass;

public class ConstructThings {

    public ExampleClass getConstructedClass() {
        ExampleClass ec = new ExampleClass(true);
        ec.addClass("Test123");
        ec.addListener(new ExampleClass.Updater() {
            @Override
            public boolean newClass(String clazz) {
                System.out.println("Class Added: " + clazz);
                return true;
            }

            @Override
            public boolean classRemoved(String clazz) {
                System.out.println("Class removed: " + clazz);
                return true;
            }
        });
        return ec;
    }

}
