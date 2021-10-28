/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.xml.transform;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import java.util.Objects;

public class TransformerPipeline {
    private static SAXTransformerFactory factory;
    private final Templates[] templates;
    private TransformerHandler[] handlers;

    private TransformerPipeline(Templates[] templates) throws TransformerConfigurationException {
        this.templates = templates;
        buildPipeline();
    }

    public TransformerPipeline(TransformerPipeline other) throws TransformerConfigurationException {
        Objects.requireNonNull(other, "Transformation pipeline must not be null.");
        templates = other.templates;
        handlers = other.handlers;
        buildPipeline();
    }

    public static TransformerPipeline newInstance(Templates... templates) throws TransformerConfigurationException {
        if (templates == null || templates.length == 0)
            throw new IllegalArgumentException("No transformation templates provided.");

        return new TransformerPipeline(templates);
    }

    public static TransformerPipeline newInstance(Source... xsltSource) throws TransformerConfigurationException {
        if (xsltSource == null || xsltSource.length == 0)
            throw new IllegalArgumentException("No transformation sources provided.");

        SAXTransformerFactory factory = getTransformerFactory();
        Templates[] templates = new Templates[xsltSource.length];
        for (int i = 0; i < xsltSource.length; i++)
            templates[i] = factory.newTemplates(xsltSource[i]);

        return newInstance(templates);
    }

    static synchronized SAXTransformerFactory getTransformerFactory() {
        if (factory == null)
            factory = (SAXTransformerFactory) TransformerFactory.newInstance();

        return factory;
    }

    public ContentHandler getRootHandler() {
        return handlers[0];
    }

    public void setResult(Result outputTarget) {
        handlers[handlers.length - 1].setResult(outputTarget);
    }

    public void transform(Source xmlSource, Result outputTarget, boolean isFragment) throws TransformerException {
        try {
            setResult(outputTarget);
            if (isFragment)
                handlers[0].startDocument();

            getTransformerFactory().newTransformer().transform(xmlSource, new SAXResult(handlers[0]));

            if (isFragment)
                handlers[0].endDocument();
        } catch (SAXException e) {
            throw new TransformerException("Caused by:", e);
        }
    }

    public void reset() throws TransformerException {
        buildPipeline();
    }

    public Object getParameter(String name) {
        return handlers[0].getTransformer().getParameter(name);
    }

    public void setParameter(String name, Object value) {
        for (TransformerHandler handler : handlers)
            handler.getTransformer().setParameter(name, value);
    }

    public String getOutputProperty(String name) {
        return handlers[0].getTransformer().getOutputProperty(name);
    }

    public void setOutputProperty(String name, String value) {
        for (TransformerHandler handler : handlers)
            handler.getTransformer().setOutputProperty(name, value);
    }

    public ErrorListener getErrorListener() {
        return handlers[0].getTransformer().getErrorListener();
    }

    public void setErrorListener(ErrorListener listener) {
        for (TransformerHandler handler : handlers)
            handler.getTransformer().setErrorListener(listener);
    }

    public URIResolver getURIResolver() {
        return handlers[0].getTransformer().getURIResolver();
    }

    public void setURIResolver(URIResolver resolver) {
        for (TransformerHandler handler : handlers)
            handler.getTransformer().setURIResolver(resolver);
    }

    private void buildPipeline() throws TransformerConfigurationException {
        SAXTransformerFactory factory = getTransformerFactory();
        handlers = new TransformerHandler[templates.length];

        for (int i = templates.length - 1; i >= 0; i--) {
            handlers[i] = factory.newTransformerHandler(templates[i]);
            if (i < templates.length - 1)
                handlers[i].setResult(new SAXResult(handlers[i + 1]));
        }
    }
}
