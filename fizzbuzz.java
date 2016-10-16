import java.util.Scanner;
import java.util.InputMismatchException;

public class fizzbuzz {
/*
1から順番に数を表示する
3の倍数のときにFizzと出力
5の倍数のときにBuzzと出力
3と5の公倍数のときはFizzBuzzと出力
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int digit = 0;
		while(true){
			System.out.println("数値を入力してください。");
			try{
				Scanner scan = new Scanner(System.in);
				digit = scan.nextInt();
			}catch(InputMismatchException e){
				System.out.println("数値以外は入力できません。");
				continue;
			}
			break;
		}
		for(int i=1;i<=digit;i++){
			if(i%3 == 0 && i%5 == 0){
				System.out.println("FizzBuzz");
			}else if(i%3 == 0){
				System.out.println("Fizz");
			}else if(i%5 == 0){
				System.out.println("Buzz");
			}else{
				System.out.println(i);
			}
		}
	}

}