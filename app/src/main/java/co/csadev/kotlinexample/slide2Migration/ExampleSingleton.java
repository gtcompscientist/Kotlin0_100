package co.csadev.kotlinexample.slide2Migration;

@SuppressWarnings("ALL")
public class ExampleSingleton {
    boolean isReady = false;

    private static final ExampleSingleton ourInstance = new ExampleSingleton();

    public static ExampleSingleton getInstance() {
        return ourInstance;
    }

    private ExampleSingleton() { }
}
