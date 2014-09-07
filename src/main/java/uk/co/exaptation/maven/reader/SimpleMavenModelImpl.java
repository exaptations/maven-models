package uk.co.exaptation.maven.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

public class SimpleMavenModelImpl implements MavenModel {

	public Model getModel(File pomFile) {
		Model model = null;
		try {
			MavenXpp3Reader reader = new MavenXpp3Reader();
			model = reader.read(getInputStream(pomFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	private InputStream getInputStream(File pomFile) throws FileNotFoundException {
		return new FileInputStream(pomFile);
	}

}
