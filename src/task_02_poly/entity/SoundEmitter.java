package task_02_poly.entity;

public class SoundEmitter {
    private static final String TYPE = "SoundEmitter";


    protected String getType() {
        return TYPE;
    }


    protected String getMessage() {
        return "I can emit no sounds!";
    }


    public void speak() {
        System.out.println(getType() + ": " + getMessage());
    }
}
