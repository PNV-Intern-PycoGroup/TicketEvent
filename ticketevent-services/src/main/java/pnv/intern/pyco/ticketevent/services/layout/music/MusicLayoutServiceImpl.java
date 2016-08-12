package pnv.intern.pyco.ticketevent.services.layout.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.layout.music.MusicLayoutRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.music.MusicLayoutConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutModel;

@Service
public class MusicLayoutServiceImpl implements MusicLayoutService {

	@Autowired
	private MusicLayoutRepository musicLayoutRepository;

	@Override
	public MusicLayoutModel getMusicLayoutById(Long id) {
		MusicLayoutModel musicLayoutModel = null;
		MusicLayoutEntity musicLayoutEntity = musicLayoutRepository.findOne(id);
		if (musicLayoutEntity != null) {
			musicLayoutModel = MusicLayoutConverter.convertMusicLayoutEntityToDTO(musicLayoutEntity);
		}
		return musicLayoutModel;
	}

	@Override
	public MusicLayoutModel save(MusicLayoutModel musicLayoutModel) {
		MusicLayoutModel result = null;
		if (musicLayoutModel != null) {
			MusicLayoutEntity musicLayoutEntity = musicLayoutRepository.save(MusicLayoutConverter.convertDTOToMusicLayoutEntity(musicLayoutModel));
			if (musicLayoutEntity != null) {
				result = MusicLayoutConverter.convertMusicLayoutEntityToDTO(musicLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public MusicLayoutModel findMusicLayoutByEventId(Long eventId) {
		MusicLayoutModel result = null;
		if (eventId != null) {
			MusicLayoutEntity musicLayoutEntity = musicLayoutRepository.findMusicLayoutByEventId(eventId);
			if (musicLayoutEntity != null) {
				result = MusicLayoutConverter.convertMusicLayoutEntityToDTO(musicLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public MusicLayoutModel update(MusicLayoutModel musicLayoutModel) {
		MusicLayoutModel result = null;
		if (musicLayoutModel != null) {
			MusicLayoutEntity musicLayoutEntity = musicLayoutRepository.saveAndFlush(MusicLayoutConverter.convertDTOToMusicLayoutEntity(musicLayoutModel));
			if (musicLayoutEntity != null) {
				result = MusicLayoutConverter.convertMusicLayoutEntityToDTO(musicLayoutEntity);
			}
		}
		return result;
	}

	@Override
	public boolean isExistMusicLayoutByEventId(Long eventId, Long musicLayoutId) {
		MusicLayoutEntity result = null;
		if (eventId != null && musicLayoutId != null) {
			result = musicLayoutRepository.findMusicLayoutByEventIdAndMusicLayoutId(eventId, musicLayoutId);
		}
		return result != null;
	}

}
