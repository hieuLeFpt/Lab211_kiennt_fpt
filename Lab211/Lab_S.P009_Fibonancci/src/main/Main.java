package main;

public class Main {

    
// đệ quy
//    public static int Fibonancci(int n, int lower, int higher, int position) {
//        System.out.print(higher + " ");
//        System.out.println("index " + position);
//        if (n < 2) {
//            return higher;
//        }
//        return Fibonancci(n - 1, higher, lower + higher, position + 1);
//    }
    
// dùng vòng lặp
//    public static void Fibonancci(int maxNumber) {
//        int previuosNumber = 0, nextNumber = 1;
//        System.out.println("Fibonancci series of " + maxNumber + " numbers: ");
//        int i = 1;
//        while (i < maxNumber) {
//            System.out.print(previuosNumber + " ");
//            int sum = previuosNumber + nextNumber;
//            previuosNumber = nextNumber;
//            nextNumber = sum;
//            i++;
//        }
//    }
    // pre = 0, next = 1, out 0, sum = 1, pre = 1, next = 1
    // out 1, sum = 2, pre = 1, next = 2, out 1, sum = 3, pre = 2. next 3, out 2 , sum = 5, pre = 3. next = 5
    //
    public static void writeFiboArray(int[] array, int count) {
        while (count <= 1) {
            array[count] = count;
            count++;
        }
        if (count > 1) {
            array[count] = array[count - 1] + array[count - 2];
            count++;
            if (count < array.length) {
                writeFiboArray(array, count);
            }
        }
    }

    public static int[] findFibo(int sizeArray) {
        int[] array = new int[sizeArray];
        writeFiboArray(array, 0);
        return array;
    }

    public static void displayArray(int[] array) {
        System.out.println("The 45 sequence fibonancci: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                System.out.println();
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        // Fibonancci(45, 1, 0, 0);
        int array[] = findFibo(45);
        displayArray(array);
    }

}
