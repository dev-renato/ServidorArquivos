
package br.edu.flf.ftp;

public class Resposta implements java.io.Serializable{
    public static final int FILE_EXISTS       = 1;
    public static final int FILE_NOT_FOUMD    = 2;
    public static final int CONTENT_AVAILABLE = 3;
    public static final int EOF               = 4;
    
    private int    responseCode;
    private String responseContent;

    
    public int getResponseCode() {
        return responseCode;
    }

    
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    
    public String getResponseContent() {
        return responseContent;
    }

    
    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }
}
