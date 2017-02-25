package io.ibole.microservice.config.spring.support;

import io.ibole.microservice.common.utils.ClassHelper;
import io.ibole.microservice.config.rpc.client.RpcClientProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;



/**
 * RpcReference.
 * @param <T>
 * 
 * @param <T>
 *
 */
public class RpcReference<T> implements FactoryBean<T>, InitializingBean, DisposableBean,
    BeanNameAware {

  private String interfacename;

  private String beanName;
  
  private int timeout;

  private static final Logger LOGGER = LoggerFactory.getLogger(RpcReference.class);


  @Override
  public void destroy() throws Exception {
     //do nothing.
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    //do nothing.
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public T getObject() throws Exception {
    return (T) RpcClientProvider.provider().getRpcClient().getRemotingService((Class)getObjectType(), timeout);
  }

  
  @SuppressWarnings("unchecked")
  @Override
  public Class<T> getObjectType() {

    try {
      return (Class<T>) ClassHelper.forName(interfacename);
    } catch (ClassNotFoundException e) {

      LOGGER.error("Spring parse error", e);
    }
    return null;
  }

  @Override
  public boolean isSingleton() {

    return true;
  }

  /**
   * get interface name.
   * 
   * @return the interfacename
   */
  public String getInterfacename() {
    return interfacename;
  }
  
  

  /**
   * @return the timeout
   */
  public int getTimeout() {
    return timeout;
  }

  /**
   * @param timeout the timeout to set
   */
  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  /**
   * Set interface name.
   * 
   * @param interfacename the interfacename to set
   */
  public void setInterfacename(String interfacename) {
    this.interfacename = interfacename;
  }

 
  public void setBeanName(String name) {
    beanName = name;

  }

  public String getBeanName() {
    return beanName;
  }
  
}