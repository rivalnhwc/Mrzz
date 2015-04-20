package com.freud.mrzz.net;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class NetCore
{

    public static final String ServerAddr = "http://211.87.226.133:8088/floyid/clothes/";

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

//    private String UploadAvata(String url,String sessionId, String sessionToken, String parentId, String pupilId, String file) throws ClientProtocolException, IOException
//    {
//        HttpPost httpRequest = new HttpPost(url);
//        FileBody fileBody = new FileBody(new File(file));
//        StringBody session_Id = new StringBody(sessionId);
//        StringBody session_Token = new StringBody(sessionToken);
//        StringBody parent_Id = new StringBody(parentId);
//        StringBody pupil_Id = new StringBody(pupilId);
//        MultipartEntity entity = new MultipartEntity();
//        entity.addPart("file", fileBody);
//        entity.addPart("sessionId", session_Id);
//        entity.addPart("sessionToken", session_Token);
//        entity.addPart("parentId", parent_Id);
//        entity.addPart("pupilId", pupil_Id);
//
//        httpRequest.setEntity(entity);
//        HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
//        String jsonData = "";
//        if (httpResponse.getStatusLine().getStatusCode() == 200)
//        {
//            InputStream is = httpResponse.getEntity().getContent();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String line = "";
//            while ((line = br.readLine()) != null)
//            {
//                jsonData += line + "\r\n";
//            }
//        }
//        return jsonData;
//    }

}
