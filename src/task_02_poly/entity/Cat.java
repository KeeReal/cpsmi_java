package task_02_poly.entity;

public class Cat extends Mammal {
    @Override
    protected String getType() {
        return "Cat";
    }


    @Override
    protected String getMessage() {
        return "meow, meow";
    }
}
