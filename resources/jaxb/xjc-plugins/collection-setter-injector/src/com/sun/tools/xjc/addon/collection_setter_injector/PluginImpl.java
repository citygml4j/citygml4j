/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License).  You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://glassfish.dev.java.net/public/CDDLv1.0.html or
 * glassfish/bootstrap/legal/CDDLv1.0.txt.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at glassfish/bootstrap/legal/CDDLv1.0.txt.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * you own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 */

package com.sun.tools.xjc.addon.collection_setter_injector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.xml.sax.ErrorHandler;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.generator.bean.ClassOutlineImpl;
import com.sun.tools.xjc.generator.bean.MethodWriter;
import com.sun.tools.xjc.model.CPropertyInfo;
import com.sun.tools.xjc.model.CTypeInfo;
import com.sun.tools.xjc.outline.Aspect;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.FieldOutline;
import com.sun.tools.xjc.outline.Outline;
import com.sun.xml.bind.api.impl.NameConverter;

/**
 * This Plugin will generate <tt>setter</tt> <tt>methods</tt>
 * for Collection-based properties. <p> The default binding compiler
 * behavior generates a <tt>getter</tt> method for Collection-based
 * properties so the user must pickup a reference to the Collection
 * and add the desired item. The following snippet:
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{http://www.objectweb.org}sql" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.objectweb.org}definitionInclude" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.objectweb.org}importDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.objectweb.org}restartCounter" minOccurs="0"/>
 *         &lt;element ref="{http://www.objectweb.org}variables" minOccurs="0"/>
 *         &lt;element ref="{http://www.objectweb.org}jdbcDefaultParameters" minOccurs="0"/>
 *         &lt;element ref="{http://www.objectweb.org}echo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.objectweb.org}copyTable" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * Generates a Java class with the following method.:
 * <pre>
 *  public List&lt;Object> getSqlOrDefinitionIncludeOrImportDefinition() {
 *      if (sqlOrDefinitionIncludeOrImportDefinition == null) {
 *          sqlOrDefinitionIncludeOrImportDefinition = new ArrayList&lt;Object>();
 *      }
 *      return this.sqlOrDefinitionIncludeOrImportDefinition;
 *  }
 * </pre>
 *
 * This plugin will generate the setter part of the method such as.:
 * <pre>
 * <b>
 *  public void setSqlOrDefinitionIncludeOrImportDefinition(List&lt;Object> sqlOrDefinitionIncludeOrImportDefinition){
 *      this.sqlOrDefinitionIncludeOrImportDefinition = sqlOrDefinitionIncludeOrImportDefinition;
 *  }
 * </b>
 * </pre>
 *
 * <pre>
 *  This plugin has been patched for use with the citygml4j library according to the following bug report.
 *  Reason for the patch is that the plugin did not work with JAXB global binding "generateIsSetMethod" set to true.
 * <b>
 *  http://www.nabble.com/collection-setter-injector-plugin-does-not-work--fix-patch-included--td24653584.html
 * </b>
 * </pre>
 * 
 * @author Marcos
 * @see <a href="https://jaxb.dev.java.net/servlets/ReadMsg?list=users&msgNo=6594">
 *      https://jaxb.dev.java.net/servlets/ReadMsg?list=users&msgNo=6594</a>
 */
public class PluginImpl extends Plugin {

	private ClassOutlineImpl outline;
	private CPropertyInfo prop;
	private JType implType;
	private JType exposedType;
	private JCodeModel codeModel;

	/**
	 * Field declaration of the actual
	 * list object that we use to store data.
	 */
	private JFieldVar field;


	public String getOptionName() {
		return "Xcollection-setter-injector";
	}

	public List<String> getCustomizationURIs() {
		return Collections.singletonList(Const.NS);
	}

	public boolean isCustomizationTagName(String nsUri, String localName) {
		return nsUri.equals(Const.NS) && localName.equals("collection");
	}

	public String getUsage() {
		return "  -Xcollection-setter-injector\t:  add setter method for collection-based properties";
	}

	// The injection of setter methods for
	// "Collection-based" fields starts here
	public boolean run(Outline model, Options opt, ErrorHandler errorHandler) {

		FieldOutline[] fo = null;

		for( ClassOutline co : model.getClasses() ) {
			if (null != (fo = co.getDeclaredFields()) &&
					0 < fo.length){
				for (int i = 0; i < fo.length; i++) {
					if (fo[i].getPropertyInfo().isCollection()) {
						declareMethod((ClassOutlineImpl) co, fo[i]); 
					}
				}
			}
		}

		return true;
	}

