/*
 * Copyright 2010-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.batch.item.xml;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.security.ArrayTypePermission;
import com.thoughtworks.xstream.security.ExplicitTypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;

import org.springframework.batch.item.xml.domain.Trade;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.xstream.XStreamMarshaller;

public class XStreamUnmarshallingTests extends AbstractStaxEventReaderItemReaderTests {

	@Override
	protected Unmarshaller getUnmarshaller() throws Exception {
		XStreamMarshaller unmarshaller = new XStreamMarshaller();
		Map<String,Class<?>> aliasesMap = new HashMap<>();
		aliasesMap.put("trade", Trade.class);
		aliasesMap.put("isin", String.class);
		aliasesMap.put("customer", String.class);
		aliasesMap.put("price", BigDecimal.class);
		/*unmarshaller.addAlias("trade", Trade.class);
		unmarshaller.addAlias("isin", String.class);
		unmarshaller.addAlias("customer", String.class);
		unmarshaller.addAlias("price", BigDecimal.class);*/
		unmarshaller.setAliases(aliasesMap);
		unmarshaller.setTypePermissions(new ExplicitTypePermission(new String[]{"org.springframework.batch.item.xml.domain.Trade"}));
		return unmarshaller;
	}

}
