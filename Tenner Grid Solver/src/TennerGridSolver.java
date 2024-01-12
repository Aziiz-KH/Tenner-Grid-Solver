public class TennerGridSolver {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		
    int[][] board1 = {
	           {-1, -1, 1, -1, 3, 8, 6, 9, -1, 2},
	           {6, 2, -1, -1, 1, -1, -1, 7, 4, 3},
	           {7, 4, 5, -1, 0, 6, -1, -1, 8, -1},
	           {-1, -1, 8, -1, 4, 9, 5, 7, -1, -1},
	           {7, 9, 1, 0, -1, -1, 4, 8, 5, 2},};    
int [] sum1 =  {26,20,15,27,14,35,21,34,23,10};
System.out.println("Initial state of the board: ");
    printBoard(board1);
    printSum(sum1);
    System.out.println();
    System.out.println("------------------------------");
    solveBoard(board1,sum1);
    checkSolution(board1,sum1);
    printBoard(board1);
    printSum(sum1);
    
    System.out.println();
    System.out.println();
    System.out.println("=================================="); 
    System.out.println();
         int[][] board2 = {
               {-1, 6, 2, 0, -1, -1, -1, 8, 5, 7},
               {-1, 0, 1, 7, 8, -1, -1, -1, 9, -1},
               {-1, 4, -1, -1, 2, -1, 3, 7, -1, 8},};
        int [] sum2 =  {13,10,8,7,19,16,11,19,15,17};
        System.out.println("Initial state of the board: ");
        printBoard(board2);
        printSum(sum2);
        System.out.println();
        System.out.println("------------------------------");
    solveBoard(board2,sum2);
    checkSolution(board2,sum2);  
    printBoard(board2);
    printSum(sum2); 
    System.out.println();

    long endTime = System.currentTimeMillis();
		System.out.println();
		
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

	
	public static void checkSolution(int[][] board, int[] sum) {
		boolean flag = true;
		
		for (int column = 0; column < getColumn(board); column++) {
			for (int row = 0; row < getRow(board); row++) {

				if (equalsSum(board, sum, row, column)) {
				} else {
					flag = false;
					break;
				}
			
		}
		}
		if (flag == true) {
			System.out.println("Solved Successfully :)");
		} else
			System.out.println("Unsolvable board :( ");

	}

	public static int getRow(int[][] board) {
		return board.length;

	}

	public static int getColumn(int[][] board) {
		return board[0].length;
	}

	private static void printBoard(int[][] board) {
		for (int row = 0; row < getRow(board); row++) {
			for (int column = 0; column < getColumn(board); column++) {
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
	}

	private static void printSum(int[] sum) {
		for (int i = 0; i < sum.length; i++) {
			System.out.print(sum[i] + " ");
		}
	}

	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < getColumn(board); i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	private static boolean isNumberAdjecent(int[][] board, int number, int row, int column) {
		int i = row;
		int j = column;

		if (row == 0 && column == 0) {
			if (board[i + 1][j] == number)
				return true;
			if (board[i][j + 1] == number)
				return true;
			if (board[i + 1][j + 1] == number)
				return true;
		}

		else if (column == 0 && row != 0 && row != getRow(board) - 1) {

			if (board[i - 1][j] == number)
				return true;
			if (board[i + 1][j] == number)
				return true;
			if (board[i][j + 1] == number)
				return true;
			if (board[i - 1][j + 1] == number)
				return true;
			if (board[i + 1][j + 1] == number)
				return true;
		}

		else if (column == 0 && row == getRow(board) - 1) {
			if (board[i - 1][j] == number)
				return true;
			if (board[i][j + 1] == number)
				return true;
			if (board[i - 1][j + 1] == number)
				return true;

		} else if (row == 0 && column != 0 && column != getColumn(board) - 1) {
			if (board[i][j - 1] == number)
				return true;
			if (board[i][j + 1] == number)
				return true;
			if (board[i + 1][j] == number)
				return true;
			if (board[i + 1][j + 1] == number)
				return true;
			if (board[i + 1][j - 1] == number)
				return true;
		}

		else if (column != 0 && column != getColumn(board) - 1 && row == getRow(board) - 1) {
			if (board[i - 1][j] == number)
				return true;
			if (board[i][j - 1] == number)
				return true;
			if (board[i][j + 1] == number)
				return true;
			if (board[i - 1][j - 1] == number)
				return true;
			if (board[i - 1][j + 1] == number)
				return true;
		}

		else if (row == 0 && column == getColumn(board) - 1) {
			if (board[i][j - 1] == number)
				return true;
			if (board[i + 1][j] == number)
				return true;
			if (board[i + 1][j - 1] == number)
				return true;
		}

		else if (row == getRow(board) - 1 && column == getColumn(board) - 1) {
			if (board[i][j - 1] == number)
				return true;
			if (board[i - 1][j] == number)
				return true;
			if (board[i - 1][j - 1] == number)
				return true;
		}

		else if (column == getColumn(board) - 1 && row != 0 && row != getRow(board) - 1) {
			if (board[i + 1][j] == number)
				return true;
			if (board[i - 1][j] == number)
				return true;
			if (board[i][j - 1] == number)
				return true;
			if (board[i - 1][j - 1] == number)
				return true;
			if (board[i + 1][j - 1] == number)
				return true;
		} else {
			if (board[i][j - 1] == number)
				return true;
			if (board[i][j + 1] == number)
				return true;
			if (board[i + 1][j] == number)
				return true;
			if (board[i - 1][j] == number)
				return true;
			if (board[i + 1][j + 1] == number)
				return true;
			if (board[i - 1][j - 1] == number)
				return true;
			if (board[i - 1][j + 1] == number)
				return true;
			if (board[i + 1][j - 1] == number)
				return true;
		}
		return false;
	}

	private static boolean isValidPlacement(int[][] board, int sum[], int number, int row, int column) {
		return !isNumberInRow(board, number, row) && !isNumberAdjecent(board, number, row, column);

	}

	private static boolean isEmpty(int[][] board, int row, int column) {

		for (int i = row; i < getRow(board) - 1; i++)
			if (board[i + 1][column] == -1) {
				return true;
			}
		return false;
	}

	private static boolean equalsSum(int[][] board, int[] sum, int row, int column) {
		int summation = 0;

		for (int i = 0; i < getRow(board); i++) {
			summation += board[i][column];
		}
		if (sum[column] == summation )
			return true;

		return false;

	}

	private static boolean solveBoard(int[][] board, int[] sum) {
		int x = 0;
		for (int column = 0; column < getColumn(board); column++) {
			for (int row = 0; row < getRow(board); row++) {

				if (board[row][column] == -1) {// checks if the square is empty or not

					for (int numberToTry = x; numberToTry <= 9; numberToTry++) { // we use x instead of zero to have a
																					// variable instead of a constant

						if (isValidPlacement(board, sum, numberToTry, row, column)) {// checks if the numberToTry is
																						// valid or not

							board[row][column] = numberToTry; // we assign the number to the square

							if (isEmpty(board, row, column) == false) { // checks if there are any empty squares left in
																		// the column

								if (equalsSum(board, sum, row, column) == true) { // since there are no empty squares we
																					// can check
																					// if the squares in the column
																					// equals the sum
									x = 0; //

									if (solveBoard(board, sum)) { // After assigning any number we recursively call the
																	// same method
										return true;
									}

								} else {
									board[row][column] = -1; // when the recursive returns false we use BACKTRACKING
								}

							}

							x = numberToTry + 1; // So we don't fall in infinite loop
							if (isEmpty(board, row, column) == true) { // enters this recursive if there are empty
																		// squares BUT doesn't calculate the sum
								x = 0; // So we don't fall in infinite loop
								if (solveBoard(board, sum)) { // After assigning any number we recursively call the same
																// method
									return true;
								}

							}
							board[row][column] = -1; // when the recursive returns false we use BACKTRACKING

						}

					}
					return false; // This is when there is no solution
				}

			}
		}
		return true; // This is when there is a solution
	}
}