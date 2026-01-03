// package frame_sorting;

// import java.util.*;

// class fsorting1 {

//     // Frame class
//     static class Frame {
//         int fnum;        // frame number
//         String content;  // frame content

//         Frame(int n, String c) {
//             fnum = n;
//             content = c;
//         }
//     }

//     // Bubble sort function
//     public static void sorting(int n, Frame[] F) {

//         for (int i = 0; i < n - 1; i++) {
//             for (int j = 0; j < n - i - 1; j++) {

//                 if (F[j].fnum > F[j + 1].fnum) {

//                     // swap frame numbers (temp method)
//                     int temp = F[j].fnum;
//                     F[j].fnum = F[j + 1].fnum;
//                     F[j + 1].fnum = temp;

//                     // swap frame contents
//                     String tempContent = F[j].content;
//                     F[j].content = F[j + 1].content;
//                     F[j + 1].content = tempContent;
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter the number of frames: ");
//         int n = sc.nextInt();

//         Frame[] F = new Frame[n];

//         // Input frame details
//         System.out.println("\nEnter frame details:");
//         for (int i = 0; i < n; i++) {
//             System.out.print("Frame number: ");
//             int num = sc.nextInt();

//             System.out.print("Frame content: ");
//             String cont = sc.next();

//             F[i] = new Frame(num, cont);
//         }

//         // Shuffle frames to simulate out-of-order arrival
//         List<Frame> list = new ArrayList<>(Arrays.asList(F));
//         Collections.shuffle(list);
//         F = list.toArray(new Frame[0]);

//         // Display before sorting
//         System.out.println("\nBefore Sorting (Shuffled Frames):");
//         for (int i = 0; i < n; i++) {
//             System.out.print(F[i].content + " ");
//         }

//         // Sort frames
//         sorting(n, F);

//         // Display after sorting
//         System.out.println("\n\nAfter Sorting Frames:");
//         for (int i = 0; i < n; i++) {
//             System.out.print(F[i].content + " ");
//         }

//         sc.close();
//     }
// }
