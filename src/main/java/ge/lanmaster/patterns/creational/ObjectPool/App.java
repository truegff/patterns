package ge.lanmaster.patterns.creational.ObjectPool;

public class App {
	public static void main(String[] args) {
		System.out.println("ObjectPool Pattern");

		ObjectPoolImplementation op;
		op = new ObjectPoolImplementation(Object.class,
				new Creator(),
				5,
				5
		);

		diagnose(op);

		Object obj1 = op.getObject();
		Object obj2 = op.getObject();
		Object obj3 = op.getObject();
		Object obj4 = op.getObject();
		Object obj5 = null;// = op.getObject();
		Object obj6 = op.getObject();

		checkNull(obj1, obj2, obj3, obj4, obj5, obj6);

		diagnose(op);
		op.release(obj1);
		diagnose(op);
		checkNull(obj1, obj2, obj3, obj4, obj5, obj6);

		obj6 = op.getObject();

		diagnose(op);
		checkNull(obj1, obj2, obj3, obj4, obj5, obj6);

/*        op.release(obj2);
        diagnose(op);
        op.release(obj3);
        diagnose(op);
        op.release(obj4);
        diagnose(op);
        op.release(obj5);
        diagnose(op);
        op.release(obj6);
        diagnose(op);*/
	}

	public static void diagnose(ObjectPoolImplementation op) {
		System.out.println();
		System.out.println("*** Diagnostic ***");
//        System.out.print("op.getCapacity() ");
//        System.out.println(op.getCapacity());

		System.out.print("op.getInstanceCount() ");
		System.out.println(op.getInstanceCount());

//        System.out.print("op.getMaxInstances() ");
//        System.out.println(op.getMaxInstances());
//
		System.out.print("op.getSize() ");
		System.out.println(op.getSize());
	}

	public static void checkNull(Object... obj) {
		for (int i = 0; i < obj.length; i++) {
			Object o = obj[i];
			if (o == null) {
				System.out.print("0");
			} else {
				System.out.print("1");
			}
		}
		System.out.println();
	}
}
