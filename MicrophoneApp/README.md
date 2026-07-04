# 🎤 Microphone Audio Router

Android uygulaması - Telefondaki sesleri direkt olarak mikrofona/kulaklığa yönlendirmek için.

## Özellikler

✅ **Bir buton basışı ile ses yönlendirmesi değişimi**
✅ **Gerçek zamanlı statü göstergesi**
✅ **Kolay kullanılabilir arayüz**
✅ **Tüm Android versiyonları (API 21+) destekle**

## Kurulum

### Gereksinimler
- Android Studio (en son sürüm)
- JDK 11 veya üzeri
- Android SDK (API 34)
- Git

### Adım 1: Repository'yi Klonla

```bash
git clone https://github.com/YOUR_USERNAME/MicrophoneApp.git
cd MicrophoneApp
```

### Adım 2: Android Studio'da Aç

1. Android Studio'yu açın
2. `File` → `Open` seçin
3. `MicrophoneApp` klasörünü seçin

### Adım 3: Gradle Sync

Proje açıldığında otomatik olarak Gradle senkronize olacaktır. Eğer olmadıysa:
- `File` → `Sync Now` seçin

### Adım 4: Derle ve Çalıştır

```bash
./gradlew build
./gradlew assembleDebug
```

APK dosyası burada oluşur:
```
app/build/outputs/apk/debug/app-debug.apk
```

## GitHub Actions ile APK Oluşturma

### Yapılandırma

1. Repository'yi GitHub'a Push edin
2. `.github/workflows/build.yml` dosyası otomatik olarak çalışacak
3. Her push'ta APK otomatik derlenecek

### APK İndirme

1. GitHub Repository'nize gidin
2. `Actions` sekmesine tıklayın
3. Son workflow'u seçin
4. `Artifacts` bölümünde APK'yı indirin

## Kullanım

1. Uygulamayı telefona kurun
2. Uygulamayı açın
3. İlk kullanımda izinleri onaylayın
4. **"Mikrofon"** butonuna basarak ses mikrofona yönlendir
5. **"Hoparlör"** butonuna basarak ses normal hoparlöre dön

## Dosya Yapısı

```
MicrophoneApp/
├── .github/
│   └── workflows/
│       └── build.yml          # GitHub Actions konfigürasyonu
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/microphoneapp/
│   │       │       └── MainActivity.kt
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   ├── values/
│   │       │   └── xml/
│   │       └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── gradle/
│   └── wrapper/
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── gradle.properties
└── README.md
```

## İzinler

Uygulama aşağıdaki izinleri gerektirir:

- **MODIFY_AUDIO_SETTINGS** - Ses ayarlarını değiştirmek
- **RECORD_AUDIO** - Mikrofon kullanımı

## Geliştirme

### Proje Değişikliği

1. Kodu değiştir
2. Commit et: `git commit -m "description"`
3. Push et: `git push`
4. GitHub Actions otomatik derleme yapacak

### APK Release Oluşturma

1. Yeni tag oluştur:
```bash
git tag v1.0
git push origin v1.0
```

2. GitHub Actions otomatik Release oluşturacak

## Sorun Giderme

### Gradle hatası
```bash
chmod +x gradlew
./gradlew clean
./gradlew build
```

### JDK versiyonu hatası
```bash
export JAVA_HOME=/path/to/jdk11
./gradlew build
```

### İzin sorunları
- Ayarlar → Uygulamalar → MicrophoneApp → İzinler
- Mikrofon ve ses izinlerini aktif edin

## Lisans

Bu proje MIT Lisansı altında açık kaynaktır.

## Destek

Sorularınız için GitHub Issues bölümünü kullanın.

---

**Geliştirici:** Kişisel Proje
**Son Güncelleme:** 2024
