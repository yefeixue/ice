
package Demo;

import org.apache.log4j.Logger;

import Ice.Current;

/**
 * ice  java  server 业务实现类
 * @author peidw
 *
 */
public class PrinterImpl extends _PrinterDisp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4526797879081429219L;
	private static Logger logger=Logger.getLogger("");
	 
	@Override
	public void printString(String s, Current __current) {
		// TODO Auto-generated method stub
		System.out.println("-----------------"+s);
		logger.info("收到请求:"+s);
	}
	
}

