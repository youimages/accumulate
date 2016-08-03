package com.lazite.assist.pattern;

import org.junit.Test;

import com.lazite.assist.pattern.decorator.Decorator;
import com.lazite.assist.pattern.decorator.Source;
import com.lazite.assist.pattern.decorator.Sourceable;
import com.lazite.assist.pattern.proxy.Proxy;

public class CallSourceMethod {
	
	@Test
	public void callByDecorator() {  
        Sourceable source = new Source();  
        Sourceable obj = new Decorator(source);  
        obj.method();  
    }
	
	@Test
	public void callByProxy() {  
		com.lazite.assist.pattern.proxy.Sourceable source = new Proxy();  
        source.method();  
	}
}
