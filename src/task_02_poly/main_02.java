package task_02_poly;

import task_02_poly.entity.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class main_02 {
    public static void main(String[] args) {
        LinkedList<SoundEmitter> entities = new LinkedList<SoundEmitter>();
        entities.add(new Cat());
        entities.add(new Dog());
        entities.add(new Dog());
        entities.add(new Fox());
        entities.add(new Mammal());
        entities.add(new SoundEmitter());

        Iterator<SoundEmitter> it = entities.iterator();
        while (it.hasNext()) {
            it.next().speak();
        }
    }
}
