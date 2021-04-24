package POC.restPractice.services;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
// --- <<IS-END-IMPORTS>> ---

public final class javaServices

{
	// ---( internal utility methods )---

	final static javaServices _instance = new javaServices();

	static javaServices _newInstance() { return new javaServices(); }

	static javaServices _cast(Object o) { return (javaServices)o; }

	// ---( server methods )---




	public static final void JsYamlToJson (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(JsYamlToJson)>> ---
		// @sigtype java 3.5
		// [i] field:0:required configPath
		// [o] field:0:required convertedJson
		String configPath;
		
		IDataCursor cursor1= pipeline.getCursor();
		configPath=IDataUtil.getString(cursor1,"configPath");
		ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
		Object obj; 
		try {
			obj = yamlReader.readValue(new File(configPath), Object.class);
			ObjectMapper jsonWriter = new ObjectMapper(); 
			String jsonString;
			jsonString = jsonWriter.writeValueAsString(obj);
			IDataUtil.put(cursor1, "convertedJson", jsonString);
			cursor1.destroy();    
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// --- <<IS-END>> ---

                
	}



	public static final void Test (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(Test)>> ---
		// @sigtype java 3.5
		// [i] field:0:required key
		// [o] object:0:required output
		IDataCursor pipelineCursor = pipeline.getCursor();
		String key = IDataUtil.getString( pipelineCursor, "key" );
		Object obj = key;
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "output", obj );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void getApiDetails (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getApiDetails)>> ---
		// @sigtype java 3.5
		// [o] object:0:required hashtableData
		try {
			IDataCursor cursor = pipeline.getCursor();	
			FileReader reader=new FileReader("/home/ameya/Documents/POC/source/apitest.properties");
			Properties properties = new Properties();
			properties.load(reader);
			IDataUtil.put(cursor, "hashtableData", properties);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
			
		// --- <<IS-END>> ---

                
	}
}

