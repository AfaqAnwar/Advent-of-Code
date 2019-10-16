package Challenges2018.Day6;

public class Point {
    private int xPoint;
    private int yPoint;
    private boolean associated;
    private Point associatedPoint;

    public Point(int xPoint, int yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.associated = false;
    }

    public int getPointX() { return xPoint; }
    public int getPointY() { return yPoint; }

    public boolean isAssociated() { return associated; }
    public void setAssociated(boolean associated) { this.associated = associated; }

    public Point getAssociatedPoint() { return this.associatedPoint; }
    public void setAssociatedPoint(Point associatedPoint) { this.associatedPoint = associatedPoint; }
}
