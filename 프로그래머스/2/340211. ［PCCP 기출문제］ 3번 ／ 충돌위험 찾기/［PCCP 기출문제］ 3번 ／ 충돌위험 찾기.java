import java.util.*;
class Debug {
    static void p(Object... args) {
        if (args.length == 1) {
            System.out.println(args[0]);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i += 2) {
            if (i > 0) sb.append(", ");
            sb.append(args[i]).append(": ").append(args[i + 1]);
        }
        System.out.println(sb.toString());
    }

}

record Pos(int x, int y) {}

class Robot {
    private Queue<Pos> allPoints;
    private Pos currentPos;
    
    public Robot (Queue<Pos> allPoints) {
        this.allPoints = allPoints;
        this.currentPos = allPoints.poll();
    }
    
    public Pos getCurrentPos() {
        return currentPos;
    }
    
    public Pos move() {
        if (allPoints.isEmpty()) return null;   // 재귀 바닥
        
        Pos dest = allPoints.peek();
        int dx = moveDirectOne(currentPos.x(), dest.x());
        int dy = moveDirectOne(currentPos.y(), dest.y());

        if (dx == 0 && dy == 0) {
            allPoints.poll();
            return move();
        }
        currentPos = (dx != 0)
            ? new Pos(currentPos.x() + dx, currentPos.y())
            : new Pos(currentPos.x(), currentPos.y() + dy);
        return currentPos;
    }
    
    public int moveDirectOne(int source, int destination) {
        int diff = destination - source;
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        } 
        return 0;
    }
}

class Solution {
    List<Robot> robots;
    int ans = 0;
    int turnI = 0;

    public void turn() {
        Map<Pos, Integer> map = new HashMap<>(); 
        
        for (int i = 0; i < robots.size(); i++) {
            Robot robot = robots.get(i);
            Pos nextPos = robot.move();
            
            if (nextPos == null) {
                robots.remove(i);
                i--;
            } else {
                map.put(nextPos, map.getOrDefault(nextPos, 0) + 1);
            }
        }
        
        int count = 0;
        for (Pos pos : map.keySet()) {
            int value = map.get(pos);
            if (value > 1) {
                count++;
            }
        }
        ans += count;
    }
    
    public int solution(int[][] points, int[][] routes) {
        robots = new ArrayList<>();
        for (int[] route : routes) {
            Queue<Pos> allPoints = new ArrayDeque<>();
            for (int pointNextIdx : route) {
                int[] point = points[pointNextIdx - 1];
                allPoints.add(new Pos(point[0], point[1]));
            }
            Robot robot = new Robot(allPoints);
            robots.add(robot);
        }
        
        // 움직이기 전에 count 하나 검사
        Map<Pos, Integer> map = new HashMap<>(); 
        for (Robot robot : robots) {
            Pos pos = robot.getCurrentPos();
            map.put(pos, map.getOrDefault(pos, 0) + 1);
        }
        
        int count = 0;
        for (Pos pos : map.keySet()) {
            int value = map.get(pos);
            if (value > 1) {
                count++;
            }
        }
        ans += count;
        
        // 이제 일반화
        while (robots.size() > 0) {
            turn();
        }

        return ans;
    }
}