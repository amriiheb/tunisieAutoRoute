package tn.Proxym.ProxymAcademy.service.conference;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Proxym.ProxymAcademy.dao.conference.ConferenceDao;
import tn.Proxym.ProxymAcademy.dto.conference.ConferenceDto;
import tn.Proxym.ProxymAcademy.dto.training.TrainingCreateDtoA;
import tn.Proxym.ProxymAcademy.model.Conference;
import tn.Proxym.ProxymAcademy.model.Training;

import java.util.List;
import java.util.Optional;
@Service
public class ConferenceServiceImpl implements ConferenceService {
@Autowired
    ConferenceDao conferenceDao ;

    @Override
    public Conference create(ConferenceDto conferenceDto, String path) {
        Mapper mapper=new DozerBeanMapper() ;
        Conference conference=mapper.map(conferenceDto,Conference.class);
        conference.setPhoto(path);
        return conferenceDao.create(conference);
    }

    @Override
    public List<Conference> findAll() {
        return conferenceDao.findAll();
    }

    @Override
    public void drop(Long id) {
        conferenceDao.deleteById(id);
    }

    @Override
    public Optional<Conference> findById(Long id) {
        return conferenceDao.findById(id);
    }
}
