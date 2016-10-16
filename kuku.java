
public class kuku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<10;i++){
			for(int j=1;j<10;j++){
				if(j >= 2 && i*j < 10){
					System.out.print(" ");
				}
				System.out.print(" "+ i*j + "|");
			}
			System.out.println();
		}
	}

}
