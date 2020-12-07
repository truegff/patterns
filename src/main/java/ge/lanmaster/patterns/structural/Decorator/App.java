package ge.lanmaster.patterns.structural.Decorator;

public class App {

	public static void main(String[] args) {
		System.out.println("Decorator Pattern");
		DoorControllerWrapperA doorControllerWrapperA =
				new DoorControllerWrapperA(
						new DoorController() {
							@Override
							public void requestOpen(String key) {
								System.out.println("DoorControllerIF<impl>.requestOpen();");
							}

							@Override
							public void close() {
								System.out.println("DoorControllerIF<impl>.close();");
							}
						},
						"camera1",
						new SurveillanceMonitor() {
							@Override
							public void viewNow(String s) {
								System.out.println("SurveillanceMonitorIF<impl>.viewNow()");
							}
						}
				);

		doorControllerWrapperA.requestOpen("asdf");
	}
}
