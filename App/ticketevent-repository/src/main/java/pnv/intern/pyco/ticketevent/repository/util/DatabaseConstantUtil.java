package pnv.intern.pyco.ticketevent.repository.util;

public class DatabaseConstantUtil {
	// USER_ROLE table
	public static final String USER_ROLE_TABLE = "USER_ROLE";
	public static final String USER_ROLE_FIELD_ID = "ID";
	public static final String USER_ROLE_FIELD_ROLE = "ROLE";

	// ACCOUNT table
	public static final String ACCOUNT_TABLE = "ACCOUNT";
	public static final String ACCOUNT_FIELD_ID = "ID";
	public static final String ACCOUNT_FIELD_ROLE_ID = "ROLE_ID";
	public static final String ACCOUNT_FIELD_USER_NAME = "USER_NAME";
	public static final String ACCOUNT_FIELD_PASSWORD = "PASSWORD";
	public static final String ACCOUNT_FIELD_EMAIL = "EMAIL";
	public static final String ACCOUNT_FIELD_IS_ACTIVE = "IS_ACTIVE";
	public static final String ACCOUNT_FIELD_ACTIVE_DATE = "ACTIVE_DATE";

	// USER_INFORMATION table
	public static final String USER_INFORMATION_TABLE = "USER_INFORMATION";
	public static final String USER_INFORMATION_FIELD_ID = "ID";
	public static final String USER_INFORMATION_FIELD_NAME = "NAME";
	public static final String USER_INFORMATION_FIELD_ADDRESS = "ADDRESS";
	public static final String USER_INFORMATION_FIELD_PHONE = "PHONE";
	public static final String USER_INFORMATION_FIELD_GENDER = "GENDER";
	public static final String USER_INFORMATION_FIELD_DATE_OF_BIRTH = "DATE_OF_BIRTH";
	public static final String USER_INFORMATION_FIELD_AVATAR = "AVATAR";

	// COMMENT table
	public static final String COMMENT_TABLE = "COMMENT";
	public static final String COMMENT_FIELD_ID = "ID";
	public static final String COMMENT_FIELD_EVENT_ID = "EVENT_ID";
	public static final String COMMENT_FIELD_ACCOUNT_ID = "ACCOUNT_ID";
	public static final String COMMENT_FIELD_CONTENT = "CONTENT";
	public static final String COMMENT_FIELD_COMMENT_DATE = "COMMENT_DATE";

	// EVENT table
	public static final String EVENT_TABLE = "EVENT";
	public static final String EVENT_FIELD_ID = "ID";
	public static final String EVENT_FIELD_TYPE_ID = "TYPE_ID";
	public static final String EVENT_FIELD_ACCOUNT_ID = "ACCOUNT_ID";
	public static final String EVENT_FIELD_LAYOUT_ID = "LAYOUT_ID";
	public static final String EVENT_FIELD_NAME = "NAME";
	public static final String EVENT_FIELD_INTRODUCTION = "INTRODUCTION";
	public static final String EVENT_FIELD_PLACE = "PLACE";
	public static final String EVENT_FIELD_CREATE_DATE = "CREATE_DATE";
	public static final String EVENT_FIELD_START_DATE = "START_DATE";
	public static final String EVENT_FIELD_END_DATE = "END_DATE";
	public static final String EVENT_FIELD_ORGANIZE_NAME = "ORGANIZE_NAME";
	public static final String EVENT_FIELD_ORGANIZE_INFO = "ORGANIZE_INFO";
	public static final String EVENT_FIELD_EMAIL = "EMAIL";
	public static final String EVENT_FIELD_PHONE_NUMBER = "PHONE_NUMBER";
	public static final String EVENT_FIELD_IS_PUBLIC = "IS_PUBLIC";
	public static final String EVENT_FIELD_IS_ACCEPT = "IS_ACCEPT";
	public static final String EVENT_FIELD_IMAGE_THUMBNAIL = "IMAGE_THUMBNAIL";

	// EVENT_TYPE table
	public static final String EVENT_TYPE_TABLE = "EVENT_TYPE";
	public static final String EVENT_TYPE_FIELD_ID = "ID";
	public static final String EVENT_TYPE_FIELD_NAME = "NAME";

