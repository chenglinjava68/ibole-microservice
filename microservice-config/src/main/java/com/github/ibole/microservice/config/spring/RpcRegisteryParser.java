package com.github.ibole.microservice.config.spring;

import com.github.ibole.microservice.config.spring.support.RpcRegistery;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 *Rpc Registery Parser.
 */
public class RpcRegisteryParser implements BeanDefinitionParser {

  @Override
  public BeanDefinition parse(Element element, ParserContext parserContext) {

    String id = element.getAttribute("id");
    String address = element.getAttribute("address");
    String rootPath = element.getAttribute("rootPath");
    int timeout = Integer.parseInt(element.getAttribute("timeout"));
    String token = element.getAttribute("token");
    String preferredZone = element.getAttribute("preferredZone");
    boolean usedTls = Boolean.valueOf(element.getAttribute("usedTls"));

    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setBeanClass(RpcRegistery.class);
    // beanDefinition.getPropertyValues().addPropertyValue("id", id);
    // beanDefinition.getPropertyValues().addPropertyValue("beanName", type);
    beanDefinition.getPropertyValues().addPropertyValue("address", address);
    beanDefinition.getPropertyValues().addPropertyValue("rootPath", rootPath);
    beanDefinition.getPropertyValues().addPropertyValue("timeout", timeout);
    beanDefinition.getPropertyValues().addPropertyValue("token", token);
    beanDefinition.getPropertyValues().addPropertyValue("preferredZone", preferredZone);
    beanDefinition.getPropertyValues().addPropertyValue("usedTls", usedTls);
    parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);

    return beanDefinition;
  }

}
