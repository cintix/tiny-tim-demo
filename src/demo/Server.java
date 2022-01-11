/*
 */
package demo;

import demo.endpoint.HelloWorldRestEndPointImpl;
import demo.html.tag.CustomHTMLTag;
import dk.cintix.application.server.rest.http.RestHttpServer;
import dk.cintix.application.server.io.Log;
import dk.cintix.application.server.web.engine.DocumentEngine;
import java.net.InetSocketAddress;

/**
 *
 * @author migo
 */
public class Server extends RestHttpServer {

    private final Log LOG = Log.instance();

    private void start() {
        try {

//            PooledDataSource pooledDataSource = new PooledDataSource("jdbc:postgresql://localhost:5432/epgcore", "epgcore", "epgcore", 20);
//            DataSourceManager.addDataSource("jdbc/epg", pooledDataSource);

            bind(new InetSocketAddress("0.0.0.0", 9090));
            addEndpoint("/api/hello", new HelloWorldRestEndPointImpl());

            setDocumentRoot("web");
            
            DocumentEngine.setTagPrefix("<demo-data");
            DocumentEngine.addDataClass("current-time", CustomHTMLTag.class);
            
            startServer();
        } catch (Exception exception) {
            exception.printStackTrace();
            LOG.error(exception.toString());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

}
