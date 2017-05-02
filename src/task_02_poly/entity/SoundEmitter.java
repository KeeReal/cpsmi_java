package task_02_poly.entity;

public abstract class SoundEmitter {
    private String type = "SoundEmitter";
    private String message = "I can emit no sounds!";


    protected String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public void speak() {
        System.out.println(getType() + ": " + getMessage());
    }
}
