package model;

public class Mail {
    private final String mail;
    
    public Mail(String mail){
        this.mail = mail;
    }
    
    public String getDomain(){
        int index = mail.indexOf("@");
        if (index >= 0){
            return mail.substring(index+1);
        }
        return null;
    }
    
    public String getMail(){
        return mail;
    }

    
}
