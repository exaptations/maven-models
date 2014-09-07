package uk.co.exaptation.maven.reader;

import java.io.File;

import junit.framework.Assert;

import org.apache.maven.model.Model;
import org.junit.Test;

public class TestSimpleMavenModelImpl {
	@Test
	public void testSimpleMavenModel() {
		String repoProperty = System.getProperty("m2.repo.home");
		if (repoProperty == null) {
			Assert.fail("No m2.repo.home system property defined");
		} else {
			File repository = new File(repoProperty);
			SimpleMavenModelImpl simpleModel = new SimpleMavenModelImpl();
			Model model = simpleModel.getModel(new File(repository, "org/apache/maven/maven/3.0.3/maven-3.0.3.pom"));
			// No resolution therefore groupId is null
			Assert.assertNull(model.getGroupId());
			Assert.assertEquals("maven", model.getArtifactId());
			Assert.assertEquals("3.0.3", model.getVersion());
		}
	}
}
