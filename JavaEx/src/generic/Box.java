package generic;

public class Box<T> { 
	private T t;
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t= t;
	}
	
/* 비제너릭 타입 예제
	private Object object;

	public void set(Object object) {
		this.object = object;
	}

	public Object get() {
		return object;
	}
	*/
}
