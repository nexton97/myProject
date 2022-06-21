package edu.majid.main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;

import javax.ws.rs.core.UriBuilder;

public class Tools {
static String url="localhost";
static int port = 80;

	public static boolean isReacheable(String url, int timeout) throws IOException {
		boolean result = false;
		int timeout_count = 0;
		while (timeout > timeout_count) {

			int code = 200;
			try {
				URL siteURL = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(3000);
				connection.connect();
				code = connection.getResponseCode();
				if (code == 200)
					result = true;
				else
					result = false;

			} catch (Exception e) {
			}
			if (result)
				break;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timeout_count = timeout_count + 5000;

		}
		return result;
	}

	public static URI getCrunchifyURI() {
		return UriBuilder.fromUri("http://" + crunchifyGetHostName() + "/").port(port).build();
	}

	public static String crunchifyGetHostName() {
		String hostName = url;
		try {
			hostName = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return hostName;
	}

}
