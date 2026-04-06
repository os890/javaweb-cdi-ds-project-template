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

package org.os890.cdi;

import java.io.Serializable;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.apache.deltaspike.core.api.scope.WindowScoped;

/**
 * JSF backing bean for the Hello World page.
 *
 * <p>Uses DeltaSpike's {@link WindowScoped} to maintain state across
 * requests within the same browser window.
 */
@Named("helloWorld")
@WindowScoped
public class HelloWorldController implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Inject
    private GreetingService greetingService;

    private String name;

    /**
     * JSF action that navigates to the result page.
     *
     * @return the outcome string for JSF navigation
     */
    public String send()
    {
        return "result.xhtml";
    }

    /**
     * Returns the greeting produced by the {@link GreetingService}.
     *
     * @return the personalised greeting message
     */
    public String getGreeting()
    {
        return greetingService.createGreeting(name);
    }

    /**
     * Returns the user-entered name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the user-entered name.
     *
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
