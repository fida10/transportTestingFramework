package paxTransport.commonWebSiteFeatures.webElements;

import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class DynamicXpathCreator {
	public static String simpleDynamicXpathCreator(String xpathDynamicXpathProp, String noProp){
		//consider that there are numerous options in a dropdown menu, but they are all similar (i.e. 1 pax, 2 pax, 3 pax, etc). Instead of making an xpath for each of these, it is better to make a dynamic xpath that can be changed through properties to select what we want. That is the goal for this method.
		//noProp is the differentiator that separates the various elements on this path, which are identical otherwise. It substitutes %s.
		String fullXpath = String.format(proSpecific.getProperty(xpathDynamicXpathProp).concat(" '%s')]"), proSpecific.getProperty(noProp));
		return fullXpath;
	}
}
