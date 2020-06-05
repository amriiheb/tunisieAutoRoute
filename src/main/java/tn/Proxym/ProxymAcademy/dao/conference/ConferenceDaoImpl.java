package tn.Proxym.ProxymAcademy.dao.conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.Proxym.ProxymAcademy.model.Conference;
import tn.Proxym.ProxymAcademy.repository.ConferenceRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class ConferenceDaoImpl  implements ConferenceDao{
    @Autowired
    ConferenceRepository conferenceRepository ;
    @Override
    public Optional<Conference> findById(long id) {
        return conferenceRepository.findById(id);
    }

    @Override
    public List<Conference> findAll() {
        return conferenceRepository.findAll();
    }

    @Override
    public Conference create(Conference entity) {
        return conferenceRepository.save(entity);
    }

    @Override
    public Conference update(Conference entity) {
        return conferenceRepository.save(entity);
    }

    @Override
    public void delete(Conference entity) {
        conferenceRepository.delete(entity);

    }

    @Override
    public void deleteById(long entityId) {
        conferenceRepository.deleteById(entityId);

    }
}
