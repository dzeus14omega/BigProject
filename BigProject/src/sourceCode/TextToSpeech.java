package sourceCode;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {
	private static final String VOICENAME1="kevin";
	private static final String VOICENAME2="kevin16";
	private static VoiceManager voiceHuman;
	private static Voice voice;
	
	public static String getVoicename1() {
		return VOICENAME1;
	}
	public static String getVoicename2() {
		return VOICENAME2;
	}
	
	private static void init() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voiceHuman = VoiceManager.getInstance();
		voice = voiceHuman.getVoice(VOICENAME1);
	
	}
	
	public static void speak(String speech) {
		init();
		voice.allocate();
		voice.speak(speech);
		voice.deallocate();
	}
	
}
