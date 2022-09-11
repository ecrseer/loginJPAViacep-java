package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.services;


import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.domain.UsuarioComEndereco;
import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.repository.UsuarioRepository;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

@Service
public class UsuarioService {
    final String DEFAULT_BUCKET = "gabecrbuck";

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AmazonService amazonService;

    public PutObjectResult editUser(UsuarioComEndereco usuario, MultipartFile multipartFile) {
        String filename = multipartFile.getOriginalFilename();
        String extension = FilenameUtils.getExtension(filename);

        String newName = "/profilePic." + extension;
        String fileKeyAWS = "users/" + usuario.getEmail() + "" + newName;
        String localPath = "src/main/resources/static/images/"
                + usuario.getEmail() + newName;

        System.out.println("localPath:::" + localPath);
        File filePointer = amazonService.convertMultiPartToFile(multipartFile, new File(localPath));
        return amazonService.uploadSetFile(DEFAULT_BUCKET, fileKeyAWS, filePointer);
    }

    public boolean loadUser(UsuarioComEndereco usuario) {

        //temp
        String extension = "png";

        String newName = "/profilePic." + extension;
        String fileKeyAWS = "users/" + usuario.getEmail() + "" + newName;
        String localPath = "src/main/resources/static/images/"
                + usuario.getEmail() + newName;

        File filePointer = new File(localPath);
        return amazonService.getFileFrom(DEFAULT_BUCKET, fileKeyAWS, filePointer);
    }

    public UsuarioComEndereco findUsuarioByEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email);
    }

    public UsuarioComEndereco save(UsuarioComEndereco usuario) {
        return this.usuarioRepository.save(usuario);
    }

}
