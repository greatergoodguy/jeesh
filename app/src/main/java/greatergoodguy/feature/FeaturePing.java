package greatergoodguy.feature;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListPopupWindow;

import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import greatergoodguy.http.HttpClient;
import greatergoodguy.http.JeeshHttpResponseHandler;
import greatergoodguy.jeesh.ActivityJeesh;
import greatergoodguy.jeesh.R;
import greatergoodguy.toolbox.TBAndroid;
import greatergoodguy.toolbox.TBLogger;
import greatergoodguy.toolbox.TBToaster;

/**
 * Created by xuejianyu on 2/1/16.
 */
public class FeaturePing extends Feature_Base {

    public FeaturePing(ActivityJeesh.ActivityJeeshAssistant assistant) {
        super(assistant);


        FloatingActionButton fab = (FloatingActionButton) getAssistant().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suggestionsUrl = "https://jeesh-dragonarmy.appspot.com/ping";

                RequestParams requestParams = new RequestParams();
                requestParams.put("secure_id", TBAndroid.getSecureId(getAssistant().getContext()));

                HttpClient.GET(getAssistant().getContext(), suggestionsUrl, requestParams, new JeeshHttpResponseHandler() {

                    @Override
                    public void onStart_FF() {
                        TBLogger.log(TAG, "onStart");
                    }

                    @Override
                    public void onFinish_FF() {
                        TBLogger.log(TAG, "onFinish");
                    }

                    @Override
                    public void onSuccess_FF(int statusCode, Header[] headers, JSONObject jsonObj, JSONArray jsonArray, String response) {
                        TBLogger.log(TAG, "onSuccess: " + response);
                        TBToaster.showToast(getAssistant().getContext(), response);
                    }

                    @Override
                    public void onFailure_FF(int statusCode, Header[] headers, JSONObject jsonObj, JSONArray jsonArray, String response, Throwable error) {
                        TBLogger.log(TAG, "onFailure");
                    }
                });
            }
        });
    }

}
