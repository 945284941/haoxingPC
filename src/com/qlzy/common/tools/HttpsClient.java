package com.qlzy.common.tools;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class HttpsClient {
	public static Log log = LogFactory.getLog(HttpsClient.class);

	private static String url = "https://dx.ipyy.net/smsJson.aspx";
	private static String username = "AA00538";
	private static String password = "2FCB3B3FA46C7635B8BDBB1E0F5C8519";
	
	public static String sendMessage(String mobile, String content) {
		try {
			String requestString = url + "?userid=&action=send&account=" + username + "&password=" + password + "&mobile=" + mobile + "&content=" + URLEncoder.encode(content, "utf-8");
			String response = send(requestString, "");
			return new String(response.getBytes("gbk"), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String send(String requsetString, String requestData)
			throws NoSuchAlgorithmException, KeyManagementException,
			ClientProtocolException, IOException {
		// First create a trust manager that won't care.
		X509TrustManager trustManager = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
				// Don't do anything.
			}

			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
				// Don't do anything.
			}

			public X509Certificate[] getAcceptedIssuers() {
				// Don't do anything.
				return null;
			}

		};
		// Now put the trust manager into an SSLContext.
		SSLContext sslcontext = SSLContext.getInstance("SSL");
		sslcontext.init(null, new TrustManager[] { trustManager }, null);

		// Use the above SSLContext to create your socket factory
		// (I found trying to extend the factory a bit difficult due to a
		// call to createSocket with no arguments, a method which doesn't
		// exist anywhere I can find, but hey-ho).
		SSLSocketFactory sf = new SSLSocketFactory(sslcontext);
		sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.getConnectionManager().getSchemeRegistry()
				.register(new Scheme("https", sf, 443));

		// String requset = "https://180.168.35.140/api/vm.list";
		HttpPost httpPost = new HttpPost(requsetString);
		String result = "";
		// Execute HTTP request
		httpPost.setHeader("Authorization", "basic "
				+ "dGNsb3VkYWRtaW46dGNsb3VkMTIz");
		httpPost.setHeader("Content-type", "application/xml");

		StringEntity reqEntity;

		// 将请求参数封装成HttpEntity
		reqEntity = new StringEntity(requestData);
		BufferedHttpEntity bhe = new BufferedHttpEntity(reqEntity);
		httpPost.setEntity(bhe);
		HttpResponse response = httpclient.execute(httpPost);
		HttpEntity resEntity = response.getEntity();
		InputStreamReader reader = new InputStreamReader(resEntity.getContent());

		char[] buff = new char[1024];
		int length = 0;
		while ((length = reader.read(buff)) != -1) {
			result += new String(buff, 0, length);
		}
		httpclient.getConnectionManager().shutdown();

		System.out.println(">>>:" + result);
		return result;
	}
}