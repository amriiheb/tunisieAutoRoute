package tn.Proxym.ProxymAcademy.jobs;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.Proxym.ProxymAcademy.model.Vehicle;
import tn.Proxym.ProxymAcademy.repository.VehicleRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
public class ReadFtpExecutor {

    @Autowired
    VehicleRepository vehicleRepository;

    @Scheduled(cron = "1 * * * * ?", zone = "Europe/Paris")
    public void readData() {
        System.out.println("****");
        String server = "51.75.123.231";
        int port = 21;
        String user = "ubuntu";
        String pass = "TWTVISION2035!";

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);


            List<String> PlateNames = Arrays.stream(ftpClient.listFiles("/home/ubuntu/TWTVISION/*_PLATE.jpg")).map(FTPFile::getName).collect(Collectors.toList());
            AtomicReference<String> plaqueType = new AtomicReference<>();
            PlateNames.forEach(s -> {
                try {
                    List<String> plateElement = Arrays.asList(s.split("_"));

                    if (plateElement.get(2).equals("TUN")) {

                        if (plateElement.get(1).indexOf("TN") > 0 && Arrays.asList(plateElement.get(1).split("TN")).get(0).length() <= 3) {
                            plaqueType.set("Plaque Standard");
                        } else if (plateElement.get(1).length() <= 6) {
                            plaqueType.set("Plaque RS");

                        } else if (plateElement.get(1).length() == 8) {
                            plaqueType.set("Plaque Administration");
                        }

                    } else {
                        plaqueType.set("Plaque non lisible");
                    }


                    int year = Integer.parseInt(plateElement.get(0).substring(0, 4));
                    int month = Integer.parseInt(plateElement.get(0).substring(4, 5));
                    int day = Integer.parseInt(plateElement.get(0).substring(6, 7));
                    int hour = Integer.parseInt(plateElement.get(0).substring(8, 9));
                    int minute = Integer.parseInt(plateElement.get(0).substring(10, 11));
                    int second = Integer.parseInt(plateElement.get(0).substring(12, 13));
                    // int millSecond = Integer.parseInt(plateElement.get(0).substring(14, 15));
                    LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);


                    String plateImage;
                    String vehicleImage;
                    try {
                        plateImage = "data:image/png;base64,".concat(new String(Base64.getEncoder().encode(downloadFile("/home/ubuntu/TWTVISION/" + s, ftpClient))));
                        vehicleImage = "data:image/png;base64,".concat(new String(Base64.getEncoder().encode(downloadFile("/home/ubuntu/TWTVISION/" + s.replace("_PLATE.jpg", "_VEHICLE.jpg"), ftpClient))));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    vehicleRepository.save(Vehicle.builder().date(localDateTime).plateType(plaqueType.get()).plateNumber(plateElement.get(1)).name(s).plateImage(plateImage).vehicleImage(vehicleImage).build());

                    ftpClient.rename("/home/ubuntu/TWTVISION/" + s, "/home/ubuntu/Archive/" + s);
                    ftpClient.rename("/home/ubuntu/TWTVISION/" + s.replace("_PLATE.jpg", "_VEHICLE.jpg"), "/home/ubuntu/Archive/" + s.replace("_PLATE.jpg", "_VEHICLE.jpg"));


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });


        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public byte[] downloadFile(String path, FTPClient ftpClient) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.out.println();
        System.out.printf("[downloadFile][%d] Is success to download file : %s -> %b", System.currentTimeMillis(), path, ftpClient.retrieveFile(path, byteArrayOutputStream));
        System.out.println();
        return byteArrayOutputStream.toByteArray();
    }

}
