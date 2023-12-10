import java.util.*;

class StringPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.next(); // string input

        // print recursiveley
        recursivePerm(str);
        // printing iteratively
        iterativePerm(str);
    }

    private static void recursivePerm(String str) {
        System.out.println("Recursive Output: ");
        boolean[] vis = new boolean[str.length()];
        permutation(str.toCharArray(), "", vis);

    }

    public static void permutation(char[] arr, String psf, boolean[] vis) {
        if (psf.length() == arr.length) {
            System.out.println(psf);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (vis[i] == false) {
                vis[i] = true;
                permutation(arr, psf + "" + arr[i], vis);
                vis[i] = false;
            }
        }
    }

    public static void iterativePerm(String str) {
        System.out.println("Iterative Output: ");
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        displayArray(arr);
        int n = findFactorial(str.length());
        for (int i = 2; i <= n; i++) {
            nextPermutation(arr);
            displayArray(arr);

        }
    }

    public static void displayArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static int findFactorial(int num) {
        long temp = 1;
        while (num >= 1) {
            temp *= num;
            num--;
        }
        return (int) temp;
    }

    public static void nextPermutation(char[] arr) {
        int n = arr.length - 1, p = -1, pv = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                p = i;
                pv = arr[i];
                break;
            }
        }

        if (p == -1) {
            reverse(arr, 0, n);
            return;
        }

        for (int i = n; i >= 0; i--) {
            if (arr[i] > pv) {
                swap(arr, p, i);
                break;
            }
        }

        reverse(arr, p + 1, n);
    }

    static void reverse(char[] arr, int s, int e) {
        while (s < e) {
            swap(arr, s, e);
            s++;
            e--;
        }
    }

    public static void swap(char[] arr, int s, int e) {
        char t = arr[s];
        arr[s] = arr[e];
        arr[e] = t;
    }

}