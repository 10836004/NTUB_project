package com.example.my0702;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
//註冊帳號
public class BackgroundWorker  extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker(Context ctx){
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url ="https://ntub.dewei.dev/SQLite_insert.php";
        if (type.equals("SQLite_insert")){
        try {
            String mmm1 = params[1];
            String mmm2 = params[2];
            String mm1 = params[3];
            String a11 = params[4];
            String mm3 = params[5];
            String mm4 = params[6];
            String Spinner = params[7];
            String mm6 = params[8];
            String a12 = params[9];
            String mm8 = params[10];
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String post_data =
                    URLEncoder.encode("mmm1" ,"UTF-8")+"="+URLEncoder.encode(mmm1 ,"UTF-8")+"&"+
                    URLEncoder.encode("mmm2" ,"UTF-8")+"="+URLEncoder.encode(mmm2 ,"UTF-8")+"&"+
                    URLEncoder.encode("mm1" ,"UTF-8")+"="+URLEncoder.encode(mm1 ,"UTF-8")+"&"+
                    URLEncoder.encode("mm2" ,"UTF-8")+"="+URLEncoder.encode(a11 ,"UTF-8")+"&"+
                    URLEncoder.encode("mm3" ,"UTF-8")+"="+URLEncoder.encode(mm3 ,"UTF-8")+"&"+
                    URLEncoder.encode("mm4" ,"UTF-8")+"="+URLEncoder.encode(mm4 ,"UTF-8")+"&"+
                    URLEncoder.encode("Spinner" ,"UTF-8")+"="+URLEncoder.encode(Spinner ,"UTF-8")+"&"+
                    URLEncoder.encode("mm6" ,"UTF-8")+"="+URLEncoder.encode(mm6 ,"UTF-8")+"&"+
                    URLEncoder.encode("mm7" ,"UTF-8")+"="+URLEncoder.encode(a12 ,"UTF-8")+"&"+
                    URLEncoder.encode("mm8" ,"UTF-8")+"="+URLEncoder.encode(mm8 ,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line;
            while( (line = bufferedReader.readLine())!=null){
                result += line ;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }   catch (IOException e){
            e.printStackTrace();
        }
     }
        return null;
    }

    @Override
    protected void onPreExecute(){
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }
    @Override
    protected void onPostExecute(String result){
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

