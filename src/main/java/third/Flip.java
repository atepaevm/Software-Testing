package third;

public class Flip {
    public FlipStyle style;
    public Direction direction;
    public Item obstacle;
    private boolean flipDone;

    Flip(FlipStyle style, Direction direction, Item item){
        this.style = style;
        this.direction = direction;
        this.obstacle = item;
    }

    public boolean getFlipState(){
        return this.flipDone;
    }

    public void resetFlipState(){
        this.flipDone = false;
    }

    public void doFlip(){
        this.flipDone = true;
    }
}
