package Soda.SodaPopMachine;

public class SodaPopMachine {
    private int numCans;
    private double money;

    public SodaPopMachine(int numCans, double money) {
        this.numCans = numCans;
        this.money = money;
    }

    public void buySoda() {
        if (numCans > 0) {
            System.out.println("Enjoy your soda!");
            numCans--;
            money += 1.5;
        } else {
            System.out.println("Sorry, no more soda cans available.");
        }
    }

    public void refill(int numCansToAdd) {
        numCans += numCansToAdd;
        System.out.println("Machine refilled with " + numCansToAdd + " soda cans.");
    }

    public void displayStatus() {
        System.out.println("Number of soda cans: " + numCans);
        System.out.println("Amount of money in machine: $" + money);
    }

    public static void main(String[] args) {
        SodaPopMachine machine = new SodaPopMachine(10, 15.0);

        machine.displayStatus();
        machine.buySoda();
        machine.buySoda();
        machine.refill(5);
        machine.buySoda();
        machine.displayStatus();
    }
}
