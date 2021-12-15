import speech_recognition
import pyttsx3
import pyaudio
import os

recognizer = speech_recognition.Recognizer()

while True:
    try:
        with speech_recognition.Microphone() as mic:
            recognizer.adjust_for_ambient_noise(mic, 0.2)

            audio = recognizer.listen(mic)
            text = recognizer.recognize_google(audio)
            print("HELLLLO?")
            text = text.lower()
            text_file = open(os.path.abspath(os.getcwd()) + "voicecommand.txt")
            text_file.truncate()
            text_file.write(text)
            text_file.close()
            print(text_file)
            print(text)
    except speech_recognition.UnknownValueError():
        recognizer = speech_recognition.Recognizer()
        continue
