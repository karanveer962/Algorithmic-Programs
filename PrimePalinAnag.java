import java.util.*;

class PrimePalinAnag{
    public static void main(String[] args) {
        boolean[] vis=new boolean[1001]; //find prime between 1 and 1000 range
        Arrays.fill(vis,true);
        
        for(int i=2;i<=Math.sqrt(vis.length);i++){
           if(vis[i]==false)            //if non-prime continue
           continue;

           for(int j=i*2;j<vis.length;j+=i){  //changing mutiples of prime number to false
              vis[j]=false;
           }
        }
         
        System.out.println("\nPrime Palindrome numbers between 1 and 1000 are: ");
        List<Integer> list=new ArrayList<>();
        for(int i=2;i<vis.length;i++){    
            if(vis[i]==true && checkPalindrome(i))       // check palindrome 
               list.add(i);
        }

        System.out.println(list);
        System.out.println("\nPrime Palindrome numbers that are also Anagrams: ");
        findAnagrams(list);
    }
    public static boolean checkPalindrome(int num){
       String str= String.valueOf(num);
        int low=0,high=str.length()-1;
        while(low<high){    //checking palindrome condition 
            if(str.charAt(low)!=str.charAt(high))
               return false;
               low++;
               high--;
        }
        return true;
    }
    public static void findAnagrams(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {  //validating every two numbers for anagram check
            for (int j = i + 1; j < list.size(); j++) {
                if (areAnagrams(list.get(i), list.get(j))) {
                    System.out.println(list.get(i) + " and " + list.get(j) + " are anagrams.");
                }
            }
        }
    }

    public static boolean areAnagrams(int num1, int num2) {
        char[] arr1 = String.valueOf(num1).toCharArray();
        char[] arr2 = String.valueOf(num2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}