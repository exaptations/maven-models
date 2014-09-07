package uk.co.exaptation.maven.reader;

import java.io.File;

import junit.framework.Assert;

import org.apache.maven.model.Model;
import org.junit.Test;

public class TestEffectiveMavenModelImpl {
	@Test
	public void testEffectiveMavenModel() {
		String repoProperty = System.getProperty("m2.repo.home");
		if (repoProperty == null) {
			Assert.fail("No m2.repo.home system property defined");
		} else {
			File repository = new File(repoProperty);
			EffectiveMavenModelImpl effectiveModel = new EffectiveMavenModelImpl(repository);
			Model model = effectiveModel.getModel(new File(repository, "org/apache/maven/maven/3.0.3/maven-3.0.3.pom"));
			Assert.assertEquals("org.apache.maven", model.getGroupId());
			Assert.assertEquals("maven", model.getArtifactId());
			Assert.assertEquals("3.0.3", model.getVersion());
		}
	}
}
