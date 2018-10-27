package org.citygml4j.binding.cityjson.geometry;

import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;
import java.util.List;

@JsonAdapter(VerticesListAdapter.class)
public class VerticesList {
	private transient List<List<Double>> vertices;
		
	public VerticesList(List<List<Double>> vertices) {
		this.vertices = vertices != null ? vertices : new ArrayList<>();
	}
	
	public VerticesList() {
		this(new ArrayList<>());
	}
	
	public void addVertex(List<Double> vertex)  {
		vertices.add(vertex);
	}

	public List<List<Double>> getVertices() {
		return vertices;
	}

	public void setVertices(List<List<Double>> vertices) {
		this.vertices = vertices;
	}
	
	public void clear() {
		vertices.clear();
	}
	
}
