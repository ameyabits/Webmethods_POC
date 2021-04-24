package POC.restServiceDemo.services;

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

public final class common

{
	// ---( internal utility methods )---

	final static common _instance = new common();

	static common _newInstance() { return new common(); }

	static common _cast(Object o) { return (common)o; }

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
}

