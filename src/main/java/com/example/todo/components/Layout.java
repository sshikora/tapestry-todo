package com.example.todo.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

/**
 * Layout component that provides the common HTML structure.
 */
@Import(stylesheet = "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css")
public class Layout {

    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    @Property
    private String title;
}
