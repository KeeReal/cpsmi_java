package task_02_poly.entity;

public class Fox extends Mammal{
    @Override
    protected String getType() {
        return "Fox";
    }


    @Override
    protected String getMessage() {
        return "\"Ring-ding-ding-ding-dingeringeding!\n" +
                "\tGering-ding-ding-ding-dingeringeding!\n" +
                "\tGering-ding-ding-ding-dingeringeding!\"\n" +
                "\tWhat does the fox say?";
    }
}
