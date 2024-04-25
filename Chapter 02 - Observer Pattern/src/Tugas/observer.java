package Tugas;

import javax.security.auth.Subject;
import java.util.Vector;
public interface observer {
    public void receiveNotification(String msg);

    void update();

    void setSubject(Subject sub);

    void setSubject(Tugas.Subject sub);
}

interface Observable {
    public void addSubscriber(User user);
    public void removeSubscriber(User user);
    public void notifyUser(String msg);
}
abstract class User implements observer {
    private final String name;
    public User(String name) {
        this.name = name;
}
    @Override
    public void receiveNotification(String msg) {
        System.out.println(msg);
    }

    public void subscribe(Channel channel) {
        channel.addSubscriber(this);
    }

    public void unsubscribe(Channel channel) {
        channel.removeSubscriber(this);
    }

    public String getName() {
        return name;
    }
}
class Channel implements Observable {
    private String name;
    private Vector<User> subscriber;

    public Channel(String name) {
        this.name = name;
        this.subscriber = new Vector<User>();
    }

    @Override
    public void addSubscriber(User user) {
        subscriber.add(user);
    }
    @Override
    public void removeSubscriber(User user) {
        subscriber.remove(user);
    }
    @Override
    public  void notifyUser(String msg) {
        System.out.println(name + "posted a new video!");
        String constructedMessage = String.format("%s: %s", name, msg);
        for (User user : subscriber) {
            user.receiveNotification(constructedMessage);
        }
    }
}