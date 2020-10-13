package com.example.my0702;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoginMain1_SQL {
    public static String executeQuery1(String account,String h,String kg,String body,String body1,String body2,String body3,String body4,String body5,String body6,String body7,String body8,String body9) {
        String result = "";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://172.17.135.98/LoginMain_SQL_INSERT.php");
            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("account", account));
            params.add(new BasicNameValuePair("h", h));
            params.add(new BasicNameValuePair("kg", kg));
            params.add(new BasicNameValuePair("body", body));
            params.add(new BasicNameValuePair("body1", body1));
            params.add(new BasicNameValuePair("body2", body2));
            params.add(new BasicNameValuePair("body3", body3));
            params.add(new BasicNameValuePair("body4", body4));
            params.add(new BasicNameValuePair("body5", body5));
            params.add(new BasicNameValuePair("body6", body6));
            params.add(new BasicNameValuePair("body7", body7));
            params.add(new BasicNameValuePair("body8", body8));
            params.add(new BasicNameValuePair("body9", body9));
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            result= EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
            //view_account.setText(httpResponse.getStatusLine().toString());
            HttpEntity httpEntity = httpResponse.getEntity();
            InputStream inputStream = httpEntity.getContent();
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            StringBuilder builder = new StringBuilder();
            String line = null;
            while((line = bufReader.readLine()) != null) {
                builder.append(line + "\n");
            }
            inputStream.close();
            result = builder.toString();
        } catch(Exception e) {
            // Log.e("log_tag", e.toString());
        }
        return result;
    }
}