	// EVENT_LAYOUT table
	public static final String EVENT_LAYOUT_TABLE = "EVENT_TYPE";
	public static final String EVENT_LAYOUT_FIELD_ID = "ID";
	public static final String EVENT_LAYOUT_FIELD_NAME = "NAME";

	// TICKET table
	public static final String TICKET_TABLE = "TICKET";
	public static final String TICKET_FIELD_ID = "ID";
	public static final String TICKET_FIELD_EVENT_ID = "EVENT_ID";
	public static final String TICKET_FIELD_PRICE = "PRICE";
	public static final String TICKET_FIELD_NAME = "NAME";
	public static final String TICKET_FIELD_DESCRIPTION = "DESCRIPTION";

	// TICKET_BUYER table
	public static final String TICKET_BUYER_TABLE = "TICKET_BUYER";
	public static final String TICKET_BUYER_FIELD_ID = "ID";
	public static final String TICKET_BUYER_FIELD_TICKET_ID = "TICKET_ID";
	public static final String TICKET_BUYER_FIELD_ACCOUNT_ID = "ACCOUNT_ID";
	public static final String TICKET_BUYER_FIELD_NAME = "NAME";
	public static final String TICKET_BUYER_FIELD_ADDRESS = "ADDRESS";
	public static final String TICKET_BUYER_FIELD_PHONE = "PHONE";
	public static final String TICKET_BUYER_FIELD_GENDER = "GENDER";
	public static final String TICKET_BUYER_FIELD_DATE_OF_BIRTH = "DATE_OF_BIRTH";

	// LAYOUT
	// FREE_LAYOUT table --------------------------------------------------------------------------
	public static final String FREE_LAYOUT_TABLE = "FREE_LAYOUT";
	public static final String FREE_LAYOUT_FIELD_ID = "ID";
	public static final String FREE_LAYOUT_FIELD_EVENT_ID = "EVENT_ID";
	public static final String FREE_LAYOUT_FIELD_CONTENT = "CONTENT";

	// FREE_LAYOUT_IMAGE_LIBRARY table
	public static final String FREE_LAYOUT_IMAGE_LIBRARY_TABLE = "FREE_LAYOUT_IMAGE_LIBRARY";
	public static final String FREE_LAYOUT_IMAGE_LIBRARY_FIELD_ID = "ID";
	public static final String FREE_LAYOUT_IMAGE_LIBRARY_FIELD_FREE_LAYOUT_ID = "FREE_LAYOUT_ID";
	public static final String FREE_LAYOUT_IMAGE_LIBRARY_FIELD_IMAGE = "IMAGE";
	// END -----------------------------------------------------------------------------------------

	// COURSE_LAYOUT table -------------------------------------------------------------------------
	public static final String COURSE_LAYOUT_TABLE = "COURSE_LAYOUT";
	public static final String COURSE_LAYOUT_FIELD_ID = "ID";
	public static final String COURSE_LAYOUT_FIELD_EVENT_ID = "EVENT_ID";
	public static final String COURSE_LAYOUT_FIELD_BANNER_IMAGE = "BANNER_IMAGE";
	public static final String COURSE_LAYOUT_FIELD_PLACE_IMAGE = "PLACE_IMAGE";

	// COURSE_LAYOUT_SPEAKER table
	public static final String COURSE_LAYOUT_SPEAKER_TABLE = "COURSE_LAYOUT_SPEAKER";
	public static final String COURSE_LAYOUT_SPEAKER_FIELD_ID = "ID";
	public static final String COURSE_LAYOUT_SPEAKER_FIELD_COURSE_LAYOUT_ID = "COURSE_LAYOUT_ID";
	public static final String COURSE_LAYOUT_SPEAKER_FIELD_NAME = "NAME";
	public static final String COURSE_LAYOUT_SPEAKER_FIELD_FIELD = "FIELD";
	public static final String COURSE_LAYOUT_SPEAKER_FIELD_HISTORY = "HISTORY";
	public static final String COURSE_LAYOUT_SPEAKER_FIELD_IMAGE = "IMAGE";

