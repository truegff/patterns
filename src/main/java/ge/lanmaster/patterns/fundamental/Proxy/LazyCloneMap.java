package ge.lanmaster.patterns.fundamental.Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class LazyCloneMap implements Map, Cloneable {
	private Map underlyingMap;
	private MutableInteger refCount;
	private Method cloneMethod;
	private static Class[] cloneParams = new Class[0];

	public LazyCloneMap(Map underlyingMap) throws NoSuchMethodException, InvocationTargetException {
		Class mapClass = underlyingMap.getClass();
		cloneMethod = mapClass.getMethod("clone", cloneParams);
		try {
			this.underlyingMap = (Map) cloneMethod.invoke(underlyingMap, null);
		} catch (IllegalAccessException e) {
			// todo [AD]
		}
		refCount = new MutableInteger(1);
	}

	public Object clone() {
		LazyCloneMap theClone;
		try {
			Cloneable original = (Cloneable) underlyingMap;
			theClone = (LazyCloneMap) super.clone();
		} catch (CloneNotSupportedException ex) {
			//this should never happen
			theClone = null;
			//todo [AD]
		}
		refCount.setValue(1 + refCount.getValue());
		return theClone;
	}

	private void ensureUnderlyingMapNotShared() {
		if (refCount.getValue() > 1) {
			try {
				underlyingMap = (Map) cloneMethod.invoke(underlyingMap, null);
				refCount.setValue(refCount.getValue() - 1);
				refCount = new MutableInteger(1);
			} catch (IllegalAccessException ex) {
				// This should not happen.
				// todo [AD]
			} catch (InvocationTargetException ex) {
				Throwable cause = ex.getCause();
				throw new RuntimeException("clone failed", cause);
			}
		}
	}

	//metods that do not modify original object
	public int size() {
		return underlyingMap.size();
	}

	public boolean isEmpty() {
		return underlyingMap.isEmpty();
	}

	public boolean containsKey(Object key) {
		return underlyingMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return underlyingMap.containsValue(value);
	}

	public Object get(Object key) {
		return underlyingMap.get(key);
	}

	public Set keySet() {
		return underlyingMap.keySet();
	}

	public Collection values() {
		return underlyingMap.values();
	}

	public Set entrySet() {
		return underlyingMap.entrySet();
	}

	public boolean equals(Object that) {
		return underlyingMap.equals(that);
	}

	public int hashCode() {
		return underlyingMap.hashCode();
	}

	//methods that modify original object
	public Object put(Object key, Object value) {
		ensureUnderlyingMapNotShared();
		return underlyingMap.put(key, value);
	}

	public Object remove(Object key) {
		ensureUnderlyingMapNotShared();
		return underlyingMap.remove(key);
	}

	public void putAll(Map m) {
		ensureUnderlyingMapNotShared();
		underlyingMap.putAll(m);
	}

	public void clear() {
		ensureUnderlyingMapNotShared();
		underlyingMap.clear();
	}

}