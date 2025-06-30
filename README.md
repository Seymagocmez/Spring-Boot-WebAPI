# Spring Boot Web API - User Controller

## Proje Tanımı
<div align="center">
<img width="400" alt="webapi_thumb" src="https://github.com/user-attachments/assets/5e68eb64-0a6d-4439-a7bb-ecf93df79c44" />
  
</div>

Spring Boot Web API Demo, Java ve Spring Boot kullanılarak geliştirilmiş, temel RESTful servisleri sunan bir web API projesidir. Hızlıca CRUD işlemleri, API testleri ve modern web servis mimarisi öğrenmek isteyenler için ideal bir başlangıç noktasıdır.

Bu projede, kurumsal projelerde yaygın olarak tercih edilen ve geniş topluluk desteğine sahip olan Java Spring Boot kullanılmıştır. RESTful mimari benimsenmiş, Model-View-Controller (MVC) tasarım deseni uygulanmıştır. Veri transferinde güvenlik ve esneklik için DTO (Data Transfer Object) yapısı tercih edilmiştir. Kullanıcı kimlikleri için benzersizliği ve güvenliği sağlamak amacıyla UUID kullanılmıştır. Kodun sürdürülebilirliği ve güvenliği için mümkün olduğunca immutable (değiştirilemez) nesneler ve kapsülleme (private/final değişkenler) tercih edilmiştir. API'nin doğruluğu ve işlevselliği Postman ve Swagger UI araçları ile test edilmiştir.


## Gereksinimler

Projeye başlamadan önce aşağıdaki yazılımların kurulu olması gerekir:

