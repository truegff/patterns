package ge.lanmaster.patterns.structural.CacheManagement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * The class encapsulates a ReferenceQueue. It ensures
 * that the only kind of Reference objects that will be
 * enqueued to the ReferenceQueue are SoftCleanupReference
 * objects. It also encapsulates logic to tell CleanupIF
 * objects enqueued to the ReferenceQueue to remove
 * themselves from whatever data structure they are part of.
 */
public class CleanupQueue {

	/**
	 * The ReferenceQueue encapsulated by this object.
	 */
	private ReferenceQueue refQueue = new ReferenceQueue();

	/**
	 * This is true while a call to cleanup is pending.
	 */
	private boolean cleaning;

	/**
	 * Return a soft reference registered to be enqueued to
	 * the reference queue encapulated by this object.
	 *
	 * @param obj     The object that the reference will refer to.
	 * @param cleanup The CleanupIF object whose extricate method is
	 *                to be called after the soft reference is
	 *                enqueued.
	 */
	public SoftReference createSoftReference(Object obj, Cleanup cleanup) {
		return new SoftCleanupReference(obj, refQueue, cleanup);
	}

	/**
	 * Call the extricate method of all enqueued CleanupIF
	 * objects. If there is currently a call in progress,
	 * then just return.
	 */
	public void cleanup() {
		synchronized (this) {
			if (cleaning) {
				return;
			}
			cleaning = true;
		}
		try {
			while (refQueue.poll() != null) {
				SoftCleanupReference r;
				r = (SoftCleanupReference) refQueue.remove();
				r.extricate();
			}
		} catch (InterruptedException ex) {
			//todo [AD]
		} finally {
			cleaning = false;
		}
	}
}
