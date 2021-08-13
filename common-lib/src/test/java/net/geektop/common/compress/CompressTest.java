package net.geektop.common.compress;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.compress
 * @date 2020/9/4 14:37
 */
@SpringBootTest
class CompressTest {

  private static final Logger logger = LoggerFactory.getLogger(CompressTest.class);


  @Test
  void compressFilesToZIP() {

  }

  @Test
  void compressDirToZIP() throws IOException {
    String dirPath = "/Users/light/print_20190725";

    try (FileOutputStream fileOutStream = new FileOutputStream("/Users/light/print_20190725.zip");
         BufferedOutputStream bufferedOutStream = new BufferedOutputStream(fileOutStream);
         final ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(bufferedOutStream)) {
      addFileToZIP(zipArchiveOutputStream, dirPath, "");
    }
  }


  private void addFileToZIP(ZipArchiveOutputStream zipArchiveOutputStream, String path, String base) throws IOException {
    final File file = new File(path);
    if (!file.exists()) {
      return;
    }

    final String entryName = base + file.getName();
    final ZipArchiveEntry archiveEntry = new ZipArchiveEntry(file, entryName);
    zipArchiveOutputStream.putArchiveEntry(archiveEntry);
    if (file.isFile()) {
      try (final InputStream in = new BufferedInputStream(new FileInputStream(file))) {
        IOUtils.copy(in, zipArchiveOutputStream);
        zipArchiveOutputStream.closeArchiveEntry();
      }
    } else {
      zipArchiveOutputStream.closeArchiveEntry();
      final File[] childFiles = file.listFiles();
      if (childFiles != null) {
        for (File child: childFiles) {
          addFileToZIP(zipArchiveOutputStream, child.getAbsolutePath(), entryName + "/");
        }
      }
    }
  }

  @Test
  void compressDirTo7Z() throws IOException {
    String dirPath = "/Users/light/print_20190725";

    final File archiveSevenZFile = new File("/Users/light/print_20190725.7z");
    try (final SevenZOutputFile sevenZOutputFile = new SevenZOutputFile(archiveSevenZFile)) {
      addFileToSevenZ(sevenZOutputFile, dirPath, "");
    }
  }

  private void addFileToSevenZ(SevenZOutputFile sevenZOutputFile, String path, String base) throws IOException {
    final File file = new File(path);
    if (!file.exists()) {
      return;
    }

    final String entryName = base + file.getName();
    final SevenZArchiveEntry archiveEntry = sevenZOutputFile.createArchiveEntry(file, entryName);
    sevenZOutputFile.putArchiveEntry(archiveEntry);
    if (file.isFile()) {
      final byte[] buffer = new byte[1024];
      int len;
      try (final InputStream in = new BufferedInputStream(new FileInputStream(file))) {
        while ((len = in.read(buffer)) > 0) {
          sevenZOutputFile.write(buffer, 0, len);
        }
      }
      sevenZOutputFile.closeArchiveEntry();
    } else {
      sevenZOutputFile.closeArchiveEntry();
      final File[] childFiles = file.listFiles();
      if (childFiles != null) {
        for (File child : childFiles) {
          addFileToSevenZ(sevenZOutputFile, child.getAbsolutePath(), entryName + "/");
        }
      }
    }
  }

  @Test
  void compressFilesTo7Z() {
  }

  @Test
  void compressFileToXZ() {
  }

  @Test
  void compressFilesToTarXZ() {
  }

  @Test
  void compressDirToTarXZ() throws IOException {
    String dirPath = "/Users/light/print_20190725";

    try (FileOutputStream fileOutStream = new FileOutputStream("/Users/light/print_20190725.tar.xz");
         BufferedOutputStream bufferedOutStream = new BufferedOutputStream(fileOutStream);
         XZCompressorOutputStream xzCompressorOutputStream = new XZCompressorOutputStream(bufferedOutStream);
         TarArchiveOutputStream tarOutStream = new TarArchiveOutputStream(xzCompressorOutputStream)) {
      addFileToTar(tarOutStream, dirPath, "");
    }
  }

  @Test
  void archiveDirToTar() throws IOException {
    String dirPath = "/Users/light/print_20190725";

    try (FileOutputStream fileOutStream = new FileOutputStream("/Users/light/print_20190725.tar");
         BufferedOutputStream bufferedOutStream = new BufferedOutputStream(fileOutStream);
         TarArchiveOutputStream tarOutStream = new TarArchiveOutputStream(bufferedOutStream)) {
      addFileToTar(tarOutStream, dirPath, "");
    }
  }

  private void addFileToTar(TarArchiveOutputStream tarOutStream, String path, String base) throws IOException {
    final File file = new File(path);
    if (!file.exists()) {
      return;
    }

    final String entryName = base + file.getName();
    final TarArchiveEntry archiveEntry = new TarArchiveEntry(file, entryName);
    tarOutStream.putArchiveEntry(archiveEntry);
    if (file.isFile()) {
      try (final InputStream in = new BufferedInputStream(new FileInputStream(file))) {
        IOUtils.copy(in, tarOutStream);
        tarOutStream.closeArchiveEntry();
      }
    } else {
      tarOutStream.closeArchiveEntry();
      final File[] childFiles = file.listFiles();
      if (childFiles != null) {
        for (File child: childFiles) {
          addFileToTar(tarOutStream, child.getAbsolutePath(), entryName + "/");
        }
      }
    }
  }

}
