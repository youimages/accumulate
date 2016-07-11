package com.lazite.assist.webservice.request;

import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * 
 * @CopyRight：http://www.netrust.cn/
 *
 * @Description  this webservice client needs 
 * 				'axis.jar','commons-discovery-0.2.jar','wsdl4j-1.5.1.jar','XmlSchema-1.4.7.jar'
 * @Author lazite 
 * @CreateTime 2016年7月11日 上午9:05:50   
 * @ModifyBy lazite 
 * @ModeifyTime 2016年7月11日 上午9:05:50   
 * @ModifyDescription
 * @Version   V1.0
 */
public class Client {
	private ClientParameters cp;
	
	public Client(ClientParameters cp) {
		super();
		this.cp = cp;
	}

	public String clientReturn(){
		String result = null;
		try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new URL(cp.getUrlname()));
            
            call.setOperationName(new QName(cp.getUrlspace(),cp.getMethodname()));//WSDL里面描述的接口名称
            
            for (int i = 0; i <  cp.getObjs().length; i++) {
//				if(cp.getObjs()[i] instanceof String){
//					call.addParameter("arg"+i, org.apache.axis.encoding.XMLType.XSD_STRING,
//	                          javax.xml.rpc.ParameterMode.IN);
//				}else if (cp.getObjs()[i] instanceof String){
					call.addParameter("arg"+i, org.apache.axis.encoding.XMLType.XSD_ANYTYPE,
	                          javax.xml.rpc.ParameterMode.IN);
//				}
			}
            
//            call.addParameter("arg0", org.apache.axis.encoding.XMLType.XSD_STRING,
//                          javax.xml.rpc.ParameterMode.IN);//接口的参数
//            call.addParameter("arg1", org.apache.axis.encoding.XMLType.XSD_STRING,
//                    javax.xml.rpc.ParameterMode.IN);//接口的参数
            
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型  
            
            result = (String)call.invoke(cp.getObjs());

	   } catch (Exception e) {
	         e.printStackTrace();
	   }
		return result;
	}
}
