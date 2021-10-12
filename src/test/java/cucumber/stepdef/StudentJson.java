package cucumber.stepdef;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class StudentJson {

    public static String getTestData(Map<Object,Object> studentInputs){
        JSONObject json = new JSONObject();
        StringEntity se=null;
        try {
            for (Map.Entry<Object, Object> entry : studentInputs.entrySet()) {
                if( entry.getKey()=="id"){
                    json.put((String) entry.getKey(),(int)entry.getValue());
                }
                Thread.sleep(1000);
                json.put((String) entry.getKey(),entry.getValue());
            }
        }catch(JSONException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }return json.toString();
    }

}
