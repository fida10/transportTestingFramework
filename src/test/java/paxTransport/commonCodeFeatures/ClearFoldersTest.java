package paxTransport.commonCodeFeatures;

import org.testng.annotations.Test;

import java.io.IOException;

import static paxTransport.commonCodeFeatures.ScreenShotMethods.deleteOldScreenShots;

public class ClearFoldersTest {
	@Test
	public static void deleteOlderScreenShots() throws IOException {
		deleteOldScreenShots();
	}
}

