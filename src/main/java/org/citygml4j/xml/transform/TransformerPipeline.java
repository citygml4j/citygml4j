package org.citygml4j.xml.transform;

import org.xml.sax.SAXException;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;

public class TransformerPipeline {
    private static SAXTransformerFactory factory;
    private final Templates[] templates;
    private TransformerHandler[] handlers;

    private TransformerPipeline(Templates[] templates) throws TransformerConfigurationException {
        this.templates = templates;
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

    public static synchronized SAXTransformerFactory getTransformerFactory() {
        if (factory == null)
            factory = (SAXTransformerFactory) TransformerFactory.newInstance();

        return factory;
    }

    public TransformerHandler getRootHandler() {
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
