import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HitBlow  hb = new HitBlow();
		hb.start();
	}

}

class HitBlow {
	int input;
	int cntHit;
	int cntBlow;
	String str[];
	String answer[];
	boolean hit[];
	Random ran;
	Scanner scan;
	final int max_digit = 3;
	
	public HitBlow(){
		hit = new boolean[max_digit];
		answer = new String[max_digit];
		setAnswer();	//答えの数値を生成
	}
	
	public void start(){
		for(int n=0;n<3;n++){
			countReset();
			//3桁入力
			while(true){
				System.out.print("3桁の数値を入力してください。\n>");
				try{
					scan = new Scanner(System.in);
					input = scan.nextInt();
				}catch(InputMismatchException e){
					System.out.println("数値以外の入力はできません。");
					continue;
				}
				str = String.valueOf(input).split("");
				if(str.length != max_digit){
					System.out.println("数値が3桁ではありません。");
				}else if(!check(str)){
					System.out.println("1桁ごとの数値をは、重複しないように入力してください。");
					continue;
				}else{
					break;
				}
			}
			//Hit判定
			for(int i=0;i<max_digit;i++){
				if(answer[i].equals(str[i])){
					hit[i] = true;
					cntHit++;
					continue;
				}
				//Blow判定
				for(int j=0;j<max_digit;j++){
					if(hit[j] == false && answer[i].equals(str[j])){
						cntBlow++;
						break;
					}
				}
			}
			if(cntHit == 3){
				System.out.println("正解です。");
				break;
			}
			System.out.println("Hit=" + cntHit +" Blow=" + cntBlow);
		}
		System.out.println("不正解です。");
		scan.close();
	}
	
	public void setAnswer(){
		ran = new Random();
		while(true){
			for(int i=0;i<answer.length;i++){
				answer[i] = String.valueOf(ran.nextInt(9)+1);
			}
			if(check(answer)){
				break;
			}
		}
	}
	
	public void countReset(){
		cntHit = 0;
		cntBlow = 0;
		for(int c=0;c<max_digit;c++){
			hit[c] = false;
		}
	}
	
	public boolean check(String[] val){
		if(!val[0].equals(val[1]) && !val[0].equals(val[2]) && !val[1].equals(val[2])){
			return true;
		}else{
			return false;
		}
	}
}
