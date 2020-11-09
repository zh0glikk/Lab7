package Robot;

import TransformInterfaces.Rotatable;

public class RotRobot extends Robot implements Rotatable {
    private int startAngle;
    private int endAngle;
    private int rotateAngle;

    public RotRobot(int x, int y, int course, int startAngle, int endAngle, int rotateAngle) {
        super(x, y, course);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.rotateAngle = rotateAngle;
    }

    public RotRobot() {
        this(0, 0, 0, 0, 180, Rotatable.STEP_ANGLE);
    }

    public int getStartAngle() {
        return startAngle;
    }

    public int getEndAngle() {
        return endAngle;
    }

    public int getRotateAngle() {
        return rotateAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public void setEndAngle(int endAngle) {
        this.endAngle = endAngle;
    }

    public void setRotateAngle(int rotateAngle) {
        this.rotateAngle = rotateAngle;
    }

    public void doSomething() {
        System.out.println("RotRobot.doSomething()");
    }


    @Override
    public void rotateForward() {
        int tmp = this.getCourse();
        tmp += this.rotateAngle;

        this.setCourse(tmp);
    }

    @Override
    public void rotateBackward() {
        int tmp = this.getCourse();
        tmp -= this.rotateAngle;

        this.setCourse(tmp);
    }

    @Override
    public void move() {
        for ( ; this.getCourse() < getEndAngle(); this.rotateForward()) {
            System.out.print("Course " + this.getCourse() + ":");
            this.doSomething();
        }
        for ( ; this.getCourse() >= getStartAngle(); this.rotateBackward()) {
            System.out.print("Course " + this.getCourse() + ":");
            this.doSomething();
        }
    }
}
