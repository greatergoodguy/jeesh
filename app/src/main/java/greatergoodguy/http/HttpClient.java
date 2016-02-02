package greatergoodguy.http;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by xuejianyu on 2/1/16.
 */
public class HttpClient {
    protected final String TAG = getClass().getSimpleName();

    public static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    public static void GET(Context context, String url, AsyncHttpResponseHandler responseHandler) {
        asyncHttpClient.get(context, url, responseHandler);
    }

    public static void GET(Context context, String url, RequestParams requestParams, AsyncHttpResponseHandler responseHandler) {
        asyncHttpClient.get(context, url, requestParams, responseHandler);
    }
}
