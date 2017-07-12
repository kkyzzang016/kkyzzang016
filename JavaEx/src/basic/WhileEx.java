package basic;
import java.util.Scanner;

public class WhileEx {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
//        System.out.println("반복 제한 : ");
//        int input = sc.nextInt();
//        
//        int count=0;
//        while(count < input){
//            count++;
//            System.out.println("실행구문 cnt : "+count);
//        }
        
        int cnt=0;
        int sum=0;
        while(cnt<100){
            if(cnt%2!=0) sum+=cnt;
            cnt++;
        }
        System.out.println("100까지의 합은 = "+sum);
    }
}
