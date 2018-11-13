package co.csadev.kotlinexample.slide2Migration;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class ExampleClass {
    boolean isAvailable;
    int maxClasses;
    ArrayList<String> classList = new ArrayList<String>();
    ArrayList<Updater> listeners = new ArrayList<Updater>();

    public ExampleClass(boolean whatsAvailable) {
        isAvailable = whatsAvailable;
    }

    public ExampleClass(boolean whatsAvailable, int maxCount) {
        isAvailable = whatsAvailable;
        maxClasses = maxCount;
    }

    public ExampleClass(boolean whatsAvailable, int maxCount, ArrayList<String> classes) {
        isAvailable = whatsAvailable;
        maxClasses = maxCount;
        classList = classes;
    }

    public void addListener(Updater updater) {
        listeners.add(updater);
    }

    public boolean addClass(String clazz) {
        if (maxClasses == classList.size())
            return false;

        classList.add(clazz);
        for (Updater l : listeners) {
            l.newClass(clazz);
        }
        return true;
    }

    public boolean removeClass(String clazz) {
        if (!classList.contains(clazz))
            return false;

        classList.remove(clazz);
        for (Updater l : listeners) {
            l.classRemoved(clazz);
        }
        return true;
    }

    public interface Updater {
        public boolean newClass(String clazz);
        public boolean classRemoved(String clazz);
    }
}
