import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.copy.DeepCopyBuilder;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.commons.gmlid.DefaultGMLIdManager;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.visitor.walker.GMLWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityModelWriter;

public class TranslateScaleAndRotate {

	public static void main(String[] args) throws Exception {
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_Building_v100.xml"));

		CityModel cityModel = (CityModel)reader.nextFeature();
		Building building = (Building)cityModel.getCityObjectMember().get(0).getCityObject();

		DeepCopyBuilder copyBuilder = new DeepCopyBuilder();
		Building copy = (Building)building.copy(copyBuilder);

		BoundingShape boundedBy = copy.calcBoundedBy(false);
		BoundingBox bbox = boundedBy.getEnvelope().toBoundingBox();
		double width = bbox.getUpperCorner().getX() - bbox.getLowerCorner().getX();
		
		GMLVisitor gmlVisitor = new GMLVisitor(2 * width, 2, 90);
		copy.visit(gmlVisitor);

		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		
		CityModelWriter writer = out.createCityModelWriter(new File("LOD2_Building_v100.xml"));
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v1_0_0);
		writer.setIndentString("  ");
		
		writer.writeStartDocument();
		writer.writeFeatureMember(building);
		writer.writeFeatureMember(copy);
		writer.writeEndDocument();
		
		writer.close();
	}

	private static class GMLVisitor extends GMLWalker {
		private Matrix translate;
		private Matrix scale;
		private Matrix rotate;
		
		GMLVisitor(double translateBy, double scaleBy, double rotateBy) {
			translate = new Matrix(new double[][]{
					{1,0,0,translateBy},
					{0,1,0,0},
					{0,0,1,0},
					{0,0,0,1}});
			
			scale = new Matrix(new double[][]{
					{scaleBy,0,0,0},
					{0,scaleBy,0,0},
					{0,0,scaleBy,0},
					{0,0,0,1}});
			
			rotateBy = Math.toRadians(90);
			rotate = new Matrix(new double[][]{
					{Math.cos(rotateBy),-Math.sin(rotateBy),0,0},
					{Math.sin(rotateBy),Math.cos(rotateBy),0,0},
					{0,0,1,0},
					{0,0,0,1}});
		}
		
		@Override
		public void accept(AbstractGML abstractGML) {
			if (abstractGML.isSetId())
				abstractGML.setId(DefaultGMLIdManager.getInstance().generateGmlId());
			
			super.accept(abstractGML);
		}

		@Override
		public void accept(LinearRing linearRing) {

			if (linearRing.isSetPosList()) {
				DirectPositionList posList = linearRing.getPosList();
				List<Double> points = posList.toList3d();
				List<Double> newPoints = new ArrayList<Double>();

				for (int i = 0; i < points.size(); i += 3) {
					double[] vals = new double[]{ points.get(i), points.get(i+1), points.get(i+2), 1};
					Matrix v = new Matrix(vals, 1);
					Matrix trans = rotate.times(scale.times(translate));
					
					double[] newVals = trans.times(v.transpose()).toColumnPackedArray();
					newPoints.add(newVals[0]);
					newPoints.add(newVals[1]);
					newPoints.add(newVals[2]);
				}
				
				posList.setValue(newPoints);
			}

			super.accept(linearRing);
		}
	}
}
