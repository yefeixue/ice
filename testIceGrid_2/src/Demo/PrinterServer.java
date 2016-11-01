
package Demo;

/**
 * ice 例子 部署 在icegrid 里，运行server类必须继承Ice.Application
 * 
 * @author peidw
 *
 */
public class PrinterServer extends Ice.Application {
	@Override
	public int run(String[] args) {
		System.out.println("~~~~~~~~~~服务器开始启动~~~~~~~~~~~~~");
		if (args.length > 0) {
			System.err.println(appName() + ": too many arguments");
			return 1;
		}

		Ice.ObjectAdapter adapter = communicator().createObjectAdapter("PrinterAdapter");
		Ice.Properties properties = communicator().getProperties();
		Ice.Identity id = communicator().stringToIdentity(properties.getProperty("Identity"));
		System.out.println("Ice.Identity id =" + id.name);
		Ice.Object object = new PrinterImpl();
		adapter.add(object, communicator().stringToIdentity("SimplePrinter"));
		adapter.activate();
		communicator().waitForShutdown();
		return 0;
	}

	static public void main(String[] args) {
		System.out.println("**********服务器启动了***********");
		PrinterServer app = new PrinterServer();
		String conf = "D:\\ice\\demo2\\pserver.cfg";
		int status = app.main("Server", args, conf);
		System.exit(status);
	}
}
