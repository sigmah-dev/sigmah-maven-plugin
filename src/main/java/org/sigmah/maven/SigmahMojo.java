/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Set up Sigmah properties from the pom configuration.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
@Mojo(name = "sigmah", defaultPhase = LifecyclePhase.INITIALIZE, requiresDependencyResolution = ResolutionScope.RUNTIME)
public class SigmahMojo extends AbstractMojo {

	/**
	 * Sigmah version.
	 */
	@Parameter
	private Version version;

	/**
	 * Items separator for list.
	 */
	@Parameter(defaultValue = ";")
	private String valuesSeparator;

	/**
	 * Fields separator for complex objects.
	 */
	@Parameter(defaultValue = ",")
	private String fieldsSeparator;

	/**
	 * List of Sigmah managers.
	 */
	@Parameter
	private List<Manager> managers;

	/**
	 * List of Sigmah partners.
	 */
	@Parameter
	private List<Partner> partners;

	/**
	 * List of Sigmah developers.
	 */
	@Parameter
	private List<Developer> developers;

	/**
	 * List of Sigmah contributors.
	 */
	@Parameter
	private List<Contributor> contributors;

	/**
	 * {@inheritDoc}
	 */
	// @Override
	public void execute() throws MojoExecutionException {

		final StringBuilder sb = new StringBuilder();
		String propertyName;

		// ----------
		// Version.
		// ----------

		// Number.
		sb.setLength(0);
		propertyName = PropertiesNames.NUMBER;
		if (version != null && version.getNumber() != null) {
			sb.append(version.getNumber().trim());
			setProjectProperty(propertyName, sb.toString());
			// setProfileProperty(propertyName, sb.toString());
			getLog().debug("Sets " + propertyName + " = " + getProject().getProperties().getProperty(propertyName));
		}

		// Name.
		sb.setLength(0);
		propertyName = PropertiesNames.NAME;
		if (version != null && version.getName() != null) {
			sb.append(version.getName().trim());
			setProjectProperty(propertyName, sb.toString());
			// setProfileProperty(propertyName, sb.toString());
			getLog().debug("Sets " + propertyName + " = " + getProject().getProperties().getProperty(propertyName));
		}

		// Date.
		sb.setLength(0);
		propertyName = PropertiesNames.DATE;
		if (version != null && version.getDate() != null) {
			sb.append(version.getDate().trim());
			setProjectProperty(propertyName, sb.toString());
			// setProfileProperty(propertyName, sb.toString());
			getLog().debug("Sets " + propertyName + " = " + getProject().getProperties().getProperty(propertyName));
		}

		// Reference.
		sb.setLength(0);
		propertyName = PropertiesNames.REFERENCE;
		sb.append(getProject().getVersion());
		sb.append(" - ");
		sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		setProjectProperty(propertyName, sb.toString());
		// setProfileProperty(propertyName, sb.toString());
		getLog().debug("Sets " + propertyName + " = " + getProject().getProperties().getProperty(propertyName));

		// ----------
		// Managers.
		// ----------

		sb.setLength(0);
		propertyName = PropertiesNames.MANAGERS;

		if (managers != null && managers.size() > 0) {

			// Builds the property value.
			for (final ListIterator<Manager> it = managers.listIterator(); it.hasNext();) {
				final Manager manager = it.next();
				sb.append(manager.getName());
				sb.append(fieldsSeparator);
				sb.append(manager.getUrl());
				if (it.hasNext()) {
					sb.append(valuesSeparator);
				}
			}

		}

		// Sets the Maven property.
		setProjectProperty(propertyName, sb.toString());
		// setProfileProperty(propertyName, sb.toString());
		getLog().debug("Sets " + propertyName + " = " + getProject().getProperties().getProperty(propertyName));

		// ----------
		// Partners.
		// ----------

		sb.setLength(0);
		propertyName = PropertiesNames.PARTNERS;

		if (partners != null && partners.size() > 0) {

			// Builds the property value.
			for (final ListIterator<Partner> it = partners.listIterator(); it.hasNext();) {
				final Partner partner = it.next();
				sb.append(partner.getName());
				sb.append(fieldsSeparator);
				sb.append(partner.getRoleCode());
				sb.append(fieldsSeparator);
				sb.append(partner.getUrl());
				if (it.hasNext()) {
					sb.append(valuesSeparator);
				}
			}

		}

		// Sets the Maven property.
		setProjectProperty(propertyName, sb.toString());
		// setProfileProperty(propertyName, sb.toString());
		getLog().debug("Sets " + propertyName + " = " + getProject().getProperties().getProperty(propertyName));

		// ----------
		// Developers.
		// ----------

		sb.setLength(0);
		propertyName = PropertiesNames.DEVELOPERS;

		if (developers != null && developers.size() > 0) {

			// Sorts the collection.
			Collections.sort(developers, new Comparator<Developer>() {

				/**
				 * {@inheritDoc}
				 */
				// @Override
				public int compare(Developer o1, Developer o2) {
					return o1.getName().compareToIgnoreCase(o2.getName());
				}

			});

			// Builds the property value.
			for (final ListIterator<Developer> it = developers.listIterator(); it.hasNext();) {
				final Developer developer = it.next();
				sb.append(developer.getName());
				sb.append(fieldsSeparator);
				sb.append(developer.getEmail());
				if (it.hasNext()) {
					sb.append(valuesSeparator);
				}
			}

		}

		// Sets the Maven property.
		setProjectProperty(propertyName, sb.toString());
		// setProfileProperty(propertyName, sb.toString());
		getLog().debug("Sets " + propertyName + " = " + getProject().getProperties().getProperty(propertyName));

		// ----------
		// Contributors.
		// ----------

		sb.setLength(0);
		propertyName = PropertiesNames.CONTRIBUTORS;

		if (contributors != null && contributors.size() > 0) {

			// Sorts the collection.
			Collections.sort(contributors, new Comparator<Contributor>() {

				/**
				 * {@inheritDoc}
				 */
				// @Override
				public int compare(Contributor o1, Contributor o2) {
					return o1.getName().compareToIgnoreCase(o2.getName());
				}

			});

			// Builds the property value.
			for (final ListIterator<Contributor> it = contributors.listIterator(); it.hasNext();) {
				final Contributor contributor = it.next();
				sb.append(contributor.getName());
				sb.append(fieldsSeparator);
				sb.append(contributor.getEmail());
				if (it.hasNext()) {
					sb.append(valuesSeparator);
				}
			}

		}

		// Sets the Maven property.
		setProjectProperty(propertyName, sb.toString());
		// setProfileProperty(propertyName, sb.toString());
		getLog().debug("Sets " + propertyName + " = " + getProject().getProperties().getProperty(propertyName));

	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public String getValuesSeparator() {
		return valuesSeparator;
	}

	public void setValuesSeparator(String valuesSeparator) {
		this.valuesSeparator = valuesSeparator;
	}

	public String getFieldsSeparator() {
		return fieldsSeparator;
	}

	public void setFieldsSeparator(String fieldsSeparator) {
		this.fieldsSeparator = fieldsSeparator;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public List<Partner> getPartners() {
		return partners;
	}

	public void setPartners(List<Partner> partners) {
		this.partners = partners;
	}

	public List<Contributor> getContributors() {
		return contributors;
	}

	public void setContributors(List<Contributor> contributors) {
		this.contributors = contributors;
	}

}
