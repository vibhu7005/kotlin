package kt.academy.learnprogramming.challenge3;

public class Bicycle {

    private int cadence;
    private int gear;
    private int speed;

    public Bicycle(int cadence, int speed, int gear) {
        this.gear = gear;
        this.cadence = cadence;
        this.speed = speed;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }


}