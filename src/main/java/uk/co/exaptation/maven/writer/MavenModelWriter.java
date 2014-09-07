package uk.co.exaptation.maven.writer;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.model.merge.ModelMerger;

public class MavenModelWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model model = new Model();
		model.setGroupId("test-gropup");
		model.setArtifactId("test-artifact");
		model.setVersion("1.0");
		model.setModelVersion("4.0.0");
		
		Model modelToMergeWith = new Model();
		modelToMergeWith.setDescription("Test description");
		populateDependencies(modelToMergeWith);
		
		ModelMerger merger = new ModelMerger();
		merger.merge(model, modelToMergeWith, false, null);
		
		try {
			MavenXpp3Writer writer = new MavenXpp3Writer();
			writer.write(new FileOutputStream(new File("c:/temp/test-pom.xml")), model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void populateDependencies(Model model) {
		Dependency dependency = new Dependency();
		dependency.setGroupId("junit");
		dependency.setArtifactId("junit");
		dependency.setVersion("4.10");
		model.addDependency(dependency);
	}

}
