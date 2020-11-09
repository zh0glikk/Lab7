package Robot;

import TransformInterfaces.Shiftable;

public class ShiftRobot extends Robot implements Shiftable {
    private int startPos;
    private int endPos;

    public ShiftRobot(int x, int y, int course, int startPos, int endPos) {
        super(x, y, course);
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public ShiftRobot() {
        this(0, 0, 0, 0, 5);
    }

    public int getEndPos() {
        return endPos;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public void doSomething() {
        System.out.println("ShiftRobot.doSomething()");
    }

    @Override
    public void shiftForward() {
        if ( this.getCourse() == 0 ) {
            this.setX(this.getX() + Shiftable.STEP_SHIFT);
        } else if ( this.getCourse() == 180 ) {
            this.setX(this.getX() - Shiftable.STEP_SHIFT);
        } else if ( this.getCourse() == 90 ) {
            this.setY(this.getY() + Shiftable.STEP_SHIFT);
        } else if ( this.getCourse() == 270 ) {
            this.setY(this.getY() - Shiftable.STEP_SHIFT);
        }
    }

    @Override
    public void shiftBackward() {
        if ( this.getCourse() == 0 ) {
            this.setX(this.getX() - Shiftable.STEP_SHIFT);
        } else if ( this.getCourse() == 180 ) {
            this.setX(this.getX() + Shiftable.STEP_SHIFT);
        } else if ( this.getCourse() == 90 ) {
            this.setY(this.getY() - Shiftable.STEP_SHIFT);
        } else if ( this.getCourse() == 270 ) {
            this.setY(this.getY() + Shiftable.STEP_SHIFT);
        }
    }

    @Override
    public void move() {
        for ( ; this.getX() <= this.endPos && this.getY() <= this.endPos; this.shiftForward()) {
            System.out.print("Position (" + this.getX() + ", " + this.getY() + ")" + ":");
            this.doSomething();
        }
        for ( ; this.getX() >= this.startPos && this.getY() >= this.startPos; this.shiftBackward()) {
            System.out.print("Position (" + this.getX() + ", " + this.getY() + ")" + ":");
            this.doSomething();
        }
    }
}
