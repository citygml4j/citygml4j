package org.citygml4j.xml.schema;

import java.util.HashSet;
import java.util.Set;

import org.citygml4j.visitor.walker.Walker;

import com.sun.xml.xsom.XSAnnotation;
import com.sun.xml.xsom.XSAttGroupDecl;
import com.sun.xml.xsom.XSAttributeDecl;
import com.sun.xml.xsom.XSAttributeUse;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSFacet;
import com.sun.xml.xsom.XSIdentityConstraint;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSModelGroupDecl;
import com.sun.xml.xsom.XSNotation;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSSimpleType;
import com.sun.xml.xsom.XSType;
import com.sun.xml.xsom.XSWildcard;
import com.sun.xml.xsom.XSXPath;
import com.sun.xml.xsom.visitor.XSVisitor;

public abstract class SchemaWalker implements XSVisitor, Walker {
	private final Set<Object> visited = new HashSet<Object>();
	private volatile boolean shouldWalk = true;

	public void reset() {
		visited.clear();
		shouldWalk = true;
	}
	
	public boolean shouldWalk() {
		return shouldWalk;
	}
	
	public void setShouldWalk(boolean shouldWalk) {
		this.shouldWalk = shouldWalk;
	}
	
	public boolean addToVisited(Object object) {
		return visited.add(object);
	}
	
	public boolean hasVisited(Object object) {
		return visited.contains(object);
	}
	
	public void visit(Schema schema) {
		visit(schema.schema);
	}
	
	public void visit(XSSchemaSet schemas) {
		for (XSSchema schema : schemas.getSchemas())
			if (shouldWalk && visited.add(schema))
				schema(schema);
	}
	
	public void visit(XSSchema schema) {
		if (shouldWalk && visited.add(schema))
			schema(schema);
	}

	public void annotation(XSAnnotation ann) {
	}

	public void attGroupDecl(XSAttGroupDecl decl) {
		for (XSAttributeUse u : decl.getAttributeUses())
			if (shouldWalk && visited.add(u))
				attributeUse(u);
	}

	public void attributeDecl(XSAttributeDecl decl) {
		if (shouldWalk && visited.add(decl.getType()))
			simpleType(decl.getType());
	}

	public void attributeUse(XSAttributeUse use) {
		if (shouldWalk && visited.add(use.getDecl()))
			attributeDecl(use.getDecl());
	}

	public void complexType(XSComplexType type) {
		if (shouldWalk && visited.add(type.getContentType())) {
			type.getContentType().visit(this);
			for (XSAttributeUse u : type.getAttributeUses())
				if (shouldWalk && visited.add(u))
					attributeUse(u);
		}
	}

	public void schema(XSSchema schema) {
		for (XSElementDecl e : schema.getElementDecls().values())
			if (shouldWalk && visited.add(e))
				elementDecl(e);

		for (XSAttributeDecl a : schema.getAttributeDecls().values())
			if (shouldWalk && visited.add(a))
				attributeDecl(a);

		for (XSAttGroupDecl a : schema.getAttGroupDecls().values())
			if (shouldWalk && visited.add(a))
				attGroupDecl(a);

		for (XSModelGroupDecl m : schema.getModelGroupDecls().values())
			if (shouldWalk && visited.add(m))
				modelGroupDecl(m);

		for (XSType t : schema.getTypes().values())
			if (shouldWalk && visited.add(t))
				t.visit(this);

		for (XSNotation n : schema.getNotations().values())
			if (shouldWalk && visited.add(n))
				notation(n);
	}

	public void facet(XSFacet facet) {
	}

	public void notation(XSNotation notation) {
	}

	public void identityConstraint(XSIdentityConstraint decl) {
	}

	public void xpath(XSXPath xp) {
	}

	public void wildcard(XSWildcard wc) {
	}

	public void modelGroupDecl(XSModelGroupDecl decl) {
		if (shouldWalk && visited.add(decl.getModelGroup()))
			modelGroup(decl.getModelGroup());
	}

	public void modelGroup(XSModelGroup group) {
		for (XSParticle p : group.getChildren())
			if (shouldWalk && visited.add(p))
				particle(p);
	}

	public void elementDecl(XSElementDecl decl) {
		if (shouldWalk && visited.add(decl.getType()))
			decl.getType().visit(this);
	}

	public void simpleType(XSSimpleType simpleType) {
		if (shouldWalk && visited.add(simpleType.getBaseType()))
			simpleType.getBaseType().visit(this);
	}

	public void particle(XSParticle particle) {
		if (shouldWalk && visited.add(particle.getTerm()))
			particle.getTerm().visit(this);
	}

	public void empty(XSContentType empty) {
	}
}
