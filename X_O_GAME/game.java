import java.util.Scanner;

public class game {

    public static void display(char[][]board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int check(char[][] board, int flag, int ind1, int ind2, char c){

        flag = 1;
        for(int left = ind1; left<board.length; left++){
            if(board[left][ind2]!=c){
                flag = 0;
                break;
            }
        }

        for(int right = 0; right<ind1; right++){
            if(board[right][ind2]!=c){
                flag = 0;
                break;
            }
        }

        if(flag == 1){
            // System.out.println("1 ");
            return 1;
        }

        flag = 1;
        for(int up = 0; up<ind2; up++){
            if(board[ind1][up]!=c){
                flag = 0;
                break;
            }
        }

        for(int down = ind2; down<board.length; down++){
            if(board[ind1][down]!=c){
                flag = 0;
                break;
            }
        }
        if(flag == 1){
            // System.out.println("2");
            return 1;
        }
        int flagRight = 1, flag_left = 1;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if( i+j == board.length-1){
                    // System.out.println("left "+board[i][j]);
                    if(board[i][j]!=c){
                        flag_left = 0;
                    }
                }
                if(Math.abs(j-i) == 0){
                    // System.out.println("right "+board[i][j]);
                    if(board[i][j]!=c){
                        flagRight = 0;
                    }
                }
            }
            // if(flag_left == 0){
            //     System.out.println("BREAKK  left");
            //     break;
            // }
            // if (flagRight==0){
            //     System.out.println("BREAKK");
            //     break;
            // }
        }
        if(flagRight == 1){
            // System.out.println("3");
            return 1;
        }

        if(flag_left==1 ){
            // System.out.println("4");
            return 1;
        }
        return 0;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        while (true) {

            System.out.println(" X O - Game ");
            System.out.println("Player 1 is X : Player 2 is O");
            System.out.println("Enter the size of board : ");
            int n = sc.nextInt();
            char[][] board = new char[n][n];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    board[i][j]='0';
                }
            }
            display(board);
            int count = 0;
            int chk = 0, chk1 = 0;

            while(true){
                System.out.println("Please enter the positions to place X - Player 1");
                int ind1 = sc.nextInt();
                int ind2 = sc.nextInt();
                count++;
                // System.out.println(count +" X");
                while(board[ind1][ind2]!='0'){
                    System.out.println("Please select another position.");
                    System.out.println("Please enter the positions to place X - Player 1");
                    ind1 = sc.nextInt();
                    ind2 = sc.nextInt();
                }
                board[ind1][ind2] = 'X';
                display(board);
                System.out.println("***********************************************");
                int flag = 0;
                chk = check(board,flag, ind1, ind2, 'X');
                if(chk == 1){
                    System.out.println("chk :"+chk);
                    System.out.println("X wins");
                    break;
                }
                if(count==(n*n) && chk == 0 && chk1 == 0){
                    System.out.println("THE GAME IS DRAW");
                    break;
                }

                System.out.println("Please enter the positions to place 0 - Player 2");
                ind1 = sc.nextInt();
                ind2 = sc.nextInt();
                count++;
                // System.out.println(count +" X");
                while(board[ind1][ind2]!='0'){
                    System.out.println("Please select another position.");
                    System.out.println("Please enter the positions to place O - Player 2");
                    ind1 = sc.nextInt();
                    ind2 = sc.nextInt();
                }
                board[ind1][ind2] = 'O';
                display(board);
                System.out.println("***********************************************");
                flag = 0;
                chk1 = check(board,flag, ind1, ind2, 'O');
                if(chk1 == 1){
                    System.out.println("O wins");
                    break;
                }

                System.out.println(count+" "+chk+" "+chk1);
                if(count==(n*n) && chk == 0 && chk1 == 0){
                    System.out.println("THE GAME IS DRAW");
                    break;
                }

            }
            System.out.println("Do you want to play again?? Yes/No");
            String choice = sc.next();
            if(choice.equals("No") || choice.equals("no")){
                System.out.println("BYE BYEE!!!!");
                break;
            }
        }


    }
}
