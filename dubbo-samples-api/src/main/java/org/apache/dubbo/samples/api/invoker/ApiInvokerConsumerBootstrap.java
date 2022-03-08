/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.samples.api.invoker;

import org.apache.dubbo.samples.api.client.HelloService;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

public class ApiInvokerConsumerBootstrap {
    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ReferenceConfig<HelloService> reference = new ReferenceConfig<>();
        ApplicationConfig application = new ApplicationConfig("first-dubbo-consumer");
        application.setQosPort(3333);
        reference.setApplication(application);
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
//        reference.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234"));
        reference.setInterface(HelloService.class);
        HelloService helloService = reference.get();
        String message = helloService.sayHello("dubbo");
        System.err.println(message);
    }
}
