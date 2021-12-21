
 interface Main {
	default void car()
	{
		int a = 10;
		int b=20;
		int c=a+b;
	}
	class Super implements Main{
		
	
	public static void main(String[] args){
		
			Super obj=new Super();
			obj.car();
			System.out.println(obj);
			
	
	}
	}
 }


