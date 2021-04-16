package Algorithm.BinarySearch;

public class Problem0302 {
    public int minArea(char[][] image,int x,int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0 || image[x][y] == '0') {
            return 0;
        }
        int left = findFirst(image,0,y,false);
        int right = findLast(image,y,image[0].length - 1,false);
        int up = findFirst(image,0,x,true);
        int down = findLast(image,x,image.length - 1,true);
        return (right - left + 1) * (down - up + 1);
    }

    private int findFirst(char[][] image,int start,int end,boolean needCheckRow) {
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if ((needCheckRow && checkRow(image,mid)) || (!needCheckRow && checkColumn(image,mid))) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if ((needCheckRow && checkRow(image,start)) || (!needCheckRow && checkColumn(image,start))) {
            return start;
        }
        return end;
    }

    private int findLast(char[][] image,int start,int end,boolean needCheckRow) {
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if ((needCheckRow && checkRow(image,mid)) || (!needCheckRow && checkColumn(image,mid))) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if ((needCheckRow && checkRow(image,end)) || (!needCheckRow && checkColumn(image,end))) {
            return end;
        }
        return start;
    }

    private boolean checkRow(char[][] image,int row) {
        for (int col = 0; col < image[0].length; ++col) {
            if (image[row][col] == '1') {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(char[][] image,int col) {
        for (char[] chars : image) {
            if (chars[col] == '1') {
                return true;
            }
        }
        return false;
    }
}
