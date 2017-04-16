package task_02_poly.entity;

public class Dog extends Mammal{
    @Override
    protected String getType() {
        return "Dog";
    }


    @Override
    protected String getMessage() {
        return "wofff, wofff";
    }
}
