package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.CompositeCurve;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;

public class GeometricComplexPropertyImpl implements GeometricComplexProperty {
	private GeometricComplex geometricComplex;
	private CompositeCurve compositeCurve;
	private CompositeSurface compositeSurface;
	private CompositeSolid compositeSolid;
	private String actuate;
	private String arcrole;
	private String href;
	private String remoteSchema;
	private String role;
	private String show;
	private String title;
	private String type;
	private Object parent;
	
	public CompositeCurve getCompositeCurve() {
		return compositeCurve;
	}

	public CompositeSolid getCompositeSolid() {
		return compositeSolid;
	}

	public CompositeSurface getCompositeSurface() {
		return compositeSurface;
	}

	public GeometricComplex getGeometricComplex() {
		return geometricComplex;
	}

	public boolean isSetCompositeCurve() {
		return compositeCurve != null;
	}

	public boolean isSetCompositeSolid() {
		return compositeSolid != null;
	}

	public boolean isSetCompositeSurface() {
		return compositeSurface != null;
	}

	public boolean isSetGeometricComplex() {
		return geometricComplex != null;
	}

	public void setCompositeCurve(CompositeCurve compositeCurve) {
		if (compositeCurve != null)
			compositeCurve.setParent(this);
		
		this.compositeCurve = compositeCurve;
		unsetCompositeSolid();
		unsetCompositeSurface();
		unsetGeometricComplex();
	}

	public void setCompositeSolid(CompositeSolid compositeSolid) {
		if (compositeSolid != null)
			compositeSolid.setParent(this);
		
		this.compositeSolid = compositeSolid;
		unsetCompositeCurve();
		unsetCompositeSurface();
		unsetGeometricComplex();
	}

	public void setCompositeSurface(CompositeSurface compositeSurface) {
		if (compositeSurface != null)
			compositeSurface.setParent(this);
		
		this.compositeSurface = compositeSurface;
		unsetCompositeCurve();
		unsetCompositeSolid();
		unsetGeometricComplex();
	}

	public void setGeometricComplex(GeometricComplex geometricComplex) {
		if (geometricComplex != null)
			geometricComplex.setParent(this);
		
		this.geometricComplex = geometricComplex;
		unsetCompositeCurve();
		unsetCompositeSolid();
		unsetCompositeSurface();
	}

	public void unsetCompositeCurve() {
		if (compositeCurve != null)
			compositeCurve.unsetParent();
		
		compositeCurve = null;
	}

	public void unsetCompositeSolid() {
		if (compositeSolid != null)
			compositeSolid.unsetParent();
		
		compositeSolid = null;
	}

	public void unsetCompositeSurface() {
		if (compositeSurface != null)
			compositeSurface.unsetParent();
		
		compositeSurface = null;
	}

	public void unsetGeometricComplex() {
		if (geometricComplex != null)
			geometricComplex.unsetParent();
		
		geometricComplex = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRICCOMPLEXPROPERTY;
	}

	public String getActuate() {
		return actuate;
	}

	public String getArcrole() {
		return arcrole;
	}

	public String getHref() {
		return href;
	}

	public String getRemoteSchema() {
		return remoteSchema;
	}

	public String getRole() {
		return role;
	}

	public String getShow() {
		return show;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		if (type == null)
			return "simple";
		else
			return type;
	}

	public boolean isSetActuate() {
		return actuate != null;
	}

	public boolean isSetArcrole() {
		return arcrole != null;
	}

	public boolean isSetHref() {
		return href != null;
	}

	public boolean isSetRemoteSchema() {
		return remoteSchema != null;
	}

	public boolean isSetRole() {
		return role != null;
	}

	public boolean isSetShow() {
		return show != null;
	}

	public boolean isSetTitle() {
		return title != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setActuate(String actuate) {
		this.actuate = actuate;
	}

	public void setArcrole(String arcrole) {
		this.arcrole = arcrole;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setRemoteSchema(String remoteSchema) {
		this.remoteSchema = remoteSchema;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = "simple";
	}

	public void unsetActuate() {
		actuate = null;
	}

	public void unsetArcrole() {
		arcrole = null;
	}

	public void unsetHref() {
		href = null;
	}

	public void unsetRemoteSchema() {
		remoteSchema = null;
	}

	public void unsetRole() {
		role = null;
	}

	public void unsetShow() {
		show = null;
	}

	public void unsetTitle() {
		title = null;
	}

	public void unsetType() {
		type = null;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricComplexPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricComplexProperty copy = (target == null) ? new GeometricComplexPropertyImpl() : (GeometricComplexProperty)target;
		
		if (isSetGeometricComplex()) {
			copy.setGeometricComplex((GeometricComplex)copyBuilder.copy(geometricComplex));
			if (copy.getGeometricComplex() == geometricComplex)
				geometricComplex.setParent(this);
		}
		
		if (isSetCompositeCurve()) {
			copy.setCompositeCurve((CompositeCurve)copyBuilder.copy(compositeCurve));
			if (copy.getCompositeCurve() == compositeCurve)
				compositeCurve.setParent(this);
		}
		
		if (isSetCompositeSolid()) {
			copy.setCompositeSolid((CompositeSolid)copyBuilder.copy(compositeSolid));
			if (copy.getCompositeSolid() == compositeSolid)
				compositeSolid.setParent(this);
		}
		
		if (isSetCompositeSurface()) {
			copy.setCompositeSurface((CompositeSurface)copyBuilder.copy(compositeSurface));
			if (copy.getCompositeSurface() == compositeSurface)
				compositeSurface.setParent(this);
		}
		
		if (isSetActuate())
			copy.setActuate(copyBuilder.copy(actuate));

		if (isSetArcrole())
			copy.setArcrole(copyBuilder.copy(arcrole));
		
		if (isSetHref())
			copy.setHref(copyBuilder.copy(href));
		
		if (isSetRemoteSchema())
			copy.setRemoteSchema(copyBuilder.copy(remoteSchema));
		
		if (isSetRole())
			copy.setRole(copyBuilder.copy(role));
		
		if (isSetShow())
			copy.setShow(copyBuilder.copy(show));

		if (isSetTitle())
			copy.setTitle(copyBuilder.copy(title));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		copy.unsetParent();
		
		return copy;
	}

}
