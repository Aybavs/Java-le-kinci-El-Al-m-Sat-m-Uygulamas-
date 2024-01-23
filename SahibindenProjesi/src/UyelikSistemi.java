import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class UyelikSistemi {

    private final Scanner scanner;

    public UyelikSistemi() {
        this.scanner = new Scanner(System.in);
    }

    public void calistir() {
        System.out.println("Hoş Geldiniz!");
        System.out.println("1 - Giriş Yap");
        System.out.println("2 - Üye Ol");
        System.out.println("3 - Çıkış");

        int secim = scanner.nextInt();

        if (secim == 1) {
            girisYap();
        } else if (secim == 2) {
            uyeOl();
        } else if (secim == 3) {
            System.out.println("Program Sonlandırılıyor.");
            System.exit(0);
        }  else {
            System.out.println("Geçersiz seçim. Program sonlandırılıyor.");
        }
    }

    private void girisYap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kullanıcı Adı: ");
        String kullaniciAdi = scanner.nextLine();

        System.out.print("Şifre: ");
        String sifre = scanner.nextLine();


        if (kontrolEt(kullaniciAdi, sifre)) {
            System.out.println("Giriş Başarılı. Hoş Geldiniz, " + kullaniciAdi + "!");
        } else {
            System.out.println("Kullanıcı adı veya şifre hatalı. Giriş başarısız.");
            girisYap();
        }
        AnaMenu anaMenu = new AnaMenu();
        anaMenu.menuGoster();
    }

    private void uyeOl() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kullanıcı Adı: ");
        String kullaniciAdi = scanner.nextLine();

        System.out.print("Şifre: ");
        String sifre = scanner.nextLine();


        int sayi1 = new Random().nextInt(10);
        int sayi2 = new Random().nextInt(10);
        int dogruSonuc = sayi1 + sayi2;

        System.out.print("Robot kontrolü: " + sayi1 + " + " + sayi2 + " = ");
        int kullaniciSonuc = scanner.nextInt();


        if (kullaniciSonuc == dogruSonuc) {
            kaydet(kullaniciAdi, sifre);
            System.out.println("Üyelik oluşturuldu. Giriş yapabilirsiniz.");
            girisYap();
        } else {
            System.out.println("Robot kontrolü başarısız. Üyelik oluşturulamadı.");
            uyeOl();
        }
    }

    private static void kaydet(String kullaniciAdi, String sifre) {
        Path dosyaYolu = FileSystems.getDefault().getPath("kullanicilar.txt");
        try (FileWriter writer = new FileWriter(dosyaYolu.toFile(), true)) {
            writer.write(kullaniciAdi + ":" + sifre + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean kontrolEt(String kullaniciAdi, String sifre) {

        Path dosyaYolu = FileSystems.getDefault().getPath("kullanicilar.txt");
        try (Scanner scanner = new Scanner(dosyaYolu)) {
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(":");
                if (satir[0].equals(kullaniciAdi) && satir[1].equals(sifre)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            return false;
    }
    public class AnaMenu {
        private Scanner scanner;
        private List<Ilan> ilanlar;
        private IlanIslemleri ilanIslemleri;

        public AnaMenu() {
            this.scanner = new Scanner(System.in);
            this.ilanlar = new ArrayList<>();
            this.ilanIslemleri = new IlanIslemleri(scanner);
        }

        public void menuGoster() {
            while (true) {
                System.out.println("*****************************************");
                System.out.println("=============Ana Menü=============");
                System.out.println("Lütfen yapmak istediğiniz işlemi seçin:");
                System.out.println("1 - Ilan Ekle");
                System.out.println("2 - Ilanları Listele");
                System.out.println("3 - Çıkış");

                int secim = scanner.nextInt();
                scanner.nextLine();

                switch (secim) {
                    case 1:
                        ilanEkle();
                        break;
                    case 2:
                        ilanIslemleri.ilanlariListeleSecenekleri();
                        break;
                    case 3:
                        System.out.println("Programdan çıkılıyor...");
                        return;
                    default:
                        System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                }
            }
        }

        private void ilanEkle() {
            System.out.println("Lütfen eklemek istediğiniz ilan türünü seçin:");
            System.out.println("1 - Ev");
            System.out.println("2 - Araba");
            System.out.println("3 - Telefon");
            System.out.println("4 - Bilgisayar");

            int ilanTuru = scanner.nextInt();
            scanner.nextLine();

            System.out.println("1 - Detaylı İlan Ekleme");
            System.out.println("2 - Basit İlan Ekleme");

            int ilanTipi = scanner.nextInt();
            scanner.nextLine();


            System.out.print("Başlık: ");
            String baslik = scanner.nextLine();

            System.out.print("Açıklama: ");
            String aciklama = scanner.nextLine();

            System.out.print("Fiyat: ");
            double fiyat = scanner.nextDouble();
            scanner.nextLine();

            if (ilanTipi == 1) {

                Ilan ilan = null;

                switch (ilanTuru) {
                    case 1:
                        ilan = ilanIslemleri.evIlaniniOlustur(baslik, aciklama, fiyat, scanner);
                        break;
                    case 2:
                        ilan = ilanIslemleri.arabaIlaniniOlustur(baslik, aciklama, fiyat, scanner);
                        break;
                    case 3:
                        ilan = ilanIslemleri.telefonIlaniniOlustur(baslik, aciklama, fiyat, scanner);
                        break;
                    case 4:
                        ilan = ilanIslemleri.bilgisayarIlaniniOlustur(baslik, aciklama, fiyat, scanner);
                        break;
                    default:
                        System.out.println("Geçersiz ilan türü seçildi.");
                        return;
                }

                ilanlar.add(ilan);
                System.out.println("Ilan başarıyla eklendi.");
            } else if (ilanTipi == 2) {
                Ilan ilan = null;
                switch (ilanTuru) {
                    case 1:
                        ilan = ilanIslemleri.evIlaniniOlustur(baslik, aciklama, fiyat);
                        break;
                    case 2:
                        ilan = ilanIslemleri.arabaIlaniniOlustur(baslik, aciklama, fiyat);
                        break;
                    case 3:
                        ilan = ilanIslemleri.telefonIlaniniOlustur(baslik, aciklama, fiyat);
                        break;
                    case 4:
                        ilan = ilanIslemleri.bilgisayarIlaniniOlustur(baslik, aciklama, fiyat);
                        break;
                    default:
                        System.out.println("Geçersiz ilan türü seçildi.");
                        return;
                }
                ilanlar.add(ilan);
                System.out.println("Ilan başarıyla eklendi.");
            }
        }
    }
}