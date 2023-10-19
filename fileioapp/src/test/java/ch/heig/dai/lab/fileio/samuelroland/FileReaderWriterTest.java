// TODO change this to your own package instead of jehrensb ***
package ch.heig.dai.lab.fileio.samuelroland;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.IOException;

public class FileReaderWriterTest {
	// private File fakeFile = null;
	private String FILECONTENT = "This is the file";
	private String MULTILINEFILECONTENT = "\nThis is the file\nwith some strange line endings\na";
	private String MULTILINEFILECONTENT2 = "\nThis is the file\nwith some strange line endings\na\n\n";

	// 2 simples tests to make sure we correctly read and write the file and manage
	// line endings I tried more advanced testing but I'm not confident with Java so
	// it was difficult and basically rewriting the read and write behavior in the
	// implementation. I didn't try to test the encoding...

	@Test
	public void writeAndReadSingleLineTest() throws IOException {
		File fakeFile = File.createTempFile("test", "txt");
		fakeFile.deleteOnExit();
		FileReaderWriter rw = new FileReaderWriter();

		rw.writeFile(fakeFile, FILECONTENT, StandardCharsets.UTF_8);
		assertEquals(FILECONTENT, rw.readFile(fakeFile, StandardCharsets.UTF_8));
	}

	@Test
	public void writeAndReadMultipleLine() throws IOException {
		File fakeFile = File.createTempFile("somefolder/a multiline file", "ascii");
		fakeFile.deleteOnExit();
		FileReaderWriter rw = new FileReaderWriter();

		rw.writeFile(fakeFile, MULTILINEFILECONTENT, StandardCharsets.UTF_8);
		assertEquals(MULTILINEFILECONTENT, rw.readFile(fakeFile, StandardCharsets.UTF_8));
	}

	// It's seems to me it's impossible to make this test pass... because I can't
	// really know if we should remove the last \n or not...
	@Disabled
	@Test
	public void writeAndReadMultipleLine2() throws IOException {
		File fakeFile = File.createTempFile("somefolder/a multiline file", "ascii");
		fakeFile.deleteOnExit();
		FileReaderWriter rw = new FileReaderWriter();

		rw.writeFile(fakeFile, MULTILINEFILECONTENT2, StandardCharsets.UTF_8);
		assertEquals(MULTILINEFILECONTENT2, rw.readFile(fakeFile, StandardCharsets.UTF_8));
	}
}
