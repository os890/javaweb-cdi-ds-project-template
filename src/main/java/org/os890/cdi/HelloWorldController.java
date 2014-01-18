/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
*/
package org.os890.cdi;

import org.apache.deltaspike.core.api.scope.WindowScoped;

import java.io.Serializable;

import javax.inject.Named;
import javax.inject.Inject;

/*
 * generated
 */
@Named("helloWorld")
@WindowScoped
public class HelloWorldController implements Serializable
{
    @Inject
    private GreetingService greetingService;

    private String name;

    public String send()
    {
        return "result.xhtml";
    }

    public String getGreeting()
    {
        return greetingService.createGreeting(name);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
