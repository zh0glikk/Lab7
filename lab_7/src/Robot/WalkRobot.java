package Robot;

import TransformInterfaces.Rotatable;
import TransformInterfaces.Shiftable;

import java.util.ArrayList;
import java.util.List;

public class WalkRobot extends Robot implements Rotatable, Shiftable {
    private List<Action> actionList = new ArrayList<>();

    public WalkRobot(int x, int y, int course) {
        super(x, y, course);
    }

    public WalkRobot() {
        this(0, 0, 0);
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionListList(List<Action> list) {
        this.actionList = list;
    }

    public void viewActionList() {
        System.out.println("ActionList:");
        for (int i = 0; i < this.actionList.size(); i++) {
            ActionType actionTmp = this.actionList.get(i).getActionType();
            int amountTmp = this.actionList.get(i).getStepsCount();
            System.out.println((i+1) + "." + actionTmp + " :" + amountTmp);
        }
    }

    public void doSomething() {
        System.out.println("WalkRobot.doSomething()");
    }

    @Override
    public void rotateForward() {
        int tmp = this.getCourse();
        tmp += Rotatable.STEP_ANGLE;
        if ( tmp > 360 ) {
            tmp = 0;
        }

        this.setCourse(tmp);
    }

    @Override
    public void rotateBackward() {
        int tmp = this.getCourse();
        tmp -= Rotatable.STEP_ANGLE;
        if ( tmp < 0 ) {
            tmp += 360;
        }

        this.setCourse(tmp);
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
        for (int i = 0; i < this.actionList.size(); i++) {
            ActionType actionTmp = this.actionList.get(i).getActionType();
            int amountTmp = this.actionList.get(i).getStepsCount();

            while(amountTmp != 0 ) {
                if (actionTmp == ActionType.RotB) {
                    this.rotateBackward();
                    System.out.println("Course " + this.getCourse());
                } else if (actionTmp == ActionType.RotF) {
                    this.rotateForward();
                    System.out.println("Course " + this.getCourse());
                } else if (actionTmp == ActionType.ShiftB) {
                    this.shiftBackward();
                    System.out.println("Position (" + this.getX() + ", " + this.getY() + ")");
                } else if (actionTmp == ActionType.ShiftF) {
                    this.shiftForward();
                    System.out.println("Position (" + this.getX() + ", " + this.getY() + ")");
                } else if (actionTmp == ActionType.DoSmth) {
                    this.doSomething();
                }
                amountTmp -= 1;
            }
        }
    }
}
