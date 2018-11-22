package fr.formation.upload;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UploadService {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private final String ROOT_DIR = "upload-dir";
    private final Path rootLocation = Paths.get(ROOT_DIR);

    public void store(MultipartFile file, String dir_name) {
        Path artist_dir = Paths.get(ROOT_DIR, dir_name);
        //FileUtils.getTempDirectory()

        try {
            Files.copy(file.getInputStream(), artist_dir.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public Resource loadFile(String filename, Path img_path) {
        try {
            Path file = img_path.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteFilesInArtistFolder(Path img_path) {
        FileSystemUtils.deleteRecursively(img_path.toFile());
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void createArtistImageDirectory(String dir_name) {
        Path img_path = Paths.get(ROOT_DIR, dir_name);

        try {
            Files.createDirectory(img_path);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}