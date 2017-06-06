/**
 * ### COPYRIGHT NOTICE ###
 * 
 * All Sigmah Maven Plugin code is released under the GNU General Public License v3 (GPL-3).
 * See COPYRIGHT and LICENSE.
 */

package org.sigmah.maven;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Assert;
import org.sigmah.maven.stub.MavenProjectBasicStub;

/**
 * Tests the {@link SigmahMojo}.
 * 
 * @author Tom Miette (tmiette@ideia.fr)
 */
public class SigmahMojoTest extends AbstractMojoTestCase {

	/**
	 * {@inheritDoc}
	 */
	// @Override
	protected void setUp() throws Exception {
		// required
		super.setUp();
	}

	/**
	 * {@inheritDoc}
	 */
	// @Override
	protected void tearDown() throws Exception {
		// required
		super.tearDown();
	}

	/**
	 * Launches the test.
	 */
	public void testMojo() throws Exception {

		// Retrieves test pom file.
		final File pom = getTestFile("src/test/resources/project-to-test/pom.xml");
		Assert.assertNotNull(pom);
		Assert.assertTrue(pom.exists());

		// Set up the mojo.
		final SigmahMojo mojo = (SigmahMojo) lookupMojo("sigmah", pom);
		mojo.setProject(new MavenProjectBasicStub());
		Assert.assertNotNull(mojo);

		// Executes default goal.
		mojo.execute();

		// Checks properties.
		Assert.assertEquals("2.0", mojo.getProject().getProperties().getProperty(PropertiesNames.NUMBER));
		Assert.assertEquals("Brahmapoutre", mojo.getProject().getProperties().getProperty(PropertiesNames.NAME));
		Assert.assertEquals("07/2014", mojo.getProject().getProperties().getProperty(PropertiesNames.DATE));
		Assert.assertTrue(mojo.getProject().getProperties().getProperty(PropertiesNames.REFERENCE)
			.startsWith("0.0-Test - "));
		Assert.assertEquals("Coop\\u00E9rative de pilotage,http\\://www.sigmah.org;Groupe URD,http\\://www.urd.org", mojo
			.getProject().getProperties().getProperty(PropertiesNames.MANAGERS));
		Assert
			.assertEquals(
				"IDEIA,DEV,http://www.ideia.fr;Adergo,DES,http://www.adergo.com;Philippe Rouanet,GRA,http://www.philipperouanet.com",
				mojo.getProject().getProperties().getProperty(PropertiesNames.PARTNERS));
		Assert.assertEquals(
			"Denis Colliot,dcolliot@ideia.fr;Raphaël Calabro,rcalabro@ideia.fr;Tom Miette,tmiette@ideia.fr", mojo
				.getProject().getProperties().getProperty(PropertiesNames.DEVELOPERS));
		Assert.assertEquals("Olivier Sarrat,osarrat@urd.org;Oussama Mojahed,omojahed@ideia.fr", mojo.getProject()
			.getProperties().getProperty(PropertiesNames.CONTRIBUTORS));

	}

}
