package be.vercruysse.advent2019.day12;

import java.util.List;
import java.util.stream.Collectors;

public class NBody {

    private List<Moon> moons;

    public NBody(List<Moon> moons) {
        this.moons = moons;
    }

    public void calculateNextStep() {
        for(Moon moon: moons) {
            for (Moon otherMoon: moons) {
                if(moon.equals(otherMoon)) {
                  continue;
                }
                moon.changeVelocity(otherMoon);
            }
        }
        moons.forEach(Moon::changePosition);
    }

    @Override
    public String toString() {
        return moons.stream().map(Moon::toString).collect(Collectors.joining("\n"));
    }

    public int getTotalEnergy() {
        return moons.stream().mapToInt(Moon::totalEnergy).sum();
    }

    public int getTotalKineticEnergy() {
        return moons.stream().mapToInt(Moon::getKineticEnergy).sum();
    }

    public int getTotalPotentialEnergy() {
        return moons.stream().mapToInt(Moon::getPotentialEnergy).sum();
    }

    public boolean allMoonsAreBackFor(char x) {
        return moons.stream().allMatch(m -> m.isBackAtOriginalPositionFor(x));
    }
}
