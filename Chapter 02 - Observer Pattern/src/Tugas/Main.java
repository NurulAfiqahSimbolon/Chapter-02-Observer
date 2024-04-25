//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
                Channel ch = new Channel("Nurul Afsim Channel");
                User user1 = new User("Yuhu yuhu") {
                    @Override
                    public void update() {

                    }

                    @Override
                    public void setSubject(Subject sub) {

                    }
                };
                User user2 = new User("Mukbang TV") {
                    @Override
                    public void update() {

                    }

                    @Override
                    public void setSubject(Subject sub) {

                    }
                };
                User user3 = new User("Mari Makan Cemilan") {
                    @Override
                    public void update() {

                    }

                    @Override
                    public void setSubject(Subject sub) {

                    }
                };

                ch.addSubscriber(user1);
                ch.addSubscriber(user2);
                ch.notifyUser("Ada video baru buat anda! Jangan lupa di subscribe ya!");

                user3.subscribe(ch);
                ch.notifyUser("Video baru!");
                System.out.println("\n");


                MyTopic topic = new MyTopic();
                observer obj1 = new MyTopicSubscriber("Obj1") {
                    @Override
                    public void receiveNotification(String msg) {

                    }
                };
                observer obj2 = new MyTopicSubscriber("Obj2") {
                    @Override
                    public void receiveNotification(String msg) {

                    }
                };
                observer obj3 = new MyTopicSubscriber("Obj3") {
                    @Override
                    public void receiveNotification(String msg) {

                    }
                };

                //register observers to the subject
                topic.register(obj1);
                topic.register(obj2);
                topic.register(obj3);

                //attach observer to subject
                obj1.setSubject(topic);
                obj2.setSubject(topic);
                obj3.setSubject(topic);

                //check if any update is available
                obj1.update();

                //now send message to subject
                topic.postMessage("Ada tren makanan baru nih!!!");
        }

    }


