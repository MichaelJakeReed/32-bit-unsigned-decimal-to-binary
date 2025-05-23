import java.util.Scanner;


public class binary {
    public static void main(String[] args) {
        //declaration
        Scanner in = new Scanner(System.in);
        int num = -1;
        int remainder;
        int mostSig = 0;
        int leastSig = 0;

        //get num to convert from user
        System.out.println("This is an 31 bit unsigned converter the max number that can be intered is 2,147,483,647");
        System.out.println("Please enter a whole number and a number >= 0:");

        //makes user repeat until a number that works is satisfied
        while (true) {
            if (!in.hasNextInt()) {
                System.out.println("That's not a number or a number > 2,147,483,647. Try again:");
                in.nextLine(); //bad input
            } else {
                num = in.nextInt();
                if (num >= 0 && num <= 2147483647) {
                    break;
                } else {
                    System.out.println("Number must be >= 0 and <= 2,147,483,647. Try again:");
                }
            }
        }

        //max num array will hold in java unsigned
        int[] binaryNum = new int[32];

        int i = 0;
        //turn user num into binary using remainder
        while(num > 0){
            binaryNum[i] = num % 2;
            num = num / 2;
            i++;
        }

        //least sig bit
        for(i = 0; i < binaryNum.length; i++){
            if(binaryNum[i] == 1){
                leastSig = i;
                i = binaryNum.length;
                }
        }
        
        //most sig bit
        for(i = binaryNum.length - 1; i  >=  0; i--){
            if(binaryNum[i] == 1){
                mostSig = i;
                break;
                }
        }
 
        //flip the array to get actuall binary
        for(i = 0; i < binaryNum.length / 2; i++){
            int t = binaryNum[i];
            binaryNum[i] = binaryNum[binaryNum.length - 1 - i];
            binaryNum[binaryNum.length - 1 - i] = t;
        } 

        //print answer
        
        int arrPrint = binaryNum.length;
        for(i = 1; i < arrPrint; i++){
            System.out.print(binaryNum[i]);
        } 
        
        System.out.println("\nLeast significant bit is in the " + leastSig + " place or 2^" + leastSig);
        System.out.println("Most significant bit is in the " + mostSig + " place or 2^" + mostSig);
    }
}


