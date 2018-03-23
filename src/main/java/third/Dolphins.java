package third;

import java.util.ArrayList;


public class Dolphins {

    private ArrayList<DolphinsMessage> messagesList;

    Dolphins(){
        this.messagesList = new ArrayList<DolphinsMessage>();
    }


    public void addMessage(DolphinsMessage message){
        this.messagesList.add(message);
    }


    public DolphinsMessage getLastMessage(){
        return messagesList.get(messagesList.size() -1);
    }
}
