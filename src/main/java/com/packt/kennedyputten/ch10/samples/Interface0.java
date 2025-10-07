// Figure 10.1 
package ch10.samples;

public interface Interface0 {
	public abstract void demo0();

	// "public abstract" by default
	void demo1();
	
	private void demo2(){};

	// only public, private, abstract, default, static and strictfp are permitted
	// protected void demo3();
}