	// TODO --marcos Add binding support, fireXXX methods
	/**
	 * Declares the <tt>setter</tt> method for Collection based properties.
	 *
	 * @param context <tt>ClassOutlineImpl</tt> that generates the
	 *        {@link com.sun.tools.xjc.generator.bean.MethodWriter}
	 *        to write the <tt>setter</tt>s for the Collection-based
	 *        properties
	 *
	 * @param field <tt>UntypedListField</tt> that will have the
	 *        <tt>setter</t> againt it, by this way the field will
	 *        be correctly encoded by {@link java.Osbeans.XMLEncoder}
	 *        based routines
	 */
	private void declareMethod(ClassOutlineImpl context, FieldOutline field){ 

		MethodWriter writer = context.createMethodWriter();
		Map <String,JFieldVar> fields = null;
		NameConverter nc = context.parent().getModel().getNameConverter();

		outline = context;
		codeModel = context.parent().getCodeModel();
		prop = field.getPropertyInfo();

		// Retrieve the Map that contains the field name
		// and the correspondind JFieldVar
		fields = outline.implClass.fields();

		// Obtains a reference to the collection-based field
		this.field = fields.get(field.getPropertyInfo().getName(false));

		// Creates the method
		JMethod $set = writer.declareMethod(codeModel.VOID, "set" + prop.getName(true));
		// Creates the JVar that will hold the method's parameter
		JVar $value = writer.addParameter( this.field.type(), prop.getName(false));
		// Creates the methods's JBlock
		JBlock body = $set.body();
		// Creates the assignment (method parameter to instance variable)
		body.assign(JExpr._this().ref(ref()), castToImplType($value));

		// Writes javadoc for the methods
		String javadoc = prop.javadoc;        
		List<Object> possibleTypes = listPossibleTypes(prop);
		javadoc = prop.javadoc;
		if(javadoc.length() == 0)
			javadoc = Messages.DEFAULT_SETTER_JAVADOC.format(nc.toVariableName(prop.getName(true)));
		writer.javadoc().append(javadoc);
		writer.javadoc().addParam($value)
		.append("allowed object is\n")
		.append(possibleTypes);
	}

	/**
	 * Returns contents to be added to javadoc.
	 * <p>
	 * <b>Description and code copied from the class SingleField</b>
	 *
	 * @see <a href="https://jaxb2-commons.dev.java.net/source/browse/jaxb2-commons/property-listener-injector/src/com/sun/tools/xjc/addon/property_listener_injector/SingleField.java">
	 * https://jaxb2-commons.dev.java.net/source/browse/jaxb2-commons/property-listener-injector/src/com/sun/tools/xjc/addon/property_listener_injector/SingleField.java</a>
	 */
	protected final List<Object> listPossibleTypes( CPropertyInfo prop ) {
		List<Object> r = new ArrayList<Object>();
		for( CTypeInfo tt : prop.ref() ) {
			JType t = tt.getType().toType(outline.parent(),Aspect.EXPOSED);
			if( t.isPrimitive() || t.isArray() )
				r.add(t.fullName());
			else {
				r.add(t);
				r.add("\n");
			}
		}

		return r;
	}    

	/**
	 * <b>Code copied from the class SingleField</b>
	 *
	 * @see <a href="https://jaxb2-commons.dev.java.net/source/browse/jaxb2-commons/property-listener-injector/src/com/sun/tools/xjc/addon/property_listener_injector/SingleField.java">
	 * https://jaxb2-commons.dev.java.net/source/browse/jaxb2-commons/property-listener-injector/src/com/sun/tools/xjc/addon/property_listener_injector/SingleField.java</a>
	 */
	protected JFieldVar ref() {
		return field;
	}

	/**
	 * Case from {@link #exposedType} to {@link #implType} if necessary.
	 * <p>
	 * <b>Description and code copied from the class SingleField</b>
	 *
	 * @see <a href="https://jaxb2-commons.dev.java.net/source/browse/jaxb2-commons/property-listener-injector/src/com/sun/tools/xjc/addon/property_listener_injector/SingleField.java">
	 * https://jaxb2-commons.dev.java.net/source/browse/jaxb2-commons/property-listener-injector/src/com/sun/tools/xjc/addon/property_listener_injector/SingleField.java</a>
	 */
	protected final JExpression castToImplType( JExpression exp ) {
		if (implType==exposedType)
			return exp;
		else
			return JExpr.cast(implType,exp);
	}

}
