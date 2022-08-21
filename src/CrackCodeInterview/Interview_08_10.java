package CrackCodeInterview;

public class Interview_08_10 {
    /*
     * 经典走格子，利用回溯法
     * */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int defColor = image[sr][sc];
        if (defColor != newColor) {//颜色一样不处理
            travel(image, sr, sc, defColor, newColor, visited);
        }
        return image;
    }

    private void travel(int[][] image, int sr, int sc, int defColor, int newColor, boolean[][] visited) {
        if (sr < image.length && sr >= 0 && sc < image[0].length && sc >= 0
                && !visited[sr][sc] && image[sr][sc] == defColor) {
            visited[sr][sc] = true;
            image[sr][sc] = newColor;
            travel(image, sr + 1, sc, defColor, newColor, visited);
            travel(image, sr, sc + 1, defColor, newColor, visited);
            travel(image, sr - 1, sc, defColor, newColor, visited);
            travel(image, sr, sc - 1, defColor, newColor, visited);
        }
    }
}
