package pnv.intern.pyco.ticketevent.services.layout.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutFamousPersonEntity;
import pnv.intern.pyco.ticketevent.repository.layout.music.MusicLayoutFamousPersonRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.music.MusicLayoutFamousPersonConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutFamousPersonModel;

@Service
public class MusicLayoutFamousPersonServiceImpl implements MusicLayoutFamousPersonService {

	@Autowired
	private MusicLayoutFamousPersonRepository musicLayoutFamousPersonRepository;
	
	@Override
	public MusicLayoutFamousPersonModel getMusicLayoutFamousPersonById(Long id) {
		MusicLayoutFamousPersonModel musicLayoutFamousPersonModel = null;
		if (id != null) {
			MusicLayoutFamousPersonEntity musicLayoutFamousPersonEntity = musicLayoutFamousPersonRepository.findOne(id);
			if (musicLayoutFamousPersonEntity != null) {
				musicLayoutFamousPersonModel = MusicLayoutFamousPersonConverter.convertMusicLayoutFamousPersonEntityToDTO(musicLayoutFamousPersonEntity);
			}
		}
		return musicLayoutFamousPersonModel;
	}

	@Override
	public MusicLayoutFamousPersonModel save(MusicLayoutFamousPersonModel musicLayoutFamousPersonModel) {
		MusicLayoutFamousPersonModel result = null;
		if (musicLayoutFamousPersonModel != null) {
			MusicLayoutFamousPersonEntity musicLayoutFamousPersonEntity = musicLayoutFamousPersonRepository.save(MusicLayoutFamousPersonConverter.convertDTOToMusicLayoutFamousPersonEntity(musicLayoutFamousPersonModel));
			if (musicLayoutFamousPersonEntity != null) {
				result = MusicLayoutFamousPersonConverter.convertMusicLayoutFamousPersonEntityToDTO(musicLayoutFamousPersonEntity);
			}
		}
		return result;
	}

	@Override
	public void deleteByImageUrl(String url) {
		MusicLayoutFamousPersonEntity musicLayoutFamousPersonEntity = musicLayoutFamousPersonRepository.getMusicFamouPersonByImageUrl(url);
		musicLayoutFamousPersonRepository.delete(musicLayoutFamousPersonEntity);
	}

	@Override
	public MusicLayoutFamousPersonModel update(MusicLayoutFamousPersonModel musicLayoutFamousPersonModel) {
		MusicLayoutFamousPersonModel result = null;
		if (musicLayoutFamousPersonModel != null) {
			MusicLayoutFamousPersonEntity musicLayoutFamousPersonEntity = musicLayoutFamousPersonRepository.saveAndFlush(MusicLayoutFamousPersonConverter.convertDTOToMusicLayoutFamousPersonEntity(musicLayoutFamousPersonModel));
			if (musicLayoutFamousPersonEntity != null) {
				result = MusicLayoutFamousPersonConverter.convertMusicLayoutFamousPersonEntityToDTO(musicLayoutFamousPersonEntity);
			}
		}
		return result;
	}

}
