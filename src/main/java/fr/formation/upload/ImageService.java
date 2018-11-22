package fr.formation.upload;

import fr.formation.user.UserInfoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    UploadService uploadService;
    @Autowired
    ImageRepository imageRepository;

    List<String> files = new ArrayList<String>();

    public void addDefaultImage() {
        String img_path = "img_default".concat(System.getProperty("file.separator")).concat("default.jpg").replace("\"", "/");
        Image image = new Image("default.jpg", img_path);
        imageRepository.save(image);
    }

    public Image addFile(MultipartFile file, UserInfoDTO userInfo) {

        log.info("File Name : " + file.getOriginalFilename());
        log.info("File Type : " + file.getContentType());

        String ROOT_DIR = "upload-dir";
        String artist_id = userInfo.getArtistId().toString();
        Long date = new Date().getTime();
        String dir_name = artist_id.concat("_").concat(date.toString());
        String img_path = ROOT_DIR.concat(System.getProperty("file.separator")).concat(dir_name).concat(System.getProperty("file.separator"))
                .concat(file.getOriginalFilename()).replace("\\", "/");
        String message = "";

        uploadService.createArtistImageDirectory(dir_name);

        try {
            uploadService.store(file, dir_name);
            files.add(file.getOriginalFilename());
            Image image = new Image(file.getOriginalFilename(), img_path);

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            //return ResponseEntity.status(HttpStatus.OK).body(message);
            return image;
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            //return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            return null;
        }
    }

    @ResponseBody
    public ResponseEntity<Resource> getImage(String filename, Path img_path) {
        Resource file = uploadService.loadFile(filename, img_path);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    public Image getDefaultImg() {

        Image image = imageRepository.findDefaultImage();
        return image;
    }
}
