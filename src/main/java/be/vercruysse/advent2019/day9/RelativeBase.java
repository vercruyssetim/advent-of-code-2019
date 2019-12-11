package be.vercruysse.advent2019.day9;

public class RelativeBase {

    private final static RelativeBase INSTANCE = new RelativeBase();

    private Long base = 0L;

    public static RelativeBase getInstance() {
        return INSTANCE;
    }

    public Long getBase() {
        return base;
    }

    public void setBase(Long base) {
        this.base = base;
    }

    public void adjustBase(Long value) {
        this.base += value;
    }
}
