/*
 * 文件名：HttpTookit.java
 * 版权：Copyright 2007-2015 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HttpTookit.java
 * 修改人：zhengmo
 * 修改时间：2015年12月11日
 * 修改内容：新增
 */
package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 * HTTP Client 工具类.
 * @author zhengmo
 */
public class HttpToolKit {
    /**
     */
    private CookieStore cookieStore = null;
    /**
     * @静态
     */
    private CloseableHttpClient httpClinet;
    /**
     * @头部 
     */
    private List<Header> headers = null;
    /**
     * @代理IP信息
     */
    private HttpToolProxyInfo proxyInfo = null;
    /**
     * @默认字符集
     */
    public static final String CHARSET = "UTF-8";
    /**
     * @默认超时时间
     */
    public static final int DEFAUL_CONTIMEOUT = 120;
    // static {
    // CookieStore cookieStore = new BasicCookieStore();
    // RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(15000).build();
    // HTTP_CLIENT = HttpClientBuilder.create().setDefaultRequestConfig(config).setDefaultCookieStore(cookieStore).build();
    // }
    /**
     * 构造函数.
     * @param proxy .
     */
    public HttpToolKit(HttpToolProxyInfo proxy) {
        this.proxyInfo = proxy;
        cookieStore = new BasicCookieStore();
        CredentialsProvider credsProvider = null;
        HttpHost proxyHost = null;
        if (proxy != null) {
            if (StringUtils.isNotBlank(proxy.getHost())) { // 设置代理IP
                proxyHost = new HttpHost(proxy.getHost(), proxy.getPort());
            }
            if (StringUtils.isNotBlank(proxy.getUsername()) && StringUtils.isNotBlank(proxy.getPassword())) {
                credsProvider = new BasicCredentialsProvider(); // 设置ip访问
                credsProvider.setCredentials(new AuthScope(proxy.getHost(), proxy.getPort()), // 可以访问的范围
                        new UsernamePasswordCredentials(proxy.getUsername(), proxy.getPassword())); // 用户名和密码
            }
        }
        Builder builder = RequestConfig.custom();
        if (proxyHost != null) {
            builder.setProxy(proxyHost);
        }
        RequestConfig config = builder.setConnectTimeout(1000 * DEFAUL_CONTIMEOUT).setSocketTimeout(1000 * DEFAUL_CONTIMEOUT).build();
        if (credsProvider != null) {
            httpClinet = HttpClientBuilder.create().setDefaultRequestConfig(config).setDefaultCredentialsProvider(credsProvider).setDefaultCookieStore(cookieStore).build();
        } else {
            httpClinet = HttpClientBuilder.create().setDefaultRequestConfig(config).setDefaultCookieStore(cookieStore).build();
        }
    }
    /**
     * 构造函数.
     * @param proxy proxy.
     * @param isSSL 是否SSL
     */
    public HttpToolKit(HttpToolProxyInfo proxy, boolean isSSL) {
        if (!isSSL) {
            new HttpToolKit(proxy);
            return;
        }
        this.proxyInfo = proxy;
        cookieStore = new BasicCookieStore();
        CredentialsProvider credsProvider = null;
        HttpHost proxyHost = null;
        if (proxy != null) {
            if (StringUtils.isNotBlank(proxy.getHost())) { // 设置代理IP
                proxyHost = new HttpHost(proxy.getHost(), proxy.getPort());
            }
            if (StringUtils.isNotBlank(proxy.getUsername()) && StringUtils.isNotBlank(proxy.getPassword())) {
                credsProvider = new BasicCredentialsProvider(); // 设置ip访问
                credsProvider.setCredentials(new AuthScope(proxy.getHost(), proxy.getPort()), // 可以访问的范围
                        new UsernamePasswordCredentials(proxy.getUsername(), proxy.getPassword())); // 用户名和密码
            }
        }
        Builder builder = RequestConfig.custom();
        if (proxyHost != null) {
            builder.setProxy(proxyHost);
        }
        RequestConfig config = builder.setConnectTimeout(1000 * DEFAUL_CONTIMEOUT).setSocketTimeout(1000 * DEFAUL_CONTIMEOUT).build();
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true; // 信任所有
                }
                }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            if (credsProvider != null) {
                httpClinet = HttpClientBuilder.create().setDefaultRequestConfig(config).setSSLSocketFactory(sslsf).setDefaultCredentialsProvider(credsProvider).setDefaultCookieStore(
                        cookieStore).build();
            } else {
                httpClinet = HttpClientBuilder.create().setDefaultRequestConfig(config).setSSLSocketFactory(sslsf).setDefaultCookieStore(cookieStore).build();
            }
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    /**
     * 创建客户端.
     * @return .
     */
    public static HttpToolKit build() {
        return new HttpToolKit(null);
    }
    /**
     * 创建客户端.
     * @param proxy .
     * @return .
     */
    public static HttpToolKit build(HttpToolProxyInfo proxy) {
        return new HttpToolKit(proxy);
    }
    /**
     * 创建客户端.
     * @param proxy .
     * @param isSSL .
     * @return .
     */
    public static HttpToolKit build(HttpToolProxyInfo proxy, boolean isSSL) {
        return new HttpToolKit(proxy, isSSL);
    }
    /**
     * 添加请求头.
     * @param header 请求头.
     * @return .
     */
    public HttpToolKit addHeader(Header header) {
        if (this.headers == null) {
            this.headers = new ArrayList<>();
        }
        this.headers.add(header);
        return this;
    }
    /**
     * 添加请求头.
     * @param name key
     * @param value value
     * @return .
     */
    public HttpToolKit addHeader(String name, String value) {
        Header header = new BasicHeader(name, value);
        if (this.headers == null) {
            this.headers = new ArrayList<>();
        }
        this.headers.add(header);
        return this;
    }
    /**
     * 清除文件头.
     * @return .
     */
    public HttpToolKit clearHeader() {
        if (this.headers != null) {
            this.headers.clear();
        }
        return this;
    }
    /**
     * 设置cookieStore.
     * @return 返回cookieStore
     */
    public CookieStore getCookieStore() {
        return cookieStore;
    }
    /**
     * 获取cookieStore.
     * @param cookieStore 要设置的cookieStore
     */
    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }
    /**
     * 设置httpClinet.
     * @return 返回httpClinet
     */
    public CloseableHttpClient getHttpClinet() {
        return httpClinet;
    }
    /**
     * 获取httpClinet.
     * @param httpClinet 要设置的httpClinet
     */
    public void setHttpClinet(CloseableHttpClient httpClinet) {
        this.httpClinet = httpClinet;
    }
    /**
     * GET请求.
     * @param url url地址
     * @param user 用户名
     * @param pwd 密码
     * @return 结果
     */
    public String doGet(String url, String user, String pwd) {
        return doGet(url, null, CHARSET, user, pwd);
    }
    /**
     * GET请求.
     * @param url url地址
     * @return 结果
     */
    public String doGet(String url) {
        return doGet(url, null, CHARSET, null, null);
    }
    /**
     * GET请求.
     * @param url url地址
     * @param params 参数
     * @return 结果
     */
    public String doGet(String url, Map<String, ?> params) {
        return doGet(url, params, CHARSET);
    }
    /**
     * GET请求,基本授权.
     * @param url url地址
     * @param params 参数
     * @param user 用户名
     * @param pwd 密码
     * @return 结果
     */
    public String doGet(String url, Map<String, ?> params, String user, String pwd) {
        return doGet(url, params, CHARSET, user, pwd);
    }
    /**
     * GET请求.
     * @param url url地址
     * @param params 参数
     * @return 结果
     */
    public String doDelete(String url, Map<String, ?> params) {
        return doDelete(url, params, CHARSET);
    }
    /**
     * POST请求.
     * @param url url地址
     * @param params 参数
     * @param isMultipart 是否附件
     * @return 结果
     */
    public String doPost(String url, Map<String, ?> params, Boolean isMultipart) {
        return doPost(url, params, CHARSET, isMultipart);
    }
    /**
     * POST请求.
     * @param url url地址
     * @param params 参数
     * @return 结果
     */
    public String doPost(String url, Map<String, ?> params) {
        return doPost(url, params, CHARSET, false);
    }
    /**
     * HTTP Get 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数<name,value>
     * @return 页面内容
     */
    public byte[] doLittleGetDownload(String url, Map<String, ?> params) {
        return this.doLittleGetDownload(url, params, CHARSET);
    }
    /**
     * HTTP Get 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数<name,value>
     * @param charset 编码格式
     * @return 页面内容
     */
    public byte[] doLittleGetDownload(String url, Map<String, ?> params, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, ?> entry : params.entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value.toString()));
                    } else {
                        pairs.add(new BasicNameValuePair(entry.getKey(), ""));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            }
            HttpGet httpGet = new HttpGet(url);
            if (this.headers != null && this.headers.size() > 0) {
                for (Header header : headers) {
                    httpGet.addHeader(header);
                }
            }
            response = httpClinet.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            byte[] result = null;
            if (entity != null) {
                result = EntityUtils.toByteArray(entity);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * HTTP Get 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数<name,value>
     * @param charset 编码格式
     * @return 页面内容
     */
    public String doGet(String url, Map<String, ?> params, String charset) {
        return doGet(url, params, charset, null, null);
    }
    /**
     * HTTP Get 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数<name,value>
     * @param charset 编码格式
     * @param user 用户名
     * @param pwd 密码
     * @return 页面内容
     */
    public String doGet(String url, Map<String, ?> params, String charset, String user, String pwd) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, ?> entry : params.entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value.toString()));
                    } else {
                        pairs.add(new BasicNameValuePair(entry.getKey(), ""));
                    }
                }
                if (url.contains("?")) {
                    url += "&" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
                } else {
                    url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
                }
            }
            HttpGet httpGet = new HttpGet(url);
            if (this.headers != null && this.headers.size() > 0) {
                for (Header header : headers) {
                    httpGet.addHeader(header);
                }
            }
            if (StringUtils.isNotBlank(user) && StringUtils.isNotBlank(pwd)) {
                HttpHost host = new HttpHost(httpGet.getURI().getHost(), httpGet.getURI().getPort(), httpGet.getURI().getScheme());
                HttpContext ctx = createBasicAuthContext(httpGet.getURI().getScheme(), httpGet.getURI().getHost(), httpGet.getURI().getPort(), user, pwd);
                response = httpClinet.execute(host, httpGet, ctx);
            } else {
                response = httpClinet.execute(httpGet);
            }
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                if (statusCode == 401) {
                    return "授权错误";
                }
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * HTTP Get 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数<name,value>
     * @param charset 编码格式
     * @return 页面内容
     */
    public String doDelete(String url, Map<String, ?> params, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, ?> entry : params.entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value.toString()));
                    } else {
                        pairs.add(new BasicNameValuePair(entry.getKey(), ""));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            }
            HttpDelete httpDelete = new HttpDelete(url);
            if (this.headers != null && this.headers.size() > 0) {
                for (Header header : headers) {
                    httpDelete.addHeader(header);
                }
            }
            response = httpClinet.execute(httpDelete);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpDelete.abort();
                if (statusCode == 401) {
                    return "授权错误";
                }
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * HTTP Get 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数<name,value>
     * @param charset 编码格式
     * @return 页面内容
     */
    public String doPut(String url, Map<String, ?> params, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, ?> entry : params.entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value.toString()));
                    } else {
                        pairs.add(new BasicNameValuePair(entry.getKey(), ""));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
            }
            HttpPut httpPut = new HttpPut(url);
            if (this.headers != null && this.headers.size() > 0) {
                for (Header header : headers) {
                    httpPut.addHeader(header);
                }
            }
            response = httpClinet.execute(httpPut);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPut.abort();
                if (statusCode == 401) {
                    return "授权错误";
                }
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * HTTP Post 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数 <name,Object> Object允许类型String ,File ,InputStream ,byte[]
     * @param charset 编码格式
     * @param isMultipart 是否附件
     * @return 页面内容
     */
    public String doPost(String url, Map<String, ?> params, String charset, Boolean isMultipart) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            HttpEntity httpEntity = null;
            if (params != null && !params.isEmpty()) {
                if (isMultipart != null && isMultipart) { // 文件上传
                    MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE).setCharset(Charset.forName(CHARSET));
                    for (Map.Entry<String, ?> entry : params.entrySet()) {
                        Object value = entry.getValue();
                        if (value != null && value instanceof File) {
                            builder.addBinaryBody(entry.getKey(), (File) value);
                        } else if (value != null && value instanceof byte[]) {
                            builder.addBinaryBody(entry.getKey(), (byte[]) value);
                        } else if (value != null && value instanceof InputStream) {
                            builder.addBinaryBody(entry.getKey(), (InputStream) value);
                        } else if (value != null && value instanceof ContentBody) {
                            builder.addPart(entry.getKey(), (ContentBody) value);
                        } else if (value != null) {
                            builder.addTextBody(entry.getKey(), value.toString());
                        }
                    }
                    httpEntity = builder.build();
                } else {
                    // 普通表单
                    List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                    for (Map.Entry<String, ?> entry : params.entrySet()) {
                        Object value = entry.getValue();
                        if (value != null) {
                            pairs.add(new BasicNameValuePair(entry.getKey(), value.toString()));
                        }
                    }
                    httpEntity = new UrlEncodedFormEntity(pairs, charset);
                }
            }
            HttpPost httpPost = new HttpPost(url);
            if (this.headers != null && this.headers.size() > 0) {
                for (Header header : headers) {
                    httpPost.addHeader(header);
                }
            }
            if (httpEntity != null && httpEntity.getContentLength() > 0) {
                httpPost.setEntity(httpEntity);
            }
            response = httpClinet.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                if (statusCode == 301 || statusCode == 302) {
                    String downurl = response.getLastHeader("Location").getValue();
                    return this.doGet(downurl, null);
                } else {
                    return null;
                }
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * HTTP Post 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数 <name,Object> Object允许类型String ,File ,InputStream ,byte[]
     * @return 页面内容
     */
    public byte[] doLittlePostDownload(String url, Map<String, ?> params) {
        return this.doLittlePostDownload(url, params, CHARSET);
    }
    /**
     * HTTP Post 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数 <name,Object> Object允许类型String ,File ,InputStream ,byte[]
     * @param charset 编码格式
     * @return 页面内容
     */
    public byte[] doLittlePostDownload(String url, Map<String, ?> params, String charset) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            HttpEntity httpEntity = null;
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, ?> entry : params.entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        pairs.add(new BasicNameValuePair(entry.getKey(), value.toString()));
                    }
                }
                httpEntity = new UrlEncodedFormEntity(pairs, charset);
            }
            // if (params != null && !params.isEmpty()) {
            // MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE).setCharset(Charset.forName(CHARSET));
            // for (Map.Entry<String, ?> entry : params.entrySet()) {
            // Object value = entry.getValue();
            // if (value != null && value instanceof File) {
            // builder.addBinaryBody(entry.getKey(), (File) value);
            // } else if (value != null && value instanceof byte[]) {
            // builder.addBinaryBody(entry.getKey(), (byte[]) value);
            // } else if (value != null && value instanceof InputStream) {
            // builder.addBinaryBody(entry.getKey(), (InputStream) value);
            // } else if (value != null && value instanceof ContentBody) {
            // builder.addPart(entry.getKey(), (ContentBody) value);
            // } else if (value != null) {
            // builder.addTextBody(entry.getKey(), value.toString());
            // }
            // }
            // httpEntity = builder.build();
            // }
            HttpPost httpPost = new HttpPost(url);
            if (this.headers != null && this.headers.size() > 0) {
                for (Header header : headers) {
                    httpPost.addHeader(header);
                }
            }
            if (httpEntity != null && httpEntity.getContentLength() > 0) {
                httpPost.setEntity(httpEntity);
            }
            response = httpClinet.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                if (statusCode == 301 || statusCode == 302) {
                    String downurl = response.getLastHeader("Location").getValue();
                    return this.doLittleGetDownload(downurl, null);
                } else {
                    return null;
                }
            }
            HttpEntity entity = response.getEntity();
            byte[] result = null;
            if (entity != null) {
                result = EntityUtils.toByteArray(entity);
            }
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * HTTP Post 获取内容.
     * @param url 请求的url地址 ?之前的地址
     * @param params 请求的参数 字符串
     * @param charset 编码格式
     * @return 页面内容
     * @throws Exception .
     */
    public String doSimplePost(String url, String params, String charset) throws Exception {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        CloseableHttpResponse response = null;
        try {
            HttpEntity httpEntity = null;
            if (params != null && !params.isEmpty()) {
                httpEntity = new StringEntity(params, charset);
            }
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("content-type", "application/json");
            if (this.headers != null && this.headers.size() > 0) {
                for (Header header : headers) {
                    httpPost.addHeader(header);
                }
            }
            if (httpEntity != null && httpEntity.getContentLength() > 0) {
                httpPost.setEntity(httpEntity);
            }
            response = httpClinet.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
                if (statusCode == 401) {
                    return "授权错误";
                }
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null) {
                result = EntityUtils.toString(entity, charset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof SocketTimeoutException && e.getMessage().contains("Read timed out")) {
                throw e;
            }
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    /**
     * 检测IP端口是否在超时范围内能联通.
     * @param ip ip
     * @param port 端口
     * @return .
     */
    public static boolean checkIpAddress(String ip, int port) {
        return checkIpAddress(ip, port, DEFAUL_CONTIMEOUT);
    }
    /**
     * 检测IP端口是否在超时范围内能联通.
     * @param ip ip
     * @param port 端口
     * @param timeout 超时时间 毫秒
     * @return .
     */
    public static boolean checkIpAddress(String ip, int port, int timeout) {
        try {
            Socket sc = new Socket();
            sc.connect(new InetSocketAddress(ip, port), timeout);
            sc.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 检测IP端口是否在超时范围内能联通.
     * @param proxyInfo 代理IP
     * @param url 访问连接
     * @return .
     */
    public static boolean checkIpAddress(HttpToolProxyInfo proxyInfo, String url) {
        try {
            HttpToolKit k = HttpToolKit.build(proxyInfo);
            k.addHeader("Accept-Encoding", "deflate, sdch"); // 不使用GZIP,防止GZIP压缩报错
            k.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");
            k.addHeader("Origin", "http://www.baidu.com");
            k.addHeader("Referer", "http://www.baidu.com");
            String html = k.doGet(url, null);
            if (StringUtils.isNotBlank(html) && !html.contains("404") && !html.contains("502") && !html.contains("403")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 设置headers.
     * @return 返回headers
     */
    public List<Header> getHeaders() {
        return headers;
    }
    /**
     * 获取headers.
     * @param headers 要设置的headers
     */
    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }
    /**
     * 设置proxyInfo.
     * @return 返回proxyInfo
     */
    public HttpToolProxyInfo getProxyInfo() {
        return proxyInfo;
    }
    /**
     * 获取proxyInfo.
     * @param proxyInfo 要设置的proxyInfo
     */
    public void setProxyInfo(HttpToolProxyInfo proxyInfo) {
        this.proxyInfo = proxyInfo;
    }
    /**
     * 创建基础验证.
     * @param scheme http/https
     * @param host 主机
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     * @return context
     */
    private HttpClientContext createBasicAuthContext(String scheme, String host, int port, String username, String password) {
        HttpHost httpHost = new HttpHost(host, port, scheme);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        Credentials defaultCreds = new UsernamePasswordCredentials(username, password);
        credsProvider.setCredentials(new AuthScope(host, port), defaultCreds);
        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(httpHost, basicAuth);
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        context.setAuthCache(authCache);
        return context;
    }
}
