package com.codingblocks.lecturetennetconnect;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by championswimmer on 05/07/16.
 */
public class NetFetchTask extends AsyncTask<String, Void, Event> {


    public interface PostExecuteListener {
        public void postExecuteDone(Event ev);
    }

    private PostExecuteListener myListener;

    public NetFetchTask (PostExecuteListener pel) {
        myListener = pel;
    }

    public NetFetchTask (TextView tv) {
    }

    @Override
    protected Event doInBackground(String... params) {
        Event myEv = null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setConnectTimeout(10000);
            urlConn.setReadTimeout(20000);

            urlConn.connect();

            if (urlConn.getResponseCode() == 200) {
                String res = isToString(urlConn.getInputStream());
                myEv = getEventFromResponse(res);
            }

//            InputStream is  = urlConn.getInputStream();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return myEv;
    }

    @Override
    protected void onPostExecute(Event ev) {
        super.onPostExecute(ev);
        myListener.postExecuteDone(ev);
    }


    public String isToString (InputStream is) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line = r.readLine();
        while (line != null && !line.isEmpty()) {
            sb.append(line);
            line = r.readLine();
        }

        return sb.toString();
    }

    public Event getEventFromResponse(String resp) throws JSONException {
        JSONObject jObj = new JSONObject(resp);
        Event event = new Event(
                jObj.getString("name"),
                jObj.getString("location_name"),
                jObj.getString("type"),
                jObj.getString("topic")
        );

        // ==========================

//        JSONArray jArr = new JSONArray(resp);
//        int len = jArr.length();
//        ArrayList<Event> events = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            JSONObject singleObject = jArr.getJSONObject(i);
//            events.add(new Event(
//            ))
//        }

        // ==========================

        return event;
    }
}
