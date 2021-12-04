package day4;

public class Board {
    private String[][] rowsAndCols = new String[10][5];

    public Board(String[] boardData){

        // Extract rows
        for(int i = 0; i < 5; i++){
            String[] rowData = boardData[i].split("\\s+");
            for(int m = 0; m < 5; m++){
                rowsAndCols[i][m] = rowData[m];
            }
        }

        // Extract columns
        for(int m = 0; m < 5; m++){
            for(int i = 0; i < 5; i++){
                String[] rowData = boardData[i].split("\\s+");
                rowsAndCols[m+5][i] = rowData[m];
            }
        }
    }

    public boolean checkWin(String[] called){
        for(int r = 0; r < 10; r++) {
            Integer found = 0;
            for (int c = 0; c < 5; c++) {
                for(int n = 0; n < called.length; n++){
                    if(called[n].equals(rowsAndCols[r][c])){
                        found++;
                        break;
                    }
                }
            }
            if(found == 5){
                return true;
            }
    }

        return false;
    }

    public Integer countValue(String[] called){
        Integer sumUnmarked = 0;
        for(int x = 0; x < 5; x++){
            for(int y  = 0; y < 5; y++){
                boolean numberUnmarked = true;
                for(int c = 0; c < called.length; c++){
                    if(rowsAndCols[x][y].equals(called[c]))
                        numberUnmarked = false;
                }

                if(numberUnmarked){
                    Integer addValue = Integer.parseInt(rowsAndCols[x][y]);
                    sumUnmarked += addValue;
                }
            }
        }
        return Integer.parseInt(called[called.length-1])*sumUnmarked;
    }
}
