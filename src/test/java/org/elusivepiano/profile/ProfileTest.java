package org.elusivepiano.profile;

import java.io.File;

import org.elusivepiano.profile.Profile;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ProfileTest {

	private String test = "_profile_test";
	
	@Test
	public void canCreateProfile(){
		Profile profile = Profile.loadOrCreate(test);
		Assert.assertNotNull(profile);
		Assert.assertEquals(test, profile.getName());
		
		profile.put("key", "value");
		
		Profile profile2 = Profile.loadOrCreate(test);
		Assert.assertEquals("value", profile2.get("key"));

		profile2.put("key", "value2");
		Assert.assertEquals("value2", profile2.get("key"));
		
		profile2.append("key", "more");
		Assert.assertEquals("value2 more", profile2.get("key"));
	}
	
	@After
	public void deleteTestProfile(){
		new File(Profile.profilesFolder, test).delete();
	}
}
