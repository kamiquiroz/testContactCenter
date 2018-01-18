package co.kamiquiroz.contaccenter.entities;

import java.io.Serializable;

public class Call implements Serializable{
    private int duration;
    private int number;

    public Call(int duration, int number) {
        this.duration = duration;
        this.number = number;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
