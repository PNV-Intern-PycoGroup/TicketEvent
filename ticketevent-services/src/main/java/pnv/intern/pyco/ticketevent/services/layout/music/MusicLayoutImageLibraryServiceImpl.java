package pnv.intern.pyco.ticketevent.services.layout.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.entity.layout.music.MusicLayoutImageLibraryEntity;
import pnv.intern.pyco.ticketevent.repository.layout.music.MusicLayoutImageLibraryRepository;
import pnv.intern.pyco.ticketevent.services.converter.layout.music.MusicLayoutImageLibraryConverter;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutImageLibraryModel;

@Service
public class MusicLayoutImageLibraryServiceImpl implements MusicLayoutImageLibraryService {

	@Autowired
	private MusicLayoutImageLibraryRepository musicLayoutImageLibraryRepository;
	
	@Override
	public MusicLayoutImageLibraryModel getMusicLayoutImageLibraryById(Long id) {
		MusicLayoutImageLibraryModel musicLayoutImageLibraryModel = null;
		if (id != null) {
			MusicLayoutImageLibraryEntity musicLayoutImageLibraryEntity = musicLayoutImageLibraryRepository.findOne(id);
			if (musicLayoutImageLibraryEntity != null) {
				musicLayoutImageLibraryModel = MusicLayoutImageLibraryConverter.convertMusicLayoutImageLibraryEntityToDTO(musicLayoutImageLibraryEntity);
			}
		}
		return musicLayoutImageLibraryModel;
	}

	@Override
	public MusicLayoutImageLibraryModel save(MusicLayoutImageLibraryModel musicLayoutImageLibraryModel) {
		MusicLayoutImageLibraryModel result = null;
		if (musicLayoutImageLibraryModel != null) {
			MusicLayoutImageLibraryEntity musicLayoutImageLibraryEntity = musicLayoutImageLibraryRepository.save(MusicLayoutImageLibraryConverter.convertDTOToMusicLayoutImageLibraryEntity(musicLayoutImageLibraryModel));
			if (musicLayoutImageLibraryEntity != null) {
				musicLayoutImageLibraryModel = MusicLayoutImageLibraryConverter.convertMusicLayoutImageLibraryEntityToDTO(musicLayoutImageLibraryEntity);
			}
		}
		return result;
	}

	@Override
	public void deleteByUrl(String url) {
		MusicLayoutImageLibraryEntity musicLayoutImageLibraryEntity = musicLayoutImageLibraryRepository.getMusicImageLibraryByUrl(url);
		musicLayoutImageLibraryRepository.delete(musicLayoutImageLibraryEntity);
	}

}
