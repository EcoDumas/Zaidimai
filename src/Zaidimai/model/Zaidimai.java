package Zaidimai.model;

public class Zaidimai {
    //console,genre,int how much, user id//
    private int id;
    private String genre;
    private String console;
    private int howMuch;
    private int userid;

    public Zaidimai(int id, String genre, String console, int howMuch, int userid) {
        this.id = id;
        this.genre = genre;
        this.console = console;
        this.howMuch = howMuch;
        this.userid = userid;

    }

    public Zaidimai(String genre, String console, int howMuch, int userid) {
        this.genre = genre;
        this.console = console;
        this.howMuch = howMuch;
        this.userid = userid;

    }

    public int getId() {
        return id;
    }

    public String getGenre(){
        return  genre;
    }

    public void setGenre() {
        this.genre = genre;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole() {
        this.console = console;

    }

    public int getHowMuch(){
        return howMuch;

    }

    public void setHowMuch(){
        this.howMuch = howMuch;

    }

    public int getUserid(){
        return userid;

    }

    public void setUserid(){
        this.userid = userid;
    }

    @Override
    public String toString(){
        return "Zaidimai" +
                "genre='" + genre + '\'' +
                "console='" + console + '\'' +
                "howmuch='" + howMuch;
    }




}
