package TransformInterfaces;

public interface Shiftable extends Movable{
    int STEP_SHIFT = 1;

    void shiftForward();
    void shiftBackward();
}
