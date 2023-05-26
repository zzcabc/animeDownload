package com.zhaocheng.animedownload.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.ObjectUtils;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.utils
 * @create 2023-05-25 17:22
 */
@Log4j2
public class HttpUtil {

    /**
     * 检查httpResponse对象是否是成功的
     *
     * @param httpResponse httpResponse对象
     * @return 判断http状态是否是200
     */
    public static boolean checkHttpResponseSuccess(HttpResponse<String> httpResponse) {
        return HttpURLConnection.HTTP_OK == httpResponse.statusCode();
    }

    /**
     * 设置默认的代理 以便测试
     *
     * @param url 请求地址
     * @return HttpResponse<String>
     * @throws Exception 一些异常
     */
    public static HttpResponse<String> doHttpGetDefaultProxy(String url) throws Exception {
        return doHttpGet(url, null, null, "127.0.0.1", 7890);
    }

    public static HttpResponse<String> doHttpGetNoProxy(String url) throws Exception {
        return doHttpGetNoProxy(url, null);
    }

    public static HttpResponse<String> doHttpGetNoProxy(String url, Map<String, String> headers) throws Exception {
        return doHttpGet(url, headers, null, null, null);
    }

    /**
     * 发送Get请求
     *
     * @param url         请求地址
     * @param headers     请求头
     * @param readTimeOut 超时时间
     * @param proxyAddr   代理地址
     * @param proxyPort   代理端口
     * @return HttpResponse<String>
     * @throws Exception 一些异常
     */
    public static HttpResponse<String> doHttpGet(String url, Map<String, String> headers, Long readTimeOut, String proxyAddr, Integer proxyPort) throws Exception {
        log.info("doHttpGet url={}, headers={}", url, JsonUtil.objToJson(headers));
        HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder();
        httpRequestBuilder.uri(new URI(url));
        if (!ObjectUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpRequestBuilder.setHeader(entry.getKey(), entry.getValue());
            }
        }
        httpRequestBuilder.GET();
        HttpClient.Builder httpClientBuilder = HttpClient.newBuilder();
        if (!ObjectUtils.isEmpty(readTimeOut))
            httpClientBuilder.connectTimeout(Duration.ofSeconds(readTimeOut));
        if (!ObjectUtils.isEmpty(proxyAddr) && !ObjectUtils.isEmpty(proxyPort))
            httpClientBuilder.proxy(ProxySelector.of(new InetSocketAddress(proxyAddr, proxyPort)));
        HttpClient httpClient = httpClientBuilder.build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequestBuilder.build(), HttpResponse.BodyHandlers.ofString());
        log.info("doHttpGet url={}, statusCode={}, resp={}", url, httpResponse.statusCode(), httpResponse.body());
        return httpResponse;
    }

    public static HttpResponse<String> doHttpPostNoProxy(String url) throws Exception {
        return doHttpPostNoProxy(url, "");
    }

    public static HttpResponse<String> doHttpPostNoProxy(String url, String paramsJsonStr) throws Exception {
        return doHttpPostNoProxy(url, null, paramsJsonStr);
    }

    public static HttpResponse<String> doHttpPostNoProxy(String url, Map<String, Object> params) throws Exception {
        return doHttpPostNoProxy(url, null, params);
    }

    public static HttpResponse<String> doHttpPostNoProxy(String url, Map<String, String> headers, Map<String, Object> params) throws Exception {
        return doHttpPostNoProxy(url, headers, JsonUtil.objToJson(params));
    }

    public static HttpResponse<String> doHttpPostNoProxy(String url, Map<String, String> headers, String paramsJsonStr) throws Exception {
        return doHttpPost(url, headers, paramsJsonStr, null, null, null);
    }

    /**
     * 发送Post请求
     *
     * @param url           请求地址
     * @param headers       请求头
     * @param paramsJsonStr 请求体
     * @param readTimeOut   超时时间
     * @param proxyAddr     代理地址ip
     * @param proxyPort     代理地址端口
     * @return HttpResponse<String>
     */
    public static HttpResponse<String> doHttpPost(String url, Map<String, String> headers, String paramsJsonStr, Long readTimeOut, String proxyAddr, Integer proxyPort) throws Exception {
        log.info("doHttpPost url={}, headers={}, readTimeOut={}, proxyAddr={}, proxyPort={}, params={}", url, JsonUtil.objToJson(headers), readTimeOut, proxyAddr, proxyPort, paramsJsonStr);
        HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder();
        httpRequestBuilder.uri(new URI(url));
        if (!ObjectUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpRequestBuilder.setHeader(entry.getKey(), entry.getValue());
            }
        } else {
            httpRequestBuilder.setHeader("Content-Type", "application/json;charset=UTF-8");
        }
        httpRequestBuilder.POST(HttpRequest.BodyPublishers.ofString(paramsJsonStr));
        HttpClient.Builder httpClientBuilder = HttpClient.newBuilder();
        if (!ObjectUtils.isEmpty(readTimeOut))
            httpClientBuilder.connectTimeout(Duration.ofSeconds(readTimeOut));
        if (!ObjectUtils.isEmpty(proxyAddr) && !ObjectUtils.isEmpty(proxyPort))
            httpClientBuilder.proxy(ProxySelector.of(new InetSocketAddress(proxyAddr, proxyPort)));
        HttpClient httpClient = httpClientBuilder.build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequestBuilder.build(), HttpResponse.BodyHandlers.ofString());
        log.info("doHttpPost url={}, statusCode={}, resp={}", url, httpResponse.statusCode(), httpResponse.body());
        return httpResponse;
    }


}
