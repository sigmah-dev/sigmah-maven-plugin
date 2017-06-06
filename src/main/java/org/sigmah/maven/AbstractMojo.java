/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven;

import java.util.List;

import org.apache.maven.model.Profile;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.project.MavenProject;

/**
 * Abstract Sigmah mojo definition.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
public abstract class AbstractMojo extends org.apache.maven.plugin.AbstractMojo {

	/**
	 * Maven project.
	 */
	@Component
	private MavenProject project;

	public AbstractMojo() {
	}

	public MavenProject getProject() {
		return project;
	}

	public void setProject(MavenProject project) {
		this.project = project;
	}

	/**
	 * Sets a property into the Maven project.
	 * 
	 * @param name
	 *          The property's name.
	 * @param value
	 *          The property's value.
	 */
	protected void setProjectProperty(String name, String value) {

		if (project != null) {
			project.getProperties().setProperty(name, value);
		}

	}

	/**
	 * Sets a property into the Maven active profile.
	 * 
	 * @param name
	 *          The property's name.
	 * @param value
	 *          The property's value.
	 */
	protected void setProfileProperty(String name, String value) {

		if (project != null) {

			@SuppressWarnings("unchecked")
			final List<Profile> profiles = (List<Profile>) project.getActiveProfiles();

			if (profiles != null && profiles.size() > 0) {
				final Profile profile = profiles.get(0);
				if (profile != null) {
					profile.getProperties().setProperty(name, value);
				}
			}

		}

	}

}
