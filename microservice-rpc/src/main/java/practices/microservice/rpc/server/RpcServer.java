/**
 * 
 */
package practices.microservice.rpc.server;

import java.io.IOException;

import practices.microservice.registry.ServiceRegistry;

/**
 * @author bwang
 *
 */
public interface RpcServer {
    /**
     * 
     * @param pPort
     * @param pUseTls
     */
	public void configure(int pPort, boolean pUseTls);
	/**
	 *  Bind and start the server.
	 */
	public void start() throws IOException;
	/**
	 * Forceful shutdown.
	 */
	public void stop() throws InterruptedException;
	/**
	 *  Waits for the server to become terminated.
	 *  Await termination on the main thread.
	 * 
	 */
	public void blockUntilShutdown() throws InterruptedException;
	/**
	 * Look up services and bind to RPC server.
	 * @return the instance of ServiceRegistry.
	 */
	public ServiceRegistry lookupServices();
	
}
