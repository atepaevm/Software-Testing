package third;

public class Main {

    public static Dolphins dolphins;

    public static Flip flip;

    public static DolphinsMessage message;

    public static Humans humans;


    public static void main(String[] args) {
        Main.dolphins = new Dolphins();
        Main.flip = new Flip(FlipStyle.Double, Direction.BACKWARD, Item.HOOP);

        Main.message = new DolphinsMessage(flip, "Прощайте, и спасибо за рыбу");
        Main.humans = new Humans();
        Main.dolphins.addMessage(Main.message);

        DolphinsMessage lastMessage = Main.dolphins.getLastMessage();
        lastMessage.deliverMessage(WhistleSound.StarStripped, AmusmentLevel.VERY_FUNNY);
        humans.recievedMessage = lastMessage.getMessageMeaning(humans.canUnderstandMessage);
    }
}
