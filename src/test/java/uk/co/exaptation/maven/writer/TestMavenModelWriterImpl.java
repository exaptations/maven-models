package uk.co.exaptation.maven.writer;

import java.io.File;

import junit.framework.Assert;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.junit.Test;

import uk.co.exaptation.maven.reader.SimpleMavenModelImpl;

public class TestMavenModelWriterImpl {
	@Test
	public void testtMavenModelWriter() {
		Model model = getSimpleModel();
		Model modelToMergeWith = getModelToMergeWith();
		
		MavenModelWriterImpl modelWriter = new MavenModelWriterImpl();
		modelWriter.mergeModel(model, modelToMergeWith);
		
		File pomFile = getTmpPomFileLocation();
		modelWriter.writeModel(model, pomFile);
		
		SimpleMavenModelImpl simpleMaven = new SimpleMavenModelImpl();
		Model mergedModel = simpleMaven.getModel(pomFile);
		Assert.assertEquals("Test description", mergedModel.getDescription());
		Assert.assertEquals(1, mergedModel.getDependencies().size());
	}

	private File getTmpPomFileLocation() {
		String tempDirPath = System.getProperty("java.io.tmpdir");
		File tempDir = new File(tempDirPath);
		File pomFile = new File(tempDir, "test-maven.pom");
		return pomFile;
	}

	private Model getSimpleModel() {
		Model model = new Model();
		model.setGroupId("test-gropup");
		model.setArtifactId("test-artifact");
		model.setVersion("1.0");
		model.setModelVersion("4.0.0");
		return model;
	}

	private Model getModelToMergeWith() {
		Model model = new Model();
		model.setDescription("Test description");
		populateDependencies(model);
		return model;
	}

	private void populateDependencies(Model model) {
		Dependency dependency = new Dependency();
		dependency.setGroupId("junit");
		dependency.setArtifactId("junit");
		dependency.setVersion("4.10");
		model.addDependency(dependency);
	}

}
