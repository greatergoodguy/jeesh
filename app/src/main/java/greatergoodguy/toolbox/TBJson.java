package greatergoodguy.toolbox;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xuejianyu on 1/24/16.
 */
public class TBJson {

    public static JSONObject getJSONObject(JSONArray jsonArray, int index) {
        JSONObject result = new JSONObject();

        try {
            result = jsonArray.getJSONObject(index);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getString(JSONObject jsonObj, String key) {
        String result = "";

        if(jsonObj.has(key) && !jsonObj.isNull(key)) {
            try {
                result = jsonObj.getString(key);}
            catch (JSONException e) {
                e.printStackTrace();}
        }

        return result;
    }
}
