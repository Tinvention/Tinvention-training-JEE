package net.tinvention.training;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;

public class InContainerUtil {

	private static EJBContainer container;

	public synchronized static EJBContainer getEJBContainer() {
		if (container == null) {
			Map<String, Object> properties = new HashMap<String, Object>();
			container = EJBContainer.createEJBContainer(properties);
		}
		return container;
	}

}
