package uk.co.exaptation.maven.reader;

import java.io.File;

import org.apache.maven.model.Model;

public interface MavenModel {
	public Model getModel(File pomFile);
}
