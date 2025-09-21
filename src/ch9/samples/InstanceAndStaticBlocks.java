// Figure 9.18 
package ch9.samples;

class Parent {
	{ 
		System.out.println("6. Parent | instance init block 1"); 
	}
	
	static {
		System.out.println("2. Parent | static init block 1");
	}
	
	Parent() {
		System.out.println("8. Parent | constructor");
	}
	
	{ 
		System.out.println("7. Parent | instance init block 2"); 
	}
	
	static {
		System.out.println("3. Parent | static init block 2");
	}
}

class Child extends Parent {
	{ 
		System.out.println("9. Child | instance init block 1"); 
	}

  static {
		System.out.println("4. Child | static init block 1");
	}
  
	Child() {
    System.out.println("11. Child | constructor");
  }
  
	{ 
		System.out.println("10. Child | instance init block 2"); 
	}
  
	static {
		System.out.println("5. Child | static init block 2\n");
	}
}

public class InstanceAndStaticBlocks {
	static {
		System.out.println("1. InstanceAndStaticBlocks | static init block");
	}

	{
		System.out.println("InstanceAndStaticBlocks | instance init block");
	}

	public static void main(String[] args) {
		System.out.println("---> creating Child object #1");
		new Child();

		System.out.println("\n---> creating Child object #2");
		new Child();
	}
}
