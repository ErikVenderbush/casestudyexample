package perscholas.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Manager {

    // First Spring creates its context where it will put all objects that it is going to create
    // the context is like a bucket where it puts objects that it creates and we can ask for them
    // later with @Autowired. Spring makes 3 passes when it starts up.

    // First pass is what's called a component scan. This finds all Spring classes with an annotaion
    // such as @Controller, @Component, @Repository, etc. and creates and instance of this class.
    // Essentially it creates/instantiates a new object of the annotated class.

    // Second pass is when it does all @Autowired. This is done in a second pass because all
    // objects need to be created before they can be autowired.

    // WARNING: In Spirng you can not use constructors to initialize the class if it is using an
    // autowired variable. This is because on pass 1 when it is creating the instances of all
    // classes, it has not yet autowired the variables.

    // The third pass that Spirng will make runs all @PostConstruct methods.

    @Autowired
    private Worker1 worker1;

    @Autowired
    private Worker2 worker2;

    @Autowired
    private Worker3 worker3;

    public Manager() {
        System.out.println("I am in the manager constructor");
        // This executes before autowiring
        // These will fail due to Spring not yet autowiring the variables (null)
        // It is not good practice to use a constructor with @Component for this reason
        // worker1.doWork();
        // worker2.doWork();
        // worker3.doWork();
    }

    @PostConstruct
    public void init() {
        worker1.doWork();
        worker2.doWork();
        worker3.doWork();
    }
}
