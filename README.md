# livescore-android

**Create Firebase configuration key**

- Key generation
`keytool -genkey -v -keystore debug.keystore -storepass android -alias androiddebugkey -keypass android -keyalg RSA -keysize 2048 -validity 10000`

- Get keystore fingerprint
`keytool -list -v -alias androiddebugkey -keystore %USERPROFILE%\.android\debug.keystore`

- Copy SHA1 fingerprint to Firebase Project

- Store google-services.json file from Firebase Project to /app