package be.vercruysse.advent2019.day12;

public class Moon {

    private final Coordinate originalCoordinate;

    private Coordinate coordinate;
    private Velocity velocity = new Velocity(0, 0, 0);

    public Moon(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.originalCoordinate = coordinate;
    }


    public void changeVelocity(Moon otherMoon) {
        Velocity velocity = coordinate.getDifference(otherMoon.getCoordinate());
        this.velocity = this.velocity.add(velocity);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int totalEnergy() {
        System.out.println(coordinate.getEnergy() + " * " + velocity.getEnergy());
        int energy = coordinate.getEnergy() * velocity.getEnergy();
        System.out.println(energy);
        return energy;
    }

    @Override
    public String toString() {
        return "pos=" + coordinate.toString() + ", vel=" + velocity;
    }

    public void changePosition() {
        this.coordinate = this.coordinate.change(velocity);
    }

    public int getKineticEnergy() {
        return velocity.getEnergy();
    }

    public int getPotentialEnergy() {
        return coordinate.getEnergy();
    }

    public boolean isBackAtOriginalPositionFor(char dimension) {
        return originalCoordinate.get(dimension) == coordinate.get(dimension) && velocity.get(dimension) == 0;
    }

}
