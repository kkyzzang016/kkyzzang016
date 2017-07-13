package generic;

public class Util {
	
	public static <T extends Number> int compare(T t1, T t2) {
		
		double v1 = t1.doubleValue(); //Number Class의 doubleValue()
		System.out.println(t1.getClass().getName()); //Class Class의 getClass(), getName()
		
		double v2 = t2.doubleValue();
		System.out.println(t2.getClass().getName()); //Class Class의 getClass(), getName()
		return Double.compare(v1, v2);
		
	}
	
	/*
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	*/
	/*
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}
	*/
}
