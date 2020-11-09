package Robot;

public class Action {
    private ActionType actionType;
    private int stepsCount;

    public Action(ActionType actionType, int stepsCount) {
        this.actionType = actionType;
        this.stepsCount = stepsCount;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public void setStepsCount(int stepsCount) {
        this.stepsCount = stepsCount;
    }
}
