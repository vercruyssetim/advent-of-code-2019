package be.vercruysse.advent2019.day13.intcode.io;

public class SystemOutput implements OutputListener {

    @Override
    public void receiveOutput(Long value) {
        System.out.println("Value " + value);
    }
}
