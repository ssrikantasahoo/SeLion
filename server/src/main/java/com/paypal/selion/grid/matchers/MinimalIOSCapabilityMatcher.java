/*-------------------------------------------------------------------------------------------------------------------*\
|  Copyright (C) 2015 PayPal                                                                                          |
|                                                                                                                     |
|  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance     |
|  with the License.                                                                                                  |
|                                                                                                                     |
|  You may obtain a copy of the License at                                                                            |
|                                                                                                                     |
|       http://www.apache.org/licenses/LICENSE-2.0                                                                    |
|                                                                                                                     |
|  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed   |
|  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for  |
|  the specific language governing permissions and limitations under the License.                                     |
\*-------------------------------------------------------------------------------------------------------------------*/

package com.paypal.selion.grid.matchers;

import java.util.Map;

import org.openqa.grid.internal.utils.CapabilityMatcher;
import org.uiautomation.ios.IOSCapabilities;

final class MinimalIOSCapabilityMatcher implements CapabilityMatcher {

    private static final String BUNDLE_NAME = IOSCapabilities.BUNDLE_NAME;

    @Override
    public boolean matches(Map<String, Object> currentCapability, Map<String, Object> requestedCapability) {
        // Simply checks for CFBundleIdentifier and CFBundleName
        return (isValid(currentCapability) && isValid(requestedCapability));
    }

    /*
     * Checks the validity of a capability by checking for not-null reference and the availability of CFBundleIdentifier
     * and CFBundleName keys.
     */
    private boolean isValid(Map<String, Object> capability) {
        boolean validCapability = false;
        validCapability = capability != null && capability.containsKey(BUNDLE_NAME);
        return validCapability;
    }
}