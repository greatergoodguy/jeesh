package greatergoodguy.http;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import greatergoodguy.toolbox.TBMock;

/**
 * Created by xuejianyu on 2/1/16.
 */
public abstract class JeeshHttpResponseHandler extends JsonHttpResponseHandler {

    public abstract void onStart_FF();
    public abstract void onFinish_FF();

    public abstract void onSuccess_FF(int statusCode, Header[] headers, JSONObject jsonObj, JSONArray jsonArray, String response);
    public abstract void onFailure_FF(int statusCode, Header[] headers, JSONObject jsonObj, JSONArray jsonArray, String response, Throwable error);

    // ==================
    // Parent Methods
    // ==================
    @Override public void onStart() {
        onStart_FF();}

    @Override public void onFinish() {}

    @Override public void onSuccess(int statusCode, Header[] headers, String response) {
        onSuccess_FF(statusCode, headers, TBMock.jsonObject, TBMock.jsonArray, response);
        onFinish_FF();}

    @Override public void onSuccess(int statusCode, Header[] headers, JSONObject jsonObj) {
        onSuccess_FF(statusCode, headers, jsonObj, TBMock.jsonArray, TBMock.string);
        onFinish_FF();}

    @Override public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
        onSuccess_FF(statusCode, headers, TBMock.jsonObject, jsonArray, TBMock.string);
        onFinish_FF();}

    @Override public void onFailure(int statusCode, Header[] headers, String responseString, Throwable error) {
        onFailureRedirecter(statusCode, headers, error, responseString, TBMock.jsonObject, TBMock.jsonArray);
    }

    @Override public void onFailure(int statusCode, Header[] headers, Throwable error, JSONObject jsonObj) {
        onFailureRedirecter(statusCode, headers, error, TBMock.string, jsonObj, TBMock.jsonArray);
    }

    @Override public void onFailure(int statusCode, Header[] headers, Throwable error, JSONArray jsonArray) {
        onFailureRedirecter(statusCode, headers, error, TBMock.string, TBMock.jsonObject, jsonArray);
    }

    private void onFailureRedirecter(int statusCode, Header[] headers, Throwable error, String responseString, JSONObject responseJsonObj, JSONArray responseJsonArray) {
        if(statusCode == 200 || statusCode == 201) {
            onSuccess_FF(statusCode, headers, responseJsonObj, responseJsonArray, responseString);
        }
        else {
            onFailure_FF(statusCode, headers, responseJsonObj, responseJsonArray, responseString, error);
        }

        onFinish_FF();
    }
}
