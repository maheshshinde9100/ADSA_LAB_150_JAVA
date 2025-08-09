package DivideAndConquer;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ClosestPairOfPoints_12 {

    public static double closestPair(Point[] points) {
        Point[] px = points.clone();
        Point[] py = points.clone();

        Arrays.sort(px, Comparator.comparingInt(p -> p.x));
        Arrays.sort(py, Comparator.comparingInt(p -> p.y));

        return closestUtil(px, py, points.length);
    }

    private static double closestUtil(Point[] px, Point[] py, int n) {
        if (n <= 3) return bruteForce(px, n);

        int mid = n / 2;
        Point midPoint = px[mid];

        Point[] pyl = new Point[mid];
        Point[] pyr = new Point[n - mid];
        int li = 0, ri = 0;
        for (int i = 0; i < n; i++) {
            if (py[i].x <= midPoint.x && li < mid)
                pyl[li++] = py[i];
            else
                pyr[ri++] = py[i];
        }

        double dl = closestUtil(Arrays.copyOfRange(px, 0, mid), pyl, mid);
        double dr = closestUtil(Arrays.copyOfRange(px, mid, n), pyr, n - mid);

        double d = Math.min(dl, dr);

        List<Point> strip = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (Math.abs(py[i].x - midPoint.x) < d)
                strip.add(py[i]);

        return Math.min(d, stripClosest(strip, d));
    }

    private static double bruteForce(Point[] points, int n) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                min = Math.min(min, distance(points[i], points[j]));
        return min;
    }

    private static double stripClosest(List<Point> strip, double d) {
        double min = d;
        for (int i = 0; i < strip.size(); ++i)
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; ++j)
                min = Math.min(min, distance(strip.get(i), strip.get(j)));
        return min;
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (long)(p1.x - p2.x) +
                (p1.y - p2.y) * (long)(p1.y - p2.y));
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(0, 0),
                new Point(5, 4),
                new Point(3, 1),
                new Point(1, 1),
                new Point(2, 2),
                new Point(4, 3)
        };

        double result = closestPair(points);
        System.out.printf("The smallest distance is %.4f\n", result);
    }
}