- **Java JDK 17+**  
  [OpenJDK İndir](https://adoptium.net/)
- **Git**  
  [Git İndir](https://git-scm.com/downloads)
- **IDE:** IntelliJ IDEA, Eclipse veya VS Code ([Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack))
- **Maven** (proje ile birlikte wrapper olarak gelir, ayrıca yüklemenize gerek yok)
- (Opsiyonel) **Postman** veya **Swagger UI** ile API testleri

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

## Özellikler

- Spring Boot ile hızlı kurulum ve başlatma
- Temel RESTful endpoint örnekleri
- Kolayca genişletilebilir yapı
- Testler için hazır altyapı (JUnit)
- Maven ile bağımlılık yönetimi
## Proje Yapısı
```
Spring-Boot-WebAPI/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java
│   │   │   ├── controller/
│   │   │   │   └── UserController.java
│   │   │   ├── dto/
│   │   │   │   └── UserRequest.java
│   │   │   └── model/
│   │   │       └── User.java
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
- **controller/UserController.java:** Kullanıcı işlemleriyle ilgili REST endpoint'lerini barındırır.
- **dto/UserRequest.java:** Kullanıcıdan gelen istek verilerini taşımak için kullanılan veri transfer nesnesi.
- **model/User.java:** Kullanıcı modelini ve temel alanlarını tanımlar.
- **application.properties:** Uygulama yapılandırma dosyası.
- **DemoApplicationTests.java:** Temel test sınıfı.
- **pom.xml:** Bağımlılık ve derleme ayarları.


## Özelleştirme

- **Yeni Endpoint Eklemek:**
  `src/main/java/com/example/demo/controller/` altında yeni bir Controller sınıfı oluşturun.
- **Veritabanı Bağlantısı:**
  `application.properties` dosyasına veritabanı ayarlarını ekleyin.
- **Bağımlılık Eklemek:**
  `pom.xml` dosyasına yeni bağımlılıklar ekleyin ve `./mvnw clean install` komutunu çalıştırın.

## Sorun Giderme

- **JAVA_HOME Hatası:**
  JDK'nın doğru kurulu ve ortam değişkeninin ayarlı olduğundan emin olun.
- **Port Çakışması:**
  `application.properties` dosyasında farklı bir port belirleyin.
- **Bağımlılık Hataları:**
  `./mvnw clean install` komutunu çalıştırarak temiz derleme yapın.
## Proje Süreci 

API geliştirme sürecinde, ASP.NET, PHP, Python Flask ve Java Spring Boot gibi çeşitli dil ve framework alternatifleri değerlendirilmiştir. Java Spring Boot'un tercih edilme nedenleri şunlardır:

- Kurumsal projelerde yaygın olarak kullanılması,
- Geniş ve aktif bir topluluğa sahip olması,
- RESTful mimariyi güçlü şekilde desteklemesi,
- Gelişmiş güvenlik ve yapılandırma seçenekleri sunması.

Projede REST tarzı mimari benimsenmiştir. Bu mimari, modern web servislerinde esneklik ve ölçeklenebilirlik sağlamaktadır. REST mimarisi hakkında daha fazla bilgi için [bu yazıyı](https://github.com/Seymagocmez/web_api?tab=readme-ov-file#3-web-api-t%C3%BCrleri-ve-baz%C4%B1-mimariler) inceleyebilirsiniz.

<div align="center">
  <img src="https://github.com/user-attachments/assets/726b626d-a030-42b6-9fe3-deb309564ba7" alt="Image description" width="600"/>
  <p><em>Örnek bir MVC yapısı</em></p>
</div>
Ayrıca, projede Model-View-Controller (MVC) tasarım deseni uygulanmıştır. MVC, kodun katmanlara ayrılmasını sağlayarak okunabilirlik ve sürdürülebilirlik sunar. Controller sınıfları gelen istekleri karşılar, Model sınıfları veriyi temsil eder, DTO (Data Transfer Object) ise veri transferini kolaylaştırır ve dışa yalnızca gerekli alanların açılmasını sağlar.

Geliştirme ortamı olarak Visual Studio Code seçilmiş, JDK kurulumu ve Spring Initializr ile temel proje oluşturulmuştur. Gerekli eklentiler ve bağımlılıklar yüklendikten sonra, "pom.xml not found" gibi yaygın bir hata ile karşılaşılmış ve bu sorun, projenin kök dizininde pom.xml dosyasının bulunması ve Maven'ın doğru kurulması ile giderilmiştir.

Kodlama aşamasında, önce User modeli ve Controller oluşturulmuş, ardından veri transferinin daha güvenli ve esnek olması amacıyla DTO yapısına geçilmiştir. Özellikle POST isteklerinde, request body ile veri almak için DTO kullanımı tercih edilmiştir.

Spring Framework'te @RequestBody ve @PathVariable gibi anotasyonlar, gelen verinin işlenmesini kolaylaştırmakta ve kodun okunabilirliğini artırmaktadır.

Model sınıflarında değişkenler private ve final olarak tanımlanmıştır. Bu yaklaşım;
- **private** ile dışarıdan doğrudan erişimi engelleyerek kapsülleme sağlar,
- **final** ile ise değerlerin değişmemesini garanti altına alır ve özellikle id gibi alanlarda güvenlik ve tutarlılık sunar.

Kullanıcı kimliği için UUID kullanılmıştır. UUID, benzersiz ve tahmin edilmesi zor bir kimlik oluşturduğu için güvenlik ve veri bütünlüğü açısından avantaj sağlar. Kullanıcı id'sinin uygulama içinde belirlenmesi, dışarıdan müdahaleyi engeller.

Test altyapısı olarak ilerleyen aşamalarda birim testlerin (unit test) eklenmesi planlanmaktadır. Bu sayede kodun doğruluğu ve güvenilirliği sürekli olarak kontrol edilebilecektir.

Nesne tasarımında ise, mümkün olduğunca immutable (değiştirilemez) yapılar tercih edilmiştir. Immutable nesneler, hata olasılığını azaltır ve çoklu iş parçacığında güvenli uygulamalar geliştirilmesini kolaylaştırır.

API'nin doğruluğu ve işlevselliği, Postman ve Swagger UI araçları ile test edilmiştir. Kurulum ve kullanım detayları için ilgili bölümlere başvurulabilir.

🌐 Kaynaklar

[Spring Boot Quick Start](https://www.youtube.com/watch?v=oRFCeRVWCNE)

[Swagger Nedir, Ne İşe Yarar?](https://medium.com/android-t%C3%BCrkiye/swagger-nedir-ne-i%CC%87%C5%9Fe-yarar-e8c12a9e9e7f)

[Building REST API Using Spring Boot](https://medium-com.translate.goog/@pratik.941/building-rest-api-using-spring-boot-a-comprehensive-guide-3e9b6d7a8951?_x_tr_sl=en&_x_tr_tl=tr&_x_tr_hl=tr&_x_tr_pto=tc)

[Official Documentation From Spring Boot](https://docs.spring.io/spring-boot/)

[Görsel 1](https://arifgokce.com/asp-net-web-api-token-based-authentication/)

[Görsel 2](https://arifgokce.com/asp-net-web-api-token-based-authentication/)

[Görsel 2](https://javapro.io/de/spring-boot/)

[Görsel 2](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSn041zDaAZX26Ui9CS0wLvq8NTDNEsCNuH8Q&s)
 
