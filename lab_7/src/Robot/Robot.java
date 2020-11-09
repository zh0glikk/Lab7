package Robot;

public class Robot {
    private int x;
    private int y;
    private int course;

    public Robot(int x, int y, int course) {
        this.x = x;
        this.y = y;
        this.course = course;
    }

    public Robot() {
        this(0, 0, 0);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return y;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void doSomething() {
        System.out.println("Robot.doSomething()");
    }

}
