package tn.Proxym.ProxymAcademy.service.conference;

import tn.Proxym.ProxymAcademy.dto.conference.ConferenceDto;
import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
import tn.Proxym.ProxymAcademy.dto.trainingCategory.TrainingCategoryDto;
import tn.Proxym.ProxymAcademy.model.Conference;
import tn.Proxym.ProxymAcademy.model.Training;
import tn.Proxym.ProxymAcademy.model.TrainingCategory;
import tn.Proxym.ProxymAcademy.service.IOperationsService;

import java.util.List;
import java.util.Optional;

public interface ConferenceService  {
    Conference create (ConferenceDto conferenceDto, String path) ;
    List<Conference> findAll() ;
    void drop(Long id) ;
    Optional<Conference> findById(Long id);
}
