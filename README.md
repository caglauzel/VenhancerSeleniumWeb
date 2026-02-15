#🚀 Venhancer Hepsiburada.com Otomasyon Case

Bu proje, Hepsiburada web sitesi üzerinde uçtan uca ürün arama, filtreleme ve sepet işlemlerini test etmek amacıyla geliştirilmiş, yüksek stabilite odaklı bir Selenium otomasyon projesidir.

#🛠 Kullanılan Teknolojiler

Dil,Java 17

Framework,Selenium WebDriver (4.28.1)

Test Yönetimi,TestNG

Tasarım Deseni,Page Object Model (POM)

Build Tool,Maven

Wait Mekanizması,Explicit Wait (Thread.sleep kullanılmamıştır)

#📋 Test Senaryosu Adımları

Giriş: https://www.hepsiburada.com adresine gidilir.

Arama: Belirlenen ürün aratılır (Iphone 17 Pro Max).

Doğrulama: Arama sonuçlarının listelendiği kontrol edilir.

Filtreleme: Marka filtresi uygulanır.

Güncelleme: Sonuçların filtreye göre güncellendiği doğrulanır.

Seçim: Listeden ilk ürün seçilir.

Detay: Ürün detay sayfası doğrulanır.

Sepet: Ürün sepete eklenir.

Navigasyon: Sepete gidilir.

Sonuç: Ürünün sepette olduğu ve doğru ürün olduğu doğrulanır.

#⚙️ Kurulum ve ÇalıştırmaGereksinimler

JDK: 11 veya üzeri (Önerilen: 17)

Maven: Sistem yoluna (PATH) eklenmiş olmalıdır.

Tarayıcı: Güncel Google Chrome.

Projeyi ÇalıştırmaProjeyi klonlayın:

#Bashgit clone [PROJE_URL]

Proje dizinine gidin:

#Bashcd VenhancerWebSelenium

Testleri koşturun:

#Bashmvn clean test

Hazırlayan: [Çağla ÜZEL]Bu proje Venhancer teknik değerlendirme süreci kapsamında hazırlanmıştır.
