import Robot.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        RotRobot rotRobot = new RotRobot();
        ShiftRobot shiftRobot = new ShiftRobot();
        WalkRobot walkRobot = new WalkRobot();

        rotRobot.move();
        shiftRobot.move();

        List<Action> list = new ArrayList<>();
        list.add(new Action(ActionType.RotB, 2));
        list.add(new Action(ActionType.ShiftF, 2));
        list.add(new Action(ActionType.RotF, 1));
        list.add(new Action(ActionType.ShiftF, 2));

        walkRobot.setActionListList(list);
        walkRobot.move();

        walkRobot.viewActionList();
    }
}
