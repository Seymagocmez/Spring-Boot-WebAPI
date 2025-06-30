# Spring Boot Web API Demo

## Proje Tanımı

Spring Boot Web API Demo, Java ve Spring Boot kullanılarak geliştirilmiş, temel RESTful servisleri sunan bir web API projesidir. Hızlıca CRUD işlemleri, API testleri ve modern web servis mimarisi öğrenmek isteyenler için ideal bir başlangıç noktasıdır.

---

## Gereksinimler

Projeye başlamadan önce aşağıdaki yazılımların kurulu olması gerekir:

- **Java JDK 17+**  
  [OpenJDK İndir](https://adoptium.net/)
- **Git**  
  [Git İndir](https://git-scm.com/downloads)
- **IDE:** IntelliJ IDEA, Eclipse veya VS Code ([Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack))
- **Maven** (proje ile birlikte wrapper olarak gelir, ayrıca yüklemenize gerek yok)
- (Opsiyonel) **Postman** veya **Swagger UI** ile API testleri

---

## Kurulum Adımları

1. **Projeyi Klonlayın:**

```bash
git clone https://github.com/yourusername/Spring-Boot-WebAPI.git
cd Spring-Boot-WebAPI
```

2. **Gerekli Bağımlılıkları Yükleyin ve Projeyi Derleyin:**

```bash
# Linux/Mac
./mvnw clean install
# Windows
mvnw.cmd clean install
```

3. **Projeyi Çalıştırın:**

```bash
# Linux/Mac
./mvnw spring-boot:run
# Windows
mvnw.cmd spring-boot:run
```

4. **Yapılandırma Dosyaları:**

`src/main/resources/application.properties` dosyasında temel ayarlar bulunur. Örnek:

```properties
spring.application.name=demo
#server.port=8080
```

Port veya başka ayarları değiştirmek için bu dosyayı düzenleyebilirsiniz.

---

## Kullanım Kılavuzu

Proje çalıştıktan sonra, API'yi aşağıdaki gibi kullanabilirsiniz:

### Örnek API Çağrısı

```http
GET http://localhost:8080/hello
```
Yanıt:
```json
"Merhaba Dünya!"
```

### Postman ile Test
- Postman ile yeni bir GET isteği oluşturun: `http://localhost:8080/hello`
- Yanıt olarak "Merhaba Dünya!" dönecektir.

### Swagger UI (Opsiyonel)
Swagger/OpenAPI desteği eklediyseniz, arayüze şu adresten ulaşabilirsiniz:
```
http://localhost:8080/swagger-ui.html
```

---

## Özellikler

- Spring Boot ile hızlı kurulum ve başlatma
- Temel RESTful endpoint örnekleri
- Kolayca genişletilebilir yapı
- Testler için hazır altyapı (JUnit)
- Maven ile bağımlılık yönetimi

---

## Proje Yapısı

```
Spring-Boot-WebAPI/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java
├── pom.xml
├── mvnw / mvnw.cmd
└── ...
```

- **DemoApplication.java:** Ana uygulama dosyası, Spring Boot'u başlatır.
- **application.properties:** Uygulama yapılandırma dosyası.
- **DemoApplicationTests.java:** Temel test sınıfı.
- **pom.xml:** Bağımlılık ve derleme ayarları.

---

## Özelleştirme

- **Yeni Endpoint Eklemek:**
  `src/main/java/com/example/demo/controller/` altında yeni bir Controller sınıfı oluşturun.
- **Veritabanı Bağlantısı:**
  `application.properties` dosyasına veritabanı ayarlarını ekleyin.
- **Bağımlılık Eklemek:**
  `pom.xml` dosyasına yeni bağımlılıklar ekleyin ve `./mvnw clean install` komutunu çalıştırın.

---

## Sorun Giderme

- **JAVA_HOME Hatası:**
  JDK'nın doğru kurulu ve ortam değişkeninin ayarlı olduğundan emin olun.
- **Port Çakışması:**
  `application.properties` dosyasında farklı bir port belirleyin.
- **Bağımlılık Hataları:**
  `./mvnw clean install` komutunu çalıştırarak temiz derleme yapın.

---

## Katkı Sağlama

1. Fork'layın ve yeni bir branch oluşturun.
2. Kod stiline ve proje yapısına uygun geliştirme yapın.
3. Açıklayıcı commit mesajları kullanın.
4. Pull request açmadan önce testlerin geçtiğinden emin olun.

Daha fazla bilgi için [CONTRIBUTING.md](CONTRIBUTING.md) dosyasına göz atabilirsiniz. (Varsa)

---

## Lisans

Bu proje [MIT Lisansı](LICENSE) ile lisanslanmıştır.

---

## İletişim & Destek

Sorularınız veya katkı talepleriniz için:
- E-posta: your.email@example.com
- GitHub: [github.com/yourusername](https://github.com/yourusername)
- LinkedIn: [linkedin.com/in/yourprofile](https://linkedin.com/in/yourprofile)

---

> "Kod yazmak, bir problemi çözmenin en eğlenceli yoludur. Sen de kendi hikayeni yazmaya başla!" 