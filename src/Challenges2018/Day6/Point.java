package Challenges2018.Day6;

public class Point {
    private int xPoint;
    private int yPoint;
    private boolean infinite;

    public Point(int xPoint, int yPoint, boolean infinite) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.infinite = infinite;
    }

    public int getPointX() { return xPoint; }
    public int getPointY() { return yPoint; }

    public boolean isInfinite() { return infinite; }
    public void setInfinite(boolean infinite) { this.infinite = infinite; }
}
