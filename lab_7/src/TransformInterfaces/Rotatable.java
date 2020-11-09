package TransformInterfaces;

public interface Rotatable extends Movable{
    int STEP_ANGLE = 90;

    void rotateForward();
    void rotateBackward();
}
