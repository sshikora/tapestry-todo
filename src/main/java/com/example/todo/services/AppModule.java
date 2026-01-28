package com.example.todo.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.commons.OrderedConfiguration;
import org.apache.tapestry5.http.services.Request;
import org.apache.tapestry5.http.services.RequestFilter;
import org.apache.tapestry5.http.services.RequestHandler;
import org.apache.tapestry5.http.services.Response;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StackExtension;
import org.apache.tapestry5.services.javascript.StackExtensionType;
import org.slf4j.Logger;

import java.io.IOException;

/**
 * Tapestry IoC module for the Todo application.
 */
public class AppModule {

    public static void bind(ServiceBinder binder) {
        binder.bind(TodoService.class, TodoServiceImpl.class);
    }

    public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.PRODUCTION_MODE, false);
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
    }

    @Contribute(JavaScriptStack.class)
    public static void setupCoreOverrides(OrderedConfiguration<StackExtension> configuration) {
        // Add Tailwind CSS via CDN
        configuration.add("tailwind-css",
                new StackExtension(StackExtensionType.STYLESHEET,
                    "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"));
    }

    public RequestFilter buildTimingFilter(final Logger log) {
        return new RequestFilter() {
            public boolean service(Request request, Response response, RequestHandler handler)
                    throws IOException {
                long startTime = System.currentTimeMillis();
                try {
                    return handler.service(request, response);
                } finally {
                    long elapsed = System.currentTimeMillis() - startTime;
                    log.info("Request time: {} ms", elapsed);
                }
            }
        };
    }

    public void contributeRequestHandler(OrderedConfiguration<RequestFilter> configuration,
                                         @Local RequestFilter filter) {
        configuration.add("Timing", filter);
    }
}
