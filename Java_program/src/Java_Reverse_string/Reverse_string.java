package Java_Reverse_string;

public class Reverse_string {
	public static void main(String[] args)
	{
		String input="welcome";
		String output="";
		for(int i=input.length()-1;i>=0;i--)
		
			output=output + input.charAt(i);
		    System.out.println(output);
	
}

	
}