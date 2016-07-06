package practices.microservice.discovery;

import practices.microservice.common.ServerIdentifier;


/**
 * The factory is to create discovery&registry  handler for specific registry center as multi-registry center coexistence is supported by discovery module. 
 * 
 * Like Zookeeper registry center handler and Redis registry center handler.
 * 
 *  .
 * 
 * @author bwang
 *
 */
public interface DiscoveryFactory<T> {
	
	T getServiceDiscovery(ServerIdentifier identifier);
}