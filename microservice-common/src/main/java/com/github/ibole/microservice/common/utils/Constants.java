package com.github.ibole.microservice.common.utils;

import java.util.regex.Pattern;

/**
 * Global common constants.
 * @author bwang
 *
 */
public class Constants {


  public static final String COMMA_SEPARATOR = ",";

  public static final Pattern COMMA_SEPERATOR_PATTERN = Pattern.compile("\\s*[,]+\\s*");
  
  public static final String ZK_DELIMETER = "/";
  
  public static final String RPC_SERVER_PROPERTY_FILE = "/server.properties";
  public static final String RPC_CLIENT_PROPERTY_FILE = "/client.properties";
  
  public static final String PROPERTY_APPLICATION_NAME = "ibole.application.name";
  public static final String PROPERTY_SERVER_HOSTNAME = "ibole.server.hostname";
  public static final String PROPERTY_SERVER_PORT = "ibole.server.port";
  public static final String PROPERTY_SERVER_USE_TLS = "ibole.use.tls";
  public static final String PROPERTY_REGISTRY_HOSTS = "ibole.registry.hosts";
  public static final String PROPERTY_REGISTRY_ROOT_PATH = "ibole.registry.rootPath";
  public static final String PROPERTY_REGISTRY_ZONE = "ibole.registry.zone";

  public enum RpcServerEnum {

    DEFAULT_CONFIG(8443, true);

    private boolean useTls = false;

    private int port;

    private RpcServerEnum(int pPort, boolean pUseTls) {
      port = pPort;
      useTls = pUseTls;
    }

    @Override
    public String toString() {
      return this.port + ":" + this.useTls;
    }

    public boolean isUseTls() {
      return this.useTls;
    }

    public int getPort() {
      return this.port;
    }
  }

}
