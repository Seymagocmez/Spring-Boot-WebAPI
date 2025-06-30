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
POST http://localhost:8080/users/newuser
```

Json body:
```json
{
  "userName": "kullanici_ismi",
  "userPassword": "kullanici_sifresi"
}
```

Yanıt:

```json
"User kullanici_ismi created with id: b77202f8-21e5-4a32-8432-959cf8a5121a"
```

### Postman ile Test

**Postman Kurulumu:**
- [Postman İndir](https://www.postman.com/downloads/)
- Kurulumdan sonra uygulamayı açın ve yeni bir istek oluşturun.
- API endpoint'lerini test etmek için GET, POST, PUT, DELETE gibi HTTP metodlarını seçebilirsiniz.

**Postman Kullanımı:**
- Yeni bir koleksiyon oluşturup, API isteklerinizi bu koleksiyona ekleyebilirsiniz.
- Örneğin bir kullanıcı oluşturmak için:
  - Yöntem: `POST`
  - URL: `http://localhost:8080/users/newuser`
  - Body sekmesinden `raw` ve `JSON` seçin, aşağıdaki gibi bir içerik girin:
    ```json
    {
      "userName": "kullanici_ismi",
      "userPassword": "kullanici_sifresi"
    }
    ```
  - Gönder butonuna tıklayarak isteği test edin.
- GET, PUT, DELETE gibi diğer istekleri de benzer şekilde test edebilirsiniz.

**Swagger UI Kurulumu ve Kullanımı:**
- Projede Swagger/OpenAPI desteği yoksa, `springdoc-openapi-ui` gibi bir bağımlılığı `pom.xml` dosyanıza ekleyin:

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-ui</artifactId>
  <version>1.7.0</version>
</dependency>
```

- Ardından projeyi tekrar derleyip başlatın.
- Tarayıcınızda `http://localhost:8080/swagger-ui.html` adresine giderek API arayüzünü kullanabilirsiniz.

**Swagger UI Kullanımı:**
- Swagger arayüzünde, projenizdeki tüm endpoint'leri ve açıklamalarını görebilirsiniz.
- Her endpoint'in yanında "Try it out" (Dene) butonuna tıklayarak doğrudan arayüzden istek gönderebilirsiniz.
- Gerekli parametreleri ve body içeriğini arayüzde doldurabilirsiniz.
- Yanıtları ve hata mesajlarını anında görebilirsiniz.
- Sol menüde "Schemas" veya "Models" sekmesinde, API'da kullanılan veri modellerinin (ör. User, ErrorResponse) şemalarını ve alan açıklamalarını inceleyebilirsiniz.
- Swagger UI, API'nizin dökümantasyonunu otomatik olarak oluşturur ve test etmenizi kolaylaştırır.

- Yeni bir GET isteği oluşturun: `http://localhost:8080/users/{id}`
- Örneğin: `http://localhost:8080/users/b77202f8-21e5-4a32-8432-959cf8a5121a`
- Yanıt olarak aşağıdaki gibi bir kullanıcı bilgisi dönecektir:

```json
{
  "id": "b77202f8-21e5-4a32-8432-959cf8a5121a",
  "userName": "kullanici_ismi"
}
```

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