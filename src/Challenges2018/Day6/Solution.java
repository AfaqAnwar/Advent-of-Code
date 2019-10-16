package Challenges2018.Day6;

import Challenges2018.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Solutions to the Day Six Puzzles.
 * @Author Afaq Anwar
 * @Version 10/16/2019
 */
public class Solution {
    public static String puzzleOne(ArrayList<String> input) {
        ArrayList<Point> allPoints = new ArrayList<>();
        for (String line : input) {
            String[] splitLocations = line.split(",");
            Point point = new Point(Integer.parseInt(splitLocations[0].trim()), Integer.parseInt(splitLocations[1].trim()));
            point.setAssociated(true);
            point.setAssociatedPoint(point);
            point.setDistanceFromAssociatedPoint(0);
            allPoints.add(point);
        }
        Point[][] grid = generateGrid(allPoints);

        // Points that should not be checked. Initially just the given points.
        ArrayList<Point> redundantPoints = new ArrayList<>(allPoints);

        //Rework
        for (Point[] pointRow : grid) {
            for (Point currentPoint : pointRow) {
                if (!redundantPoints.contains(currentPoint)) {
                    for (Point givenPoint : allPoints) {
                        int distance = Math.abs(givenPoint.getPointX() - currentPoint.getPointX()) + Math.abs(givenPoint.getPointY() - currentPoint.getPointY());
                        if (!currentPoint.isAssociated()) {
                            currentPoint.setAssociated(true);
                            currentPoint.setAssociatedPoint(givenPoint);
                            currentPoint.setDistanceFromAssociatedPoint(distance);
                        } else {
                            int prevDistToPrevPoint = currentPoint.getDistanceFromAssociatedPoint();
                            if (prevDistToPrevPoint > distance) {
                                currentPoint.setAssociatedPoint(givenPoint);
                                currentPoint.setDistanceFromAssociatedPoint(distance);
                            } else if (prevDistToPrevPoint == distance) {
                                currentPoint.setAssociated(false);
                                currentPoint.setAssociatedPoint(null);
                                currentPoint.setDistanceFromAssociatedPoint(0);
                                redundantPoints.add(currentPoint);
                            }
                        }
                    }
                }
            }
        }

        // Debug
        for (Point[] row : grid) {
            for (Point point : row) {
                if (point.isAssociated()) {
                    System.out.print(" [" + point.getAssociatedPoint().getPointX() + ", " + point.getAssociatedPoint().getPointY() + "] ");
                } else {
                    System.out.print(" [ .  ] ");
                }
            }
            System.out.println();
        }

        ArrayList<Point> infinitePoints = new ArrayList<>();
        infinitePoints.add(grid[0][0].getAssociatedPoint());
        infinitePoints.add(grid[grid.length - 1][0].getAssociatedPoint());
        infinitePoints.add(grid[0][grid[0].length - 1].getAssociatedPoint());
        infinitePoints.add(grid[grid.length - 1][grid[grid.length - 1].length - 1].getAssociatedPoint());

        HashMap<Point, Integer> pointArea = calculateArea(grid, infinitePoints);

        for (Point key : pointArea.keySet()) {
            System.out.println(key.getPointX() + ", " + key.getPointY() + " - " + pointArea.get(key));
        }

        return "";
    }

    public static Point[][] generateGrid(ArrayList<Point> points) {
        int horizontalBound = 0;
        int verticalBound = 0;
        for (Point currPoint : points) {
            if (currPoint.getPointX() > horizontalBound) {
                horizontalBound = currPoint.getPointX();
            }
            if (currPoint.getPointY() > verticalBound) {
                verticalBound = currPoint.getPointY();
            }
        }

        Point[][] grid = new Point[horizontalBound + 2][horizontalBound + 2];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Point(x, y);
            }
        }

        return grid;
    }

    public static HashMap<Point, Integer> calculateArea (Point[][] grid, ArrayList<Point> infinitePoints) {
        HashMap<Point, Integer> pointArea = new HashMap<>();
        for (Point[] row : grid) {
            for (Point point : row) {
                Point associatedPoint = point.getAssociatedPoint();
                if (!infinitePoints.contains(associatedPoint) && point.isAssociated()) {
                    if (pointArea.containsKey(associatedPoint)) {
                        pointArea.replace(associatedPoint, pointArea.get(associatedPoint) + 1);
                    } else {
                        pointArea.put(associatedPoint, 1);
                    }
                }
            }
        }
        return pointArea;
    }

    public static String puzzleTwo(ArrayList<String> input) {
        return "";
    }

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader(new File("src/Challenges2018/Day6/input.txt"));
        System.out.println("First Puzzle Answer - " + puzzleOne(inputReader.getInput()));
        System.out.println("Second Puzzle Answer - " + puzzleTwo(inputReader.getInput()));
    }
}
