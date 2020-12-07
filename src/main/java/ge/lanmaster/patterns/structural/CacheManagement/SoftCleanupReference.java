package ge.lanmaster.patterns.structural.CacheManagement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftCleanupReference extends SoftReference implements Cleanup {

	private final Cleanup cleanup;

	public SoftCleanupReference(Object obj, ReferenceQueue refQueue, Cleanup cleanup) {
		super(obj, refQueue);
		this.cleanup = cleanup;
	}

	@Override
	public void extricate() {
		this.cleanup.extricate();
	}

}
