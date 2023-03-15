package com.wagner.direct.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.wagner.direct.camel.processor.FileProcessor;

@Component
public class Direct extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:log-file")
			.log("Log: ${header.CamelFileName}")
			.to("direct:log-file2");
		
		from("direct:log-file2")
			.process(new FileProcessor());
		
		from("file:C:\\temp\\in\\input")
			.to("direct:log-file");
		
	}

}
