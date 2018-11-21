package fr.formation.upload;

import fr.formation.user.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    UploadService uploadService;

    List<String> files = new ArrayList<String>();

    public ResponseEntity<String> addFile(MultipartFile file, UserInfoDTO userInfo) {

        String artist_id = userInfo.getArtistId().toString();
        Long date = new Date().getTime();
        String dir_name = artist_id.concat("_").concat(date.toString());
        String message = "";

        uploadService.createArtistImageDirectory(dir_name);

        try {
            uploadService.store(file, dir_name);
            files.add(file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
}
