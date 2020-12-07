package ge.lanmaster.patterns.creational.ObjectPool;

import java.lang.reflect.Array;

public class ObjectPoolImplementation implements ObjectPool {
	private int size;

	/**
	 * This array contains the objects that are waiting to be
	 * reused. It is managed as a stack.
	 */
	private Object[] pool;

	/**
	 * Internal operations are synchronized on this object.
	 */
	private Object lockObject = new Object();
	private Creation creator;
	private int instanceCount;
	private int maxInstances;

	/**
	 * Constructor
	 *
	 * @param poolClass    The Class to instantiate to create Pool Objects.
	 * @param creator      The object that the pool will delegate the responsibility
	 *                     for creating objects that it will manage.
	 * @param capacity     The number of currently unused objects that this
	 *                     object pool may contain at once.
	 * @param maxInstances The maximum number of instances of the poolClass
	 *                     class that the pool should allow to exist at one
	 *                     time.
	 */
	public ObjectPoolImplementation(Class poolClass, Creation creator, int capacity, int maxInstances) {
		size = 0;
		this.creator = creator;
		this.maxInstances = maxInstances;
		pool = (Object[]) Array.newInstance(poolClass, capacity);
	}

	/**
	 * Return the number of objects in the pool that are
	 * awaiting reuse.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Return the maximum number of objects that may be in the
	 * pool awaiting reuse.w
	 */
	public int getCapacity() {
		return pool.length;
	}

	/**
	 * Set the maximum number of objects that may be in the
	 * pool awaiting reuse.
	 *
	 * @param newValue The new value for the maximum number of objects
	 *                 that may be in the pool awaiting reuse. This
	 *                 must be greater that zero.
	 */
	public void setCapacity(int newValue) {
		if (newValue <= 0) {
			String msg = "Capacity must be greater than zero:" + newValue;
			throw new IllegalArgumentException(msg);
		}
		synchronized (lockObject) {
			Object[] newPool = new Object[newValue];
			System.arraycopy(pool, 0, newPool, 0, newValue);
			pool = newPool;
		}
	}


	/**
	 * Return an object from the pool. If there is no object in
	 * the pool, one will be created unless the number of
	 * pool-managed objects is greater than or equal to the
	 * value returned by the <code>getMaxInstances</code>
	 * method. If the number of pool-managed objects exceeds
	 * this amount, then this method returns null.
	 */
	public Object getObject() {
		synchronized (lockObject) {
			if (size > 0) {
				return removeObject();
			} else if (getInstanceCount() < getMaxInstances()) {
				return createObject();
			} else {
				return null;
			}
		}
	}


	/**
	 * Return an object from the pool. If there is no object in
	 * the pool, one will be created unless the number of
	 * pool-managed objects is greater than or equial to the
	 * value returned by the <code>getMaxInstances</code>
	 * method. If the number of pool-managed objects exceeds
	 * this amount, then this method will wait until an object
	 * becomes available for reuse.
	 *
	 * @throws InterruptedException If the calling thread is interrupted.
	 */
	public Object waitForObject() throws InterruptedException {
		synchronized (lockObject) {
			if (size > 0) {
				return removeObject();
			} else if (getInstanceCount() < getMaxInstances()) {
				return createObject();
			} else {
				do {
					wait();
				} while (size <= 0);
				return removeObject();
			}
		}
	}

	private Object createObject() {
		System.out.println("createObject called");
		Object newObject = creator.create();
		instanceCount++;
		return newObject;
	}

	/**
	 * Release an object to the Pool for reuse.
	 *
	 * @param obj The object that is available for reuse.
	 * @throws ArrayStoreException  If the given object is not an instance of the
	 *                              class passed to this pool object's constructor.
	 * @throws NullPointerException If the given object is null.
	 */
	public void release(Object obj) {
		// no nulls
		if (obj == null) {
			throw new NullPointerException();
		}
		synchronized (lockObject) {
			if (getSize() < getCapacity()) {
				pool[size] = obj;
				size++;
				// Notify a waiting thread that we have put an
				// object in the pool.
				lockObject.notify();
			}
		}
	}

	/**
	 * Remove an object from the pool array and return it.
	 */
	private Object removeObject() {
		size--;
		return pool[size];
	}

	public int getInstanceCount() {
		return instanceCount;
	}

	public int getMaxInstances() {
		return maxInstances;
	}
}
