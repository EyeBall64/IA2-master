public class Table {
    private String [][] endings;
    private int[][] score;
    private FileNouns noun;
    private DataBase noun2;

    public Table() {
        noun = new FileNouns();
        endings = new String[7][3];
        score = new int[6][2];
        System.out.println("vars");

        noun2 = new DataBase("\\\\bex-file-01\\studenthome$\\16\\16Hurley_J\\computer science\\LatinNouns.txt", 10);
        System.out.println("before");
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 3; y++) {
                endings[x][y] = (noun2.getRecord(x+1,y+1));
                System.out.println("nouns");
            }
        }

          /*
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 3; y++) {
                endings[x][y] = (noun.getNouns(x, y));
            }
        }
          */
    }

    public void display(){
        //gets the score for the endings
        for(int x=0;x<6;x++){
            for(int y=0;y<2;y++){
                score[x][y] = (FileScore.getShortTermScore(x,y));
            }
        }

        printTable();
        printScore();
    }

    public void printTable(){
        //prints out the table
        for(int x=0;x<7;x++){
            for(int y=0;y<3;y++){
                if(y == 2) {
                    System.out.println(endings[x][y]);
                }else{
                    System.out.print(endings[x][y]);
                    System.out.print("|");
                }
            }
        }
    }

    public void printScore(){
        //prints out score
        for(int x=0;x<7;x++){
            for(int y=0;y<3;y++){
                if(y == 0 || x == 0) {
                    if(y == 2){
                        System.out.println("          ");
                    }else {
                        System.out.print("          ");
                    }
                }else if(y == 2){
                    System.out.print("|");
                    System.out.println(score[x-1][y-1]);

                }else{
                    System.out.print("|");
                    System.out.print(score[x-1][y-1]);
                    System.out.print("        ");
                }
            }
        }
    }

}
