package third;

public class DolphinsMessage {

    private String meaning;
    public AmusmentLevel actionAmusement;
    public Flip flip;
    public WhistleSound sound;

    DolphinsMessage(Flip flip, String meaning){
        this.flip = flip;
        this.meaning = meaning;
    }

    public String getMessageMeaning(boolean canUnderstandMessage){
        return canUnderstandMessage ? this.meaning : null;
    }

    public void deliverMessage(WhistleSound sound, AmusmentLevel level){
        this.flip.doFlip();
        this.sound = sound;
        this.actionAmusement = level;
    }
}
