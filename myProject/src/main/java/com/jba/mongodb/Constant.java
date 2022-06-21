package com.jba.mongodb;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.mongodb.MongoClientURI;

public class Constant {
	
	public static String DB_HOST = "127.0.0.1";
	public static int DB_PORT = 27027;
	//
	public static String MONGO_DB_USER = "admin";
	public static String MONGO_DB__PASSWORD = "jawharAdmin27101978!#";
	//
	public static String PASSWORD_SUFFIXE="27101978!#";
	public static String DB_GeneralAdmin = "GeneralAdmin";
	//
	public static String COL_All_Users = "All_Users";
	public static String COL_All_Charts = "All_Charts";
	public static String COL_OF_ASSETS = "All_Assets";
	
	
	
	
	
	public static MongoClientURI getURIGeneralAdmin() {
		int port_no = Constant.DB_PORT;
		String auth_user = Constant.DB_GeneralAdmin;
		String auth_pwd = Constant.DB_GeneralAdmin+Constant.PASSWORD_SUFFIXE;
		String host_name = Constant.DB_HOST;
		String db_name = Constant.DB_GeneralAdmin;
		String encoded_pwd = "";
		try {
			encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			//
		}
		String client_url = "mongodb://" + auth_user + ":" + encoded_pwd + "@" + host_name + ":" + port_no + "/"
				+ db_name;
		MongoClientURI uri = new MongoClientURI(client_url);
		return uri;
	}
	
	//leave db_name blank for creation
	public static MongoClientURI getURIMongoDBToCreateDb(String db_name) {
		int port_no = Constant.DB_PORT;
		String auth_user = Constant.MONGO_DB_USER;
		String auth_pwd = Constant.MONGO_DB__PASSWORD;
		String host_name = Constant.DB_HOST;
		String encoded_pwd = "";
		try {
			encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			//
		}
		String client_url = "mongodb://" + auth_user + ":" + encoded_pwd + "@" + host_name + ":" + port_no + "/"
				+ db_name;
		MongoClientURI uri = new MongoClientURI(client_url);
		return uri;
	}
	
	//leave db_name blank for creation
		public static MongoClientURI getURIForAsset(String assetCode) {
			int port_no = Constant.DB_PORT;
			String auth_user = assetCode;
			String auth_pwd = assetCode+Constant.PASSWORD_SUFFIXE;
			String host_name = Constant.DB_HOST;
			String encoded_pwd = "";
			try {
				encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				//
			}
			String client_url = "mongodb://" + auth_user + ":" + encoded_pwd + "@" + host_name + ":" + port_no + "/"
					+ assetCode;
			MongoClientURI uri = new MongoClientURI(client_url);
			return uri;
		}
	

}
