package io.ibole.microservice.registry;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import io.ibole.microservice.common.ServerIdentifier;
import io.ibole.microservice.discovery.InstanceMetadata;
import io.ibole.microservice.discovery.RegisterEntry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Service Registry.
 * @author bwang
 *
 */
public abstract class AbstractServiceRegistry implements ServiceRegistry<InstanceMetadata> {


  protected final Logger log = LoggerFactory.getLogger(this.getClass());

  private ServerIdentifier identifier;

  protected AbstractServiceRegistry(ServerIdentifier identifier) {
    this.identifier = identifier;
  }


  @Override
  public ServerIdentifier getIdentifier() {
    return this.identifier;
  }

  @SuppressWarnings("null")
  protected void validateFileds(RegisterEntry entry) {
    checkArgument(entry == null, "Param cannot be null!");
    checkNotNull(entry.getServiceName(), "Property 'serviceName' cannot be null!");
    checkNotNull(entry.getServiceContract(), "Property 'serviceContract' cannot be null!");
    checkNotNull(entry.getInstanceMetadata(), "Property 'instanceMetadatum' cannot be nulls!");
  }

  protected String buildBasePath() {
    return this.getIdentifier().getRootPath().getPath();
  }
}