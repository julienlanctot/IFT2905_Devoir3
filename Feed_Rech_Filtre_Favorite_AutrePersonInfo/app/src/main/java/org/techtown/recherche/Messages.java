package org.techtown.recherche;

public class Messages {

    public String user;
    public String lastText;
    public String date;

    /**
     * Message class for messages between users
     * @param user User name
     * @param lastText Last message
     * @param date Date it was sent
     */
    public Messages(String user, String lastText, String date)
    {
        this.user = user;
        this.lastText = lastText;
        this.date = date;
    }

}
