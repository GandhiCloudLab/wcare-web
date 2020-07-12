package com.gan.wcarewebservice.service;

import com.gan.wcarewebservice.common.ConversionUtil;
import com.gan.wcarewebservice.common.LogUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.util.List;

@Configuration
@Service
public class RestUtilService {

    @Autowired
    RestTemplate restTemplate;

    public Object callGetForObject(String url, Class outputInfoClass) {
        LogUtil.log("RestUtilService : callGetForObject started");

        String jsonResonse = "";
        try {
            LogUtil.log("RestUtilService : callGetForObject url  1: " + url);

            URI uri = new URI(url);

            jsonResonse = restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LogUtil.log("RestUtilService : callGetForObject url  : " + url);
        LogUtil.log("RestUtilService : callGetForObject completed jsonResonse : " + jsonResonse);

        Object outputInfo = ConversionUtil.jsonToObject(jsonResonse, outputInfoClass);
        LogUtil.log("RestUtilService : callGetForObject completed outputInfo : " + outputInfo);

        return outputInfo;
    }


    public Object callGetForObjectList(String url, Class outputInfoClass) {
        LogUtil.log("RestUtilService : callGetForObject started");

        String jsonResonse = "";
        try {
            LogUtil.log("RestUtilService : callGetForObject url  1: " + url);

            URI uri = new URI(url);

            jsonResonse = restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LogUtil.log("RestUtilService : callGetForObject url  : " + url);
        LogUtil.log("RestUtilService : callGetForObject completed jsonResonse : " + jsonResonse);

        Object outputInfo = ConversionUtil.jsonToObject(jsonResonse, List.class, outputInfoClass);
        LogUtil.log("RestUtilService : callGetForObject completed outputInfo : " + outputInfo);

        return outputInfo;
    }

    public Object callGetForObjectList(String url, Object inputInfo, Class outputInfoClass) {
        LogUtil.log("RestUtilService : callGetForObject started");

        String jsonString = ConversionUtil.objectToJsonString(inputInfo);

        String jsonResonse = "";
        try {
            url = url + "/" + URLEncoder.encode(jsonString, "UTF-8");
            LogUtil.log("RestUtilService : callGetForObject url  1: " + url);

            URI uri = new URI(url);

            jsonResonse = restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LogUtil.log("RestUtilService : callGetForObject input jsonString  : " + jsonString);
        LogUtil.log("RestUtilService : callGetForObject url  : " + url);
        LogUtil.log("RestUtilService : callGetForObject completed jsonResonse : " + jsonResonse);

        Object outputInfo = ConversionUtil.jsonToObject(jsonResonse, List.class, outputInfoClass);
        LogUtil.log("RestUtilService : callGetForObject completed outputInfo : " + outputInfo);

        return outputInfo;
    }

    public Object callGetForObject(String url, Object inputInfo, Class outputInfoClass) {
        LogUtil.log("RestUtilService : callGetForObject started");

        String jsonString = ConversionUtil.objectToJsonString(inputInfo);

        String jsonResonse = "";
        try {
            url = url + "/" + URLEncoder.encode(jsonString, "UTF-8");
            LogUtil.log("RestUtilService : callGetForObject url  1: " + url);

            URI uri = new URI(url);

            jsonResonse = restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LogUtil.log("RestUtilService : callGetForObject input jsonString  : " + jsonString);
        LogUtil.log("RestUtilService : callGetForObject url  : " + url);
        LogUtil.log("RestUtilService : callGetForObject completed jsonResonse : " + jsonResonse);

        Object outputInfo = ConversionUtil.jsonToObject(jsonResonse, outputInfoClass);
        LogUtil.log("RestUtilService : callGetForObject completed outputInfo : " + outputInfo);

        return outputInfo;
    }

    public Object callPost (String url, Object requestInfo, Class responseClass) {

        LogUtil.log("RestUtilService : callPost started");

        LogUtil.log("RestUtilService : callPost started");
        LogUtil.log("RestUtilService : callPost url :" + url);
        LogUtil.log("RestUtilService : callPost request :" + requestInfo);

        String jsonString = ConversionUtil.objectToJsonString(requestInfo);
        LogUtil.log("RestUtilService : callPost jsonString  : " + jsonString);

        HttpEntity<Object> entity = createHttpEntity(requestInfo);

        String responseString = null;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            responseString = response.getBody();

            LogUtil.log("RestUtilService : callPost responseString 1: " + responseString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object responseObject =  ConversionUtil.jsonToObject(responseString, responseClass);
        LogUtil.log("RestUtilService : callPost responseObject : " + responseObject);

        return responseObject;
    }

    private static HttpEntity createHttpEntity(Object inputInfo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity(inputInfo, headers);
    }
}
