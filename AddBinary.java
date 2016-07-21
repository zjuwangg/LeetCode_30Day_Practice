public class AddBinary{
	/**
	*	My not so elegent algorithm 
	*/
	public static String addBinaryString(String a,String b){
		//System.out.println(a + '+' + b);
		int carry = 0;
		String result = "";
		if(a.length() < b.length()){
			String tmp = a;
			a = b;
			b = tmp;
		}
		int aLen = a.length();
		int bLen = b.length();
		for(int i = 1;i <= bLen;i++){
			int a_index = aLen - i;
			int b_index = bLen - i;
			int t_a = (int)(a.charAt(a_index) - '0');
			int t_b = (int)(b.charAt(b_index) - '0');
			int t_sum = t_a + t_b + carry;
			carry = t_sum/2;
			result = ""+t_sum%2+result;
		}
		for(int i = bLen + 1;i <= aLen;i++){
			int index = aLen - i;
			int t_a = (int)(a.charAt(index) - '0');
			int t_sum = t_a + carry;
			carry = t_sum/2;
			result = ""+t_sum%2+result;
		}
		if(carry==1)
			result = carry + result;
		return result;

	}
	/**
	*	elegent algorithm posted on the Discuss.Just 13 line
	*/
	public static Sring solution(String a,String b){
		int aLen = a.length();
		int bLen = b.length();
		String res = "";
		int i = 0,carry =  0;
		while(i < aLen || i < bLen || carry != 0){
			int t_a = (i < aLen)?(int)(a.charAt(aLen - 1 -i) - '0'):0;
			int t_b = (i < bLen)?(int)(b.charAt(bLen - 1 -i) - '0'):0;
			res = (t_a + t_b + carry)%2 + res ;
			carry = (t_a + t_b + carry)/2;
			i ++;
		}
		return res;
	}
	public static void Test(){
		System.out.println(addBinaryString("1","0"));
		System.out.println(addBinaryString("11","1"));

	}	
	public static void main(String[] args) {
		Test();
	}
}