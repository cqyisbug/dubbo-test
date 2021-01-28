//package com.cqy.dubbo.consumer.event;
//
//import com.alibaba.cloud.dubbo.registry.event.ServiceInstancesChangedEvent;
//import com.alibaba.cloud.dubbo.registry.event.SubscribedServicesChangedEvent;
//import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import com.alibaba.nacos.api.naming.listener.NamingEvent;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ReflectionUtils;
//
//import java.util.List;
//import java.util.Objects;
//
//import static com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery.hostToServiceInstanceList;
//import static org.springframework.util.StringUtils.hasText;
//
///**
// * @author caiqy
// * @date 2020/11/10 17:50
// */
//@Slf4j
//@Component
//@AllArgsConstructor
//public class Listener {
//
//
//    private final ApplicationEventPublisher applicationEventPublisher;
//
//    private final NamingService namingService;
//
//    private final NacosDiscoveryProperties nacosDiscoveryProperties;
//
//    @Value("${spring.application.name:${dubbo.application.name:application}}")
//    private String currentApplicationName;
//
//    @EventListener(SubscribedServicesChangedEvent.class)
//    public void SubscribedServicesChangedEvent(SubscribedServicesChangedEvent subscribedServicesChangedEvent) {
//
//        subscribedServicesChangedEvent.getNewSubscribedServices().forEach(this::subscribeEventListener);
//
//    }
//
//    private void subscribeEventListener(String serviceName) {
//
//        try {
//            String group = nacosDiscoveryProperties.getGroup();
//            namingService.subscribe(serviceName, group, event -> {
//                if (event instanceof NamingEvent) {
//                    NamingEvent namingEvent = (NamingEvent) event;
//                    List<ServiceInstance> serviceInstances = hostToServiceInstanceList(
//                            namingEvent.getInstances(), serviceName);
//                    dispatchServiceInstancesChangedEvent(serviceName,
//                            serviceInstances);
//                }
//            });
//        } catch (NacosException e) {
//            ReflectionUtils.rethrowRuntimeException(e);
//        }
//
//    }
//
//    private void dispatchServiceInstancesChangedEvent(String serviceName,
//                                                      List<ServiceInstance> serviceInstances) {
//        if (!hasText(serviceName) || Objects.equals(currentApplicationName, serviceName)
//                || serviceInstances == null) {
//            return;
//        }
//
//        ServiceInstancesChangedEvent event = new ServiceInstancesChangedEvent(serviceName,
//                serviceInstances);
//        if (log.isInfoEnabled()) {
//            log.info(
//                    "The event of the service instances[name : {} , size : {}] change is about to be dispatched",
//                    serviceName, serviceInstances.size());
//        }
//        applicationEventPublisher.publishEvent(event);
//    }
//
//}
