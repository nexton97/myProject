package edu.majid.main;
import java.io.IOException;

import org.apache.log4j.*;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

/**
 * @author Crunchify.com
 * 
 */

@SuppressWarnings("restriction")
public class MainServer {
	private static final Logger log = Logger.getLogger(MainServer.class);
	
	public static void main(String[] args) throws IOException {
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);
		// ****************** Starting web server ******************/
		log.info("Starting RESTFull Server...\n");
		HttpServer crunchifyHTTPServer = createHttpServer();
		crunchifyHTTPServer.start();
		log.info("RESTFull Server Started Successfully !!!");
		
		// ****************** Starting status watcher ******************/
			//new StatusThreadWatcher().start();;
				
		
		
	}

	private static HttpServer createHttpServer() throws IOException {
		ResourceConfig crunchifyResourceConfig = new PackagesResourceConfig("edu.majid");
		return HttpServerFactory.create(Tools.getCrunchifyURI(), crunchifyResourceConfig);
	}

}