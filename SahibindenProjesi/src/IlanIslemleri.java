import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class IlanIslemleri {
    private Scanner scanner;

    public IlanIslemleri(Scanner scanner) {
        this.scanner = scanner;
    }

    public Ilan evIlaniniOlustur(String baslik, String aciklama, double fiyat, Scanner scanner) {
        System.out.print("Metrekare: ");
        int metrekare = scanner.nextInt();

        System.out.print("Oda Sayısı: ");
        int odaSayisi = scanner.nextInt();

        System.out.print("Bina Yaşı: ");
        int binaYasi = scanner.nextInt();

        System.out.print("Bulunduğu Kat: ");
        int bulunduguKat = scanner.nextInt();

        boolean esyali = false;
        String cevap;
        do {
            System.out.print("Eşyalı mı? (evet/hayır): ");
            cevap = scanner.next().toLowerCase();

            if (cevap.equals("evet")) {
                esyali = true;
            } else if (cevap.equals("hayır")) {
                esyali = false;
            } else {
                System.out.println("Geçersiz giriş. 'evet' veya 'hayır' giriniz.");
            }
        } while (!cevap.equals("evet") && !cevap.equals("hayır"));

        EvIlani evIlani = new EvIlani(baslik, aciklama, fiyat, metrekare, odaSayisi, binaYasi, bulunduguKat, esyali);
        ilaniDosyayaKaydet(evIlani);
        return evIlani;
    }


    public Ilan evIlaniniOlustur(String baslik, String aciklama, double fiyat) {
        EvIlani evIlani = new EvIlani(baslik, aciklama, fiyat, 0, 0, 0, 0, false);
        ilaniDosyayaKaydet(evIlani);
        return evIlani;
    }

    public Ilan telefonIlaniniOlustur(String baslik, String aciklama, double fiyat, Scanner scanner) {
        System.out.print("Marka: ");
        String marka = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Depolama Kapasitesi (GB): ");
        int depolamaGB = scanner.nextInt();
        scanner.nextLine();

        boolean nfcVar = false;
        String cevap;
        do {
            System.out.print("Nfcli mı? (evet/hayır): ");
            cevap = scanner.next().toLowerCase();

            if (cevap.equals("evet")) {
                nfcVar = true;
            } else if (cevap.equals("hayır")) {
                nfcVar = false;
            } else {
                System.out.println("Geçersiz giriş. 'evet' veya 'hayır' giriniz.");
            }
        } while (!cevap.equals("evet") && !cevap.equals("hayır"));
        scanner.nextLine();

        System.out.print("Kamera Çözünürlüğü: ");
        String kamera = scanner.nextLine();


        TelefonIlani telefonIlani = new TelefonIlani(baslik, aciklama, fiyat, marka, model, depolamaGB, nfcVar, kamera);
        ilaniDosyayaKaydet(telefonIlani);
        return telefonIlani;
    }

    public Ilan telefonIlaniniOlustur(String baslik, String aciklama, double fiyat) {
        TelefonIlani telefonIlani = new TelefonIlani(baslik, aciklama, fiyat,"-","-",0,false,"0");
        ilaniDosyayaKaydet(telefonIlani);
        return telefonIlani;
    }

    public Ilan bilgisayarIlaniniOlustur(String baslik, String aciklama, double fiyat, Scanner scanner) {
        System.out.print("Marka: ");
        String marka = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("İşlemci: ");
        String islemci = scanner.nextLine();

        System.out.print("RAM (GB): ");
        int ramGB = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Depolama Kapasitesi (GB): ");
        int depolamaGB = scanner.nextInt();
        scanner.nextLine();

        BilgisayarIlani bilgisayarIlani = new BilgisayarIlani(baslik, aciklama, fiyat, marka, model, islemci, ramGB, depolamaGB);
        ilaniDosyayaKaydet(bilgisayarIlani);
        return bilgisayarIlani;
    }


    public Ilan bilgisayarIlaniniOlustur(String baslik, String aciklama, double fiyat) {
        BilgisayarIlani bilgisayarIlani = new BilgisayarIlani(baslik, aciklama, fiyat,"-","-","-",0,0);
        ilaniDosyayaKaydet(bilgisayarIlani);
        return bilgisayarIlani;
    }

    public Ilan arabaIlaniniOlustur(String baslik, String aciklama, double fiyat, Scanner scanner) {
        System.out.print("Marka: ");
        String marka = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Yıl: ");
        int yil = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Yakıt Tipi: ");
        String yakitTipi = scanner.nextLine();

        System.out.print("Vites Tipi: ");
        String vitesTipi = scanner.nextLine();

        System.out.print("Motor Gücü: ");
        int motorGucu = scanner.nextInt();
        scanner.nextLine();

        ArabaIlani arabaIlani = new ArabaIlani(baslik, aciklama, fiyat, marka, model, yil, yakitTipi, vitesTipi, motorGucu);
        ilaniDosyayaKaydet(arabaIlani);
        return arabaIlani;
    }


    public Ilan arabaIlaniniOlustur(String baslik, String aciklama, double fiyat) {
        ArabaIlani arabaIlani = new ArabaIlani(baslik, aciklama, fiyat,"-","-",0,"-","-",0);
        ilaniDosyayaKaydet(arabaIlani);
        return arabaIlani;
    }



    private void ilaniDosyayaKaydet(Ilan ilan) {
        Path dosyaYolu = FileSystems.getDefault().getPath(ilan.getClass().getSimpleName().toLowerCase() + ".txt");
        try (FileWriter writer = new FileWriter(dosyaYolu.toFile(), true)) {
            writer.write("************************************************************\n");
            writer.write(ilan.detayBilgileriString() + "\n");
            System.out.println("Ilan dosyaya başarıyla kaydedildi.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }




    public void ilanlariListeleSecenekleri() {
        System.out.println("Lütfen listelemek istediğiniz ilan türünü seçin:");
        System.out.println("1 - Ev Ilanlari");
        System.out.println("2 - Araba Ilanlari");
        System.out.println("3 - Telefon Ilanlari");
        System.out.println("4 - Bilgisayar Ilanlari");

        int secim = scanner.nextInt();
        scanner.nextLine();

        switch (secim) {
            case 1:
                ilanlariListele("evilani.txt");
                break;
            case 2:
                ilanlariListele("arabailani.txt");
                break;
            case 3:
                ilanlariListele("telefonilani.txt");
                break;
            case 4:
                ilanlariListele("bilgisayarilani.txt");
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }
    }

     private void ilanlariListele(String dosyaAdi) {
        Path dosyaYolu = Paths.get(dosyaAdi);
        try {
            List<String> ilanSatirlari = Files.readAllLines(dosyaYolu);
            for (String ilanSatiri : ilanSatirlari) {
                System.out.println(ilanSatiri);
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
}
