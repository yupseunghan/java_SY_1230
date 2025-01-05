package day02;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        Board board = new Board(m,n);
        Ball myBall = new Ball(startX, startY);
        int[] answer = new int[balls.length];
        for (int i = 0 ; i < balls.length; i++) {
            Ball target = new Ball(balls[i][0],balls[i][1]);
            answer[i] = board.getDistanceSqure(myBall,target);
        }
        return answer;
    }

}

class Board {
    private final int width, height;

    public Board (int m, int n) {
        width = m;
        height = n;
    }

    public int getDistanceSqure(Ball myBall, Ball b) {
        int min = Integer.MAX_VALUE;
        // 왼쪽에 부딫히는 경우
        if (!(myBall.y == b.y && myBall.x > b.x)) {
            int distSqr = (myBall.x + b.x) * (myBall.x + b.x) 
                + (myBall.y - b.y) * (myBall.y - b.y);
            //System.out.println("left = " + distSqr);
            if (distSqr < min) min = distSqr;
        }

        // 위에 부딫히는 경우
        if (!(myBall.x == b.x && myBall.y < b.y)) {
            int distSqr = (2*height - myBall.y - b.y) * (2*height - myBall.y - b.y) 
                + (myBall.x - b.x) * (myBall.x - b.x);
            //System.out.println("up = " + distSqr);
            if (distSqr < min) min = distSqr;
        }

        // 오른쪽에 부딫히는 경우
        if (!(myBall.y == b.y && myBall.x < b.x)) {
            int distSqr = (2*width - myBall.x - b.x) * (2*width - myBall.x - b.x) 
                + (myBall.y - b.y) * (myBall.y - b.y);
            //System.out.println("right = " + distSqr);
            if (distSqr < min) min = distSqr;
        }

        // 아래에 부딫히는 경우
        if (!(myBall.x == b.x && myBall.y > b.y)) {
            int distSqr = (myBall.y + b.y) * (myBall.y + b.y) 
                + (myBall.x - b.x) * (myBall.x - b.x);
            //System.out.println("down = " + distSqr);
            if (distSqr < min) min = distSqr;
        }
        return min;
    }
}

class Ball {
    final int x;
    final int y;

    public Ball (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
