package greatergoodguy.feature;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import greatergoodguy.http.HttpClient;
import greatergoodguy.http.JeeshHttpResponseHandler;
import greatergoodguy.jeesh.ActivityJeesh;
import greatergoodguy.jeesh.R;
import greatergoodguy.toolbox.TBLogger;

/**
 * Created by xuejianyu on 2/1/16.
 */
public class FeatureStatus extends Feature_Base {

    public FeatureStatus(ActivityJeesh.ActivityJeeshAssistant assistant) {
        super(assistant);

        Button buttonStatus = (Button) getAssistant().findViewById(R.id.activity_jeesh_button_status);
        buttonStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStatusFromServer();
            }
        });
    }

    private void getStatusFromServer() {
        String suggestionsUrl = "https://jeesh-dragonarmy.appspot.com/status";

        HttpClient.GET(getAssistant().getContext(), suggestionsUrl, new JeeshHttpResponseHandler() {

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

                TextView tvInformation = (TextView) getAssistant().findViewById(R.id.activity_jeesh_tv_information);
                tvInformation.setText(response);
            }

            @Override
            public void onFailure_FF(int statusCode, Header[] headers, JSONObject jsonObj, JSONArray jsonArray, String response, Throwable error) {
                TBLogger.log(TAG, "onFailure");
            }
        });
    }

}
