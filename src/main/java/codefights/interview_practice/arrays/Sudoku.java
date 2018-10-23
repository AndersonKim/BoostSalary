package codefights.interview_practice.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Sudoku {
    static String [][] sudoku={
            {".",".",".","1","4",".",".","2","."},
            {".",".","6",".",".",".",".",".","."},
            {".",".",".",".",".",".",".",".","."},
            {".",".","1",".",".",".",".",".","."},
            {".","6","7",".",".",".",".",".","9"},
            {".",".",".",".",".",".","8","1","."},
            {".","3",".",".",".",".",".",".","6"},
            {".",".",".",".",".","7",".",".","."},
            {".",".",".","5",".",".",".","7","."}
    };
    public static void main(String[] args){
        //0.check the line and column 1-9
        //1.sub-grids 1-9
        boolean lcEqual=false;
        boolean subGrid=false;
        //0
        for(int i=0;i<sudoku.length;i++){
            for (int j=0;j<sudoku[i].length;j++){
                String num=sudoku[i][j];
                if(!num.equals(".")){
                    //0.1 collect line
                    ArrayList<String> line=new ArrayList<>();
                    for (int e=0;e<sudoku[i].length;e++){
                        if(!sudoku[i][e].equals(".")){
                            line.add(sudoku[i][e]);
                        }
                    }
                    //0.2 collect column
                    ArrayList<String> column=new ArrayList<>();
                    for (int e=0;e<sudoku.length;e++){
                        if(!sudoku[e][j].equals(".")){
                            column.add(sudoku[e][j]);
                        }
                    }
                    lcEqual=haveEqual(line)&&haveEqual(column);
                }
            }
        }


        //1
        for (int i = 0; i <sudoku.length ; i+=3) {
            for (int j = 0; j <sudoku[i].length ; j+=3) {
                List<String> tempNumArray=travleSubgrid(sudoku,i,j,3);
                if(haveEqual(tempNumArray)){
                    subGrid=true;
                }
            }

        }
    }

    /**
     * travels the sudoku sub grid from position i,j with w width
     * @param sudoku
     * @param m
     * @param n
     * @param w
     * @return
     */
    private static List<String> travleSubgrid(String[][] sudoku, int m, int n,int w) {
        List<String> result=new ArrayList<>();
        for(int i=m;i<m+w;i++){
            for (int j = n; j <n+w ; j++) {
                if(!sudoku[i][j].equals(".")){
                    result.add(sudoku[i][j]);
                }
            }
        }
        return result;
    }

    /**
     * if the input array have same str in it
     * @param stringList
     * @return
     */
    public static boolean haveEqual(List<String> stringList){
        for (String str:stringList){
            int pos = stringList.indexOf(str);
            if(pos!=stringList.lastIndexOf(str)){
                return true;
            }
        }
        return false;
    }


}
