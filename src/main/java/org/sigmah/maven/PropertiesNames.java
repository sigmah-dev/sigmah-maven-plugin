/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven;

/**
 * Defines Sigmah properties name for Maven.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
public final class PropertiesNames {

	private PropertiesNames() {
	}

	private static final String PREFIX = "sigmah.version.";

	public static final String NUMBER = PREFIX + "number";
	public static final String NAME = PREFIX + "name";
	public static final String DATE = PREFIX + "date";
	public static final String REFERENCE = PREFIX + "reference";
	public static final String MANAGERS = PREFIX + "managers";
	public static final String PARTNERS = PREFIX + "partners";
	public static final String DEVELOPERS = PREFIX + "developers";
	public static final String CONTRIBUTORS = PREFIX + "contributors";

}
