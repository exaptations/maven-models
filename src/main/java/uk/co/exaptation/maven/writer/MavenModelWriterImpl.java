package uk.co.exaptation.maven.writer;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.model.merge.ModelMerger;

public class MavenModelWriterImpl implements ModelWriter {

	@Override
	public void writeModel(Model model, File pomFile) {
		try {
			MavenXpp3Writer writer = new MavenXpp3Writer();
			writer.write(new FileOutputStream(pomFile), model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mergeModel(Model targetModel, Model sourceModel) {
		ModelMerger merger = new ModelMerger();
		merger.merge(targetModel, sourceModel, false, null);
	}

}
