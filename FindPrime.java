import java.util.*;

class FindPrime{
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
         
        System.out.println("Prime numbers between 1 and 1000 are: ");
        for(int i=2;i<vis.length;i++){    
            if(vis[i]==true)       // selecting only prime numbers
            System.out.print(i+" ");
        }
    }
}