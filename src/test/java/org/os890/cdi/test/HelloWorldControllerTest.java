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

package org.os890.cdi.test;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.os890.cdi.GreetingService;
import org.os890.cdi.addon.dynamictestbean.EnableTestBeans;

/**
 * CDI SE test for the controller logic using the Dynamic CDI Test Bean Addon.
 *
 * <p>Since {@code @WindowScoped} requires JSF, this test verifies the
 * {@link GreetingService} integration in a plain CDI SE container.
 *
 * @see <a href="https://github.com/os890/dynamic-cdi-test-bean-addon">Dynamic CDI Test Bean Addon</a>
 */
@EnableTestBeans
class HelloWorldControllerTest
{
    @Inject
    private GreetingService greetingService;

    @Test
    void greetingServiceProducesExpectedOutput()
    {
        String result = greetingService.createGreeting("Alice");
        Assertions.assertEquals("Hello Alice. We hope you enjoy Apache DeltaSpike!", result);
    }

    @Test
    void greetingServiceHandlesEmptyName()
    {
        String result = greetingService.createGreeting("");
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.startsWith("Hello "));
    }
}
