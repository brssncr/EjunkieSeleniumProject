# 🧪 TECHNO STUDY Agile Software Testing Project - 3  
## 🎯 E-JUNKIE SELENIUM TEST PROJESİ

### 📝 PROJE HAKKINDA  
Bu projede, **Java** programlama dili ve **Selenium** test otomasyon kütüphanesi kullanılarak, [E-Junkie Demo Alışveriş Sitesi](https://shopdemo.e-junkie.com/) üzerinde çeşitli kullanıcı senaryolarına dayalı otomasyon testleri gerçekleştirilmiştir.

Alternatif test ortamı için [E-Junkie Alternatif Demo](https://shopdemo.fatfreeshop.com/?)

---

### 📌 PROJE AMACI  
Bu sprint kapsamında, E-Junkie alışveriş platformunun ödeme sistemi, kullanıcı iletişim formları ve yönlendirme bağlantıları gibi temel işlevleri test edilmiştir. Amaç; kullanıcı deneyimini, güvenliği ve sistem kararlılığını artırmaya yönelik test süreçlerini yürütmektir.

---

### 🧩 USER STORY DETAYLARI

1️⃣ **US_301**  
Demo e-kitap sepete eklenir. Geçersiz promosyon kodu girildiğinde "Geçersiz Promosyon Kodu" uyarısının görüntülenmesi beklenir.
![1](https://github.com/user-attachments/assets/92df1dcf-50f6-4570-ab4b-e4e59ec4a538)



2️⃣ **US_302**  
Demo e-kitap sepete eklenir. Ödeme sırasında boş bırakılan “e-posta” ve “kart ismi” alanlarına karşılık hata mesajlarının (“Geçersiz e-posta” ve “Geçersiz kart ismi”) aynı anda gösterilmesi beklenir.
![2](https://github.com/user-attachments/assets/e6c696b9-ad81-4d53-a315-2ed0bd66f42c)



3️⃣ **US_303**  
Sepete eklenen demo kitap için ödeme ekranında geçersiz kart numarası girildiğinde “Kart numaranız geçersiz” uyarısının alınması gerekir.
![3](https://github.com/user-attachments/assets/368bc518-5bf9-4f0a-8590-b5e0ff947417)




4️⃣ **US_304**  
Tüm bilgiler doğru girildiğinde ödeme işlemi başarılı olmalı ve "Siparişiniz onaylandı. Teşekkür ederiz!" mesajı görüntülenmelidir.
![4](https://github.com/user-attachments/assets/da5653e7-396d-4a03-b192-f9231c1274d8)




5️⃣ **US_305**  
Başarılı ödeme sonrası, e-kitabın fiyatı ile sipariş tutarı eşleşmeli ve "İndir" butonu ile dosya indirilebilmelidir.
![5](https://github.com/user-attachments/assets/bc58ebc2-f621-4d23-a58d-0202fc8fe40f)




6️⃣ **US_306**  
Ana sayfada yer alan “Bize Ulaşın” formu aracılığıyla iletişim kurulabilmeli, gerekli alanlar doldurularak form gönderimi test edilmelidir.
![6](https://github.com/user-attachments/assets/bc64a4f1-88be-4429-bd14-af041a165106)




7️⃣ **US_307**  
Shopdemo sitesinde "E-Commerce by E-Junkie" bağlantısı üzerinden [e-junkie.com](https://www.e-junkie.com/) ana sayfasına yönlendirme doğrulanmalıdır.
![7](https://github.com/user-attachments/assets/bdb47e3c-7ef7-4e9e-aa40-dac67dbc0a47)



8️⃣ **US_308**  
Ana sayfada bulunan "Nasıl Çalışır" bağlantısı ile açılan videonun oynatılması ve ardından pencerenin kapanması adımları test edilmelidir.
![8](https://github.com/user-attachments/assets/a3002844-b0cf-43af-8951-520326d6c04f)


---

### 📚 KULLANILAN TEKNOLOJİLER & KÜTÜPHANELER  
- **Java JDK 17+**  
- **Selenium WebDriver - v4.29.0**  
- **TestNG** (isteğe bağlı yapılandırma)  
- **Maven**  
- **WebDriver Manager**  
- **GitHub**  
- **Jira** (Sprint yönetimi için)  

---

## 👨‍💻 PROJE EKİBİ

| İsim           | GitHub Profili                             |
|----------------|---------------------------------------------|
| Merve Kıtır     | [github.com/mervektr](https://github.com/mervektr)         |
| Mert Saraç      | [github.com/meertsarac](https://github.com/meertsarac)     |
| Barış Sancar    | [github.com/brssncr](https://github.com/brssncr)           |
| Tolga Aktaş     | [github.com/aktstlga](https://github.com/aktstlga)         |
| Mert Canat      | [github.com/MertCanat91](https://github.com/MertCanat91)   |
| Berk Gültekin   | [github.com/berkgltkn](https://github.com/berkgltkn)       |
| Arif Etli       | [github.com/ArfEtl](https://github.com/ArfEtl)             |

---

### 🔁 EK NOTLAR  
- Negatif test senaryoları kullanıcı deneyimini geliştirmek ve sistem kararlılığını artırmak amacıyla özellikle ele alınmıştır.  
- Testler Chrome, Firefox gibi yaygın tarayıcılar ile yürütülmüştür.  
- Testlerde manuel doğrulama ve otomasyon birlikte kullanılmış, bazı senaryolar için ekran kayıtları (GIF) hazırlanmıştır.  
- Sprint boyunca iletişim için Discord, Slack veya Microsoft Teams gibi platformlar tercih edilmiştir.  
