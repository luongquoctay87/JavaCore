package src;

public class Main {

    public static void main(String[] args) {

//        int arrX[] = new int[3];// định nghĩa và tạo array
//
//        arrX[0] = 13; // gán phần từ vào mảng
//        arrX[1] = 49;
//        arrX[2] = 77;
//
//        // Duyệt mảng
//        for (int i = 0; i < arrX.length; i++) {
//            System.out.println(arrX[i]);
//        }
//
//        System.out.println("---");
//
//        String arrS[] = {"A", "B", "C", "D"};
//        for (String s: arrS) {
//            System.out.println(s);
//        }

        // //declaration, instantiation and initialization
//        int xArr[] = {1,3,7};
//
//        // in mảng bằng foreach
//        for (int i: xArr) {
//            System.out.println(i);
//        }

//        int yArr[] = {2, 4, 6};
//        System.out.println("Độ dài của yArr = " + yArr.length);
//        System.out.println(yArr[0]);
//        System.out.println(yArr[1]);
//        System.out.println(yArr[2]);
//        // dòng này bị lỗi ArrayIndexOutOfBoundsException do mảng chỉ có 3 phần tử và index = 3 là không tồn tại.
//        System.out.println(yArr[3]);


//        // ================ Multidimensional Array in Java ================

//        int[][] xArr = new int[3][3]; // 3 = row and 3 = column
//
//        xArr[0][0] = 1;
//        xArr[0][1] = 2;
//        xArr[0][2] = 3;
//
//        xArr[1][0] = 4;
//        xArr[1][1] = 5;
//        xArr[1][2] = 6;
//
//        xArr[2][0] = 7;
//        xArr[2][1] = 8;
//        xArr[2][2] = 9;
//
//        System.out.println("--- arrX ---");
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(xArr[i][j]);
//            }
//            System.out.println();
//        }
//
//        int[][] yArr = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
//        System.out.println("--- arrY ---");
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(yArr[i][j]);
//            }
//            System.out.println();
//        }

//        // Mảng 2 chiều
//        int arr[][] = new int[3][];
//        arr[0] = new int[3];
//        arr[1] = new int[4];
//        arr[2] = new int[2];
//
//        // Tạo mảng răng cưa
//        int count = 0;
//        for (int i=0; i<arr.length; i++)
//            for(int j=0; j<arr[i].length; j++)
//                arr[i][j] = count++;
//
//        // printing the data of a jagged array
//        for (int i=0; i<arr.length; i++){
//            for (int j=0; j<arr[i].length; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();//new line
//        }


//        // Clone array
//        System.out.println("--- zArr ---");
//        int[] zArr = yArr[0].clone();
//        for (int i: zArr) {
//            System.out.println(i);
//        }


        char[] fromArr = {'T', 'a', 'y', 'J', 'a', 'v', 'a'};
        char[] toArr = new char[4];

        // copy Java từ fromArr tới toArr
        System.arraycopy(fromArr, 3, toArr, 0, 4);

        System.out.println(String.copyValueOf(toArr));


        // === Java String ==
        //char[] ch = {'T', 'a', 'y', 'J', 'a', 'v', 'a'};

//        String s = new String("");
//
//        if (s.isEmpty()){
//            System.out.println("rong");
//        }

    }
}