	// COURSE_LAYOUT_CONTENT table
	public static final String COURSE_LAYOUT_CONTENT_TABLE = "COURSE_LAYOUT_CONTENT";
	public static final String COURSE_LAYOUT_CONTENT_FIELD_ID = "ID";
	public static final String COURSE_LAYOUT_CONTENT_FIELD_COURSE_LAYOUT_ID = "COURSE_LAYOUT_ID";
	public static final String COURSE_LAYOUT_CONTENT_FIELD_TITLE = "TITLE";
	public static final String COURSE_LAYOUT_CONTENT_FIELD_CONTENT = "CONTENT";
	// END -----------------------------------------------------------------------------------------

	// MUSIC_LAYOUT table --------------------------------------------------------------------------
	public static final String MUSIC_LAYOUT_TABLE = "MUSIC_LAYOUT";
	public static final String MUSIC_LAYOUT_FIELD_ID = "ID";
	public static final String MUSIC_LAYOUT_FIELD_EVENT_ID = "EVENT_ID";
	public static final String MUSIC_LAYOUT_FIELD_LINK_HIGHLIGHT = "LINK_HIGHLIGHT";
	public static final String MUSIC_LAYOUT_FIELD_PLACE_IMAGE = "PLACE_IMAGE";

	// MUSIC_LAYOUT_FAMOUS_PERSON table
	public static final String MUSIC_LAYOUT_FAMOUS_PERSON_TABLE = "MUSIC_LAYOUT_FAMOUS_PERSON";
	public static final String MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_ID = "ID";
	public static final String MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_MUSIC_LAYOUT_ID = "MUSIC_LAYOUT_ID";
	public static final String MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_IMAGE = "IMAGE";
	public static final String MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_NAME = "NAME";
	public static final String MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_DATE_OF_BIRTH = "DATE_OF_BIRTH";
	public static final String MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_TALENT = "TALENT";
	public static final String MUSIC_LAYOUT_FAMOUS_PERSON_FIELD_HISTORY = "HISTORY";

	// MUSIC_LAYOUT_IMAGE_LIBRARY table
	public static final String MUSIC_LAYOUT_IMAGE_LIBRARY_TABLE = "MUSIC_LAYOUT_IMAGE_LIBRARY";
	public static final String MUSIC_LAYOUT_IMAGE_LIBRARY_FIELD_ID = "ID";
	public static final String MUSIC_LAYOUT_IMAGE_LIBRARY_FIELD_MUSIC_LAYOUT_ID = "MUSIC_LAYOUT_ID";
	public static final String MUSIC_LAYOUT_IMAGE_LIBRARY_FIELD_IMAGE = "IMAGE";
	// END -----------------------------------------------------------------------------------------

	// ACTIVITY_LAYOUT table --------------------------------------------------------------------------
	public static final String ACTIVITY_LAYOUT_TABLE = "ACTIVITY_LAYOUT";
	public static final String ACTIVITY_LAYOUT_FIELD_ID = "ID";
	public static final String ACTIVITY_LAYOUT_FIELD_EVENT_ID = "EVENT_ID";
	public static final String ACTIVITY_LAYOUT_FIELD_BACKGROUND_IMAGE = "BACKGROUND_IMAGE";
	public static final String ACTIVITY_LAYOUT_FIELD_EVENT_LOGO = "EVENT_LOGO";
	public static final String ACTIVITY_LAYOUT_FIELD_SOLOGAN = "SOLOGAN";

	// ACTIVITY_LAYOUT_IMAGE_LIBRARY table
	public static final String ACTIVITY_LAYOUT_IMAGE_LIBRARY_TABLE = "ACTIVITY_LAYOUT_IMAGE_LIBRARY";
	public static final String ACTIVITY_LAYOUT_IMAGE_LIBRARY_FIELD_ID = "ID";
	public static final String ACTIVITY_LAYOUT_IMAGE_LIBRARY_FIELD_ACTIVITY_LAYOUT_ID = "ACTIVITY_LAYOUT_ID";
	public static final String ACTIVITY_LAYOUT_IMAGE_LIBRARY_FIELD_IMAGE = "IMAGE";
	// END -----------------------------------------------------------------------------------------
	
}
