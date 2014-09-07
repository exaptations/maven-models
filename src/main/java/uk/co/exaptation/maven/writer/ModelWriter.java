package uk.co.exaptation.maven.writer;

import java.io.File;

import org.apache.maven.model.Model;

public interface ModelWriter {
	public void writeModel(Model model, File pomFile);
	
	public void mergeModel(Model targetModel, Model sourceModel);
	
}
