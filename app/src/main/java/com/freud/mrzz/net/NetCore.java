package com.freud.mrzz.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class NetCore
{

    public static final String ServerAddr = "http://211.87.226.133:8088/floyid/clothes/";
    public static final String URL_HEAD = "http://211.87.226.133:8088/floyid/";

    private final String LoginAddr = ServerAddr + "login";
    private final String get_cloth_category_one_addr = ServerAddr + "get_cloth_category_one.php";




    public String Login(String parentCellphone, String parentPassword)
    {
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("parentCellphone", parentCellphone));
        params.add(new BasicNameValuePair("parentPassword", parentPassword));
        String result = "";
        try
        {
            result = GetResultFromNet(LoginAddr, params);
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        if(result.equals(""))
            return null;
        System.out.println(result);
        return result;
    }


    public String get_cloth_category_1()
    {
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        String result = "";
        try
        {
            result = GetResultFromNet(get_cloth_category_one_addr, params);
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        if(result.equals(""))
            return null;
        System.out.println(result);
        return result;
    }




    private String GetResultFromNet(String url, List<NameValuePair> params) throws ClientProtocolException, IOException
    {
        HttpPost httpRequest = new HttpPost(url);
        httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
        String jsonData = "";
        if (httpResponse.getStatusLine().getStatusCode() == 200)
        {
            InputStream is = httpResponse.getEntity().getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = br.readLine()) != null)
            {
                jsonData += line + "\r\n";
            }
        }
        // jsonData=new String(jsonData.getBytes(),"gb2312");
        return jsonData.replace("\\","");
    }

    private void sendHttpPost(String url, List<NameValuePair> params){
        HttpPost httpRequest = new HttpPost(url);
        try {
            httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            new DefaultHttpClient().execute(httpRequest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void httpPostMethod(String url, JSONObject json, Handler handler)
            throws UnsupportedEncodingException, IOException,
            ClientProtocolException {

        HttpParams params = new BasicHttpParams();
        //设置连接超时时间
        HttpConnectionParams.setConnectionTimeout(params, 50000);
        HttpClient client = new DefaultHttpClient(params);

        //提交json数据到服务器
        HttpPost request = new HttpPost(url);
        StringEntity se = new StringEntity(json.toString(), "UTF8");
        se.setContentEncoding("UTF-8");
        se.setContentType("application/json");
        request.setEntity(se);
        request.setHeader("json", json.toString());
        HttpResponse response = client.execute(request);

        //获取服务器返回的数据
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){

            String res = EntityUtils.toString(response.getEntity(), "UTF-8");
            Log.d("httpResponse", res);
            Message msg = new Message();
            msg.what = 0;
            Bundle bundle = new Bundle();
            bundle.putString("res", res);
            msg.setData(bundle);
            handler.sendMessage(msg);
        }
    }

    public String UploadAvatatest(String url,String file) throws ClientProtocolException, IOException
    {
        HttpPost httpRequest = new HttpPost(url);
        FileBody fileBody = new FileBody(new File(file));
        MultipartEntity entity = new MultipartEntity();
        entity.addPart("file", fileBody);

        httpRequest.setEntity(entity);
        HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
        String jsonData = "";

        InputStream is = httpResponse.getEntity().getContent();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";
        while ((line = br.readLine()) != null)
        {
            jsonData += line + "\r\n";
        }

        return jsonData;
    }

}
