import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;


class Demo {
	public static void main(String[] args) {
		System.out.println("Proxy pattern");
		HashMap m1 = new HashMap();
		try {
			LazyCloneMap map1 = new LazyCloneMap(m1);
			LazyCloneMap map2 = (LazyCloneMap)map1.clone();
		} catch (Exception e) {
		}
	}
}
class LazyCloneMap implements Map, Cloneable {
	private Map underlyingMap;
	private MutableInteger refCount;
	private Method cloneMethod;
	private static Class[] cloneParams = new Class[0];
	
	public LazyCloneMap(Map underlyingMap) 
	throws NoSuchMethodException, InvocationTargetException 
	{
		Class mapClass = underlyingMap.getClass();
		cloneMethod = mapClass.getMethod("clone", cloneParams);
		try {
			this.underlyingMap = 
			(Map) underlyingMap.invoke(underlyingMap, null);
		} 
		catch (IllegalAccessException e) {
			//		
		}
		refCount = new MutableInteger(1);
	} // constructor(Map)
	public Object clone() {
		LazyCloneMap theClone;
		try {
			Cloneable original = (Cloneable) underlyingMap;
			theClone = (LazyCloneMap)super.clone();
		} catch (CloneNotSupportedException e) {
			//this should never happen
			theClone = null;
		} // try
		refCount.setValue(1+refCount.getValue());
		return theClone;
	}
	private void ensureUnderlyingMapNotShared() { 
		if (refCount.getValue()>1) { 
			try { 
				underlyingMap =
				(Map)cloneMethod.invoke(underlyingMap, null);
				refCount.setValue(refCount.getValue()-1);
				refCount = new MutableInteger(1);
			}  catch (IllegalAccessException e) { 
				// This should not happen.
			}  catch (InvocationTargetException e) { 
				Throwable cause = e.getCause();
				throw new RuntimeException("clone failed",
					cause);
			}  // try
		}  // if
	} // ensureUnderlyingMapNotShared()
	
	//metods that do not modify original object
	public int size(){ 
		return underlyingMap.size();
	} 
	public boolean isEmpty(){ 
		return underlyingMap.isEmpty();
	} 
	public boolean containsKey(Object key){ 
		return underlyingMap.containsKey(key);
	} 
	public boolean containsValue(Object value){ 
		return underlyingMap.containsValue(value);
	} 
	public Object get(Object key){ 
		return underlyingMap.get(key);
	}
	public Set keySet(){ 
		return underlyingMap.keySet();
	} 
	public Collection values(){ 
		return underlyingMap.values();
	} 
	public Set entrySet(){ 
		return underlyingMap.entrySet();
	} 
	public boolean equals(Object that){ 
		return underlyingMap.equals(that);
	} 
	public int hashCode(){ 
		return underlyingMap.hashCode();
	} 
	
	//methods that modify original object
	public Object put(Object key, Object value){ 
		ensureUnderlyingMapNotShared();
		return underlyingMap.put(key, value);
	} 
	public Object remove(Object key){ 
		ensureUnderlyingMapNotShared();
		return underlyingMap.remove(key);
	} 
	public void putAll(Map m){ 
		ensureUnderlyingMapNotShared();
		underlyingMap.putAll(m);
	} 
	public void clear(){ 
		ensureUnderlyingMapNotShared();
		underlyingMap.clear();
	} 
	
}
class MutableInteger {
	public int val;
	public MutableInteger( int value ) { 
		setValue( value );
	} 
	public int getValue() { 
		return( val );
	} 
	public void setValue( int value ) { 
		val = value;
	} 
}