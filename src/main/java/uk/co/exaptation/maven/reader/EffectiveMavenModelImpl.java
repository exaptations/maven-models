package uk.co.exaptation.maven.reader;

import java.io.File;

import org.apache.maven.model.Model;

public class EffectiveMavenModelImpl implements MavenModel {

	private File repository = null;

	public EffectiveMavenModelImpl(File repository) {
		this.repository = repository;
	}

	public Model getModel(File pomFile) {
		Model model = null;
		RepositoryModelResolver resolver = new RepositoryModelResolver(repository, "http://uk.maven.org/maven2");
		ModelResolver modelResolver = new ModelResolver(resolver);
		model = modelResolver.resolve(pomFile);
		return model;
	}

}
