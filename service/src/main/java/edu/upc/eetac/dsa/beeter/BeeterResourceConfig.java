package edu.upc.eetac.dsa.beeter;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

/**
 * Created by esr on 5/10/15.
 */
/**hacemo que clase BetterResourceConfig herede de ResourceConfig*/
public class BeeterResourceConfig extends ResourceConfig {

    public BeeterResourceConfig() {
        /**añadimos al constructor la línea la configuración del paquete
        donde la aplicación debe buscar las clases recurso
         */
        packages("edu.upc.eetac.dsa.beeter");
    }
    public static HttpServer startServer() {

        //despues de crear REsourceconfig implementamos de siguiente manera..
        // en vez de hacer lo en main lo hacemos aqui
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.eetac.dsa.beeter package
        final ResourceConfig rc = new BeeterResourceConfig();

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(Main.getBaseURI()), rc);
    }

}
