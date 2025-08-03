package tasks;
import java.util.*;
/*
Given a list of buildings, each represented as [left, right, height], return the skyline as a list of [x, height] key points.

input: [[2,9,10],[3,7,15],[5,12,12]]
output: [[2,10],[3,15],[7,12],[12,0]]
 */
public class SkyLineProblem_05 {
        public List<int[]> getSkyline(int[][] buildings) {
            if (buildings.length == 0) return new ArrayList<>();
            return divideAndConquer(buildings, 0, buildings.length - 1);
        }
        private List<int[]> divideAndConquer(int[][] buildings, int left, int right) {
            List<int[]> result = new ArrayList<>();

            if (left == right) {
                int x1 = buildings[left][0];
                int x2 = buildings[left][1];
                int h = buildings[left][2];

                result.add(new int[]{x1, h});
                result.add(new int[]{x2, 0});
                return result;
            }

            int mid = (left + right) / 2;

            List<int[]> leftSkyline = divideAndConquer(buildings, left, mid);
            List<int[]> rightSkyline = divideAndConquer(buildings, mid + 1, right);

            return mergeSkylines(leftSkyline, rightSkyline);
        }

        private List<int[]> mergeSkylines(List<int[]> left, List<int[]> right) {
            List<int[]> merged = new ArrayList<>();
            int h1 = 0, h2 = 0;
            int i = 0, j = 0;
            int prevHeight = 0;

            while (i < left.size() && j < right.size()) {
                int x, maxH;
                if (left.get(i)[0] < right.get(j)[0]) {
                    x = left.get(i)[0];
                    h1 = left.get(i)[1];
                    maxH = Math.max(h1, h2);
                    i++;
                } else if (left.get(i)[0] > right.get(j)[0]) {
                    x = right.get(j)[0];
                    h2 = right.get(j)[1];
                    maxH = Math.max(h1, h2);
                    j++;
                } else {
                    x = left.get(i)[0];
                    h1 = left.get(i)[1];
                    h2 = right.get(j)[1];
                    maxH = Math.max(h1, h2);
                    i++;
                    j++;
                }

                if (merged.isEmpty() || prevHeight != maxH) {
                    merged.add(new int[]{x, maxH});
                    prevHeight = maxH;
                }
            }

            // Adding remaining points
            while(i<left.size()) merged.add(left.get(i++));
            while(j<right.size()) merged.add(right.get(j++));

            return merged;
        }

        public static void main(String[] args) {
            SkyLineProblem_05 solver = new SkyLineProblem_05();
            int[][] buildings = {
                    {2,9,10},
                    {3,7,15},
                    {5,12,12}
            };
            List<int[]> skyline = solver.getSkyline(buildings);
            System.out.println("Skyline:");
            for (int[] point : skyline) {
                System.out.println(Arrays.toString(point));
            }
        }
    }
