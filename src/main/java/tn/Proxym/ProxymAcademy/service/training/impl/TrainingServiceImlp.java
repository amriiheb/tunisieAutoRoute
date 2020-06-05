package tn.Proxym.ProxymAcademy.service.training.impl;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.web.multipart.MultipartFile;
        import tn.Proxym.ProxymAcademy.dao.training.TrainingDao;
        import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
        import tn.Proxym.ProxymAcademy.model.Training;
        import tn.Proxym.ProxymAcademy.service.image_uploader.ImageUploader;
        import tn.Proxym.ProxymAcademy.service.trainer.TrainerService;
        import tn.Proxym.ProxymAcademy.service.training.TrainingService;

        import java.util.List;
        import java.util.Optional;

@Service
public class TrainingServiceImlp  implements TrainingService {

    @Autowired
    private TrainingDao trainingDao ;

    @Autowired
    private ImageUploader imageUploader ;

    @Override
    public List<Training> findAll() {
        return trainingDao.findAll();
    }

    @Override
    public List<Training> myTrainings(Long id) {
        return trainingDao.myTrainings(id);
    }

    @Override
    public void drop(Long id) {
        trainingDao.deleteById(id);
    }

    @Override
    public Training create(TrainingCreateDtoA trainingCreateDtoA) {
        Training training=new Training() ;
        training.setCategory(trainingCreateDtoA.getCategory());
        training.setDescription(trainingCreateDtoA.getDescription());
        training.setName(trainingCreateDtoA.getName());
        training.setDifficulty(trainingCreateDtoA.getDifficulty());
        training.setNumberofhours(trainingCreateDtoA.getNumberOfHours());
        training.setTrainer(trainingCreateDtoA.getTrainer());
        MultipartFile file=trainingCreateDtoA.getPhoto() ;

        training.setPhoto(imageUploader.ImageUpload(file,"D://Workspace_spring//proxym_university//Proxym_University//upload//training"));
        return trainingDao.create(training);
    }

    @Override
    public Optional<Training> findById(Long id) {
        return trainingDao.findById(id);
    }
}
