/**
 *  Copyright 2010 Gunnar Morling (http://www.gunnarmorling.de/)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package de.gmorling.moapa.videorental.jmx;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Stores for a number of web service endpoints the information, whether schema
 * validation is enabled or not. This class is thread-safe.
 * 
 * @author Gunnar Morling
 */
public class ValidationConfigurationHolder {

	private static ConcurrentMap<String, Boolean> configuration = 
		new ConcurrentHashMap<String, Boolean>();
	
	public static boolean isValidationEnabled(String portName) {
		Boolean theValue = configuration.get(portName);
		
		return theValue != null ? theValue : Boolean.TRUE;
	}
	
	public static void setValidationEnabled(String portName, boolean enabled) {
		configuration.put(portName, enabled);
	}
}
