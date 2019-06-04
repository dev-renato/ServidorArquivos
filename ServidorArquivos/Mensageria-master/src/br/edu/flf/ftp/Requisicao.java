
package br.edu.flf.ftp;

public class Requisicao implements java.io.Serializable{
    
    public static final int FILENAME_REQUEST = 0;
    public static final int FILECONTENT_RIQUEST = 1;
    
    private int    messageType;
    private String messageContent;

    
    public int getMessageType() {
        return messageType;
    }

    
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    
    public String getMessageContent() {
        return messageContent;
    }

    
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
