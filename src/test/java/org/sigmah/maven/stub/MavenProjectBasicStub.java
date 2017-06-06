/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven.stub;

import java.io.File;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.maven.model.Build;
import org.apache.maven.model.Organization;
import org.apache.maven.project.MavenProject;

/**
 * Maven project stub.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
public class MavenProjectBasicStub extends MavenProject {

	protected Properties properties;

	public MavenProjectBasicStub() throws Exception {
		super();
		properties = new Properties();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Set getArtifacts() {
		return new HashSet();
	}

	@Override
	public String getName() {
		return "Test Sigmah Mojo";
	}

	@Override
	public File getBasedir() {
		return null;
	}

	@Override
	public String getGroupId() {
		return "org.sigmah.maven.test";
	}

	@Override
	public String getArtifactId() {
		return "maven-sigmah-plugin-test";
	}

	@Override
	public String getPackaging() {
		return "jar";
	}

	@Override
	public String getVersion() {
		return "0.0-Test";
	}

	@Override
	public Properties getProperties() {
		return properties;
	}

	@Override
	public String getDescription() {
		return "Test Description.";
	}

	@Override
	public Organization getOrganization() {
		return new Organization() {

			private static final long serialVersionUID = -2647552486721702169L;

			public String getName() {
				return "Test Name";
			}

		};
	}

	@Override
	public Build getBuild() {
		final Build build = super.getBuild();
		build.setDirectory(System.getProperty("project.build.directory"));
		return build;
	}

}
