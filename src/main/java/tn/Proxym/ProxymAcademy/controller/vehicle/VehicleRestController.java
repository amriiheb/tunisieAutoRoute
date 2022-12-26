package tn.Proxym.ProxymAcademy.controller.vehicle;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.Proxym.ProxymAcademy.model.Vehicle;
import tn.Proxym.ProxymAcademy.repository.VehicleRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicle/")
public class VehicleRestController {
    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("readPlate")
    public void readData() {
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
            PlateNames.forEach(s -> {
                try {
                    List<String> plateElement = Arrays.asList(s.split("_"));
                    int year = Integer.parseInt(plateElement.get(0).substring(0, 3));
                    int month = Integer.parseInt(plateElement.get(0).substring(4, 5));
                    int day = Integer.parseInt(plateElement.get(0).substring(6, 7));
                    int hour = Integer.parseInt(plateElement.get(0).substring(8, 9));
                    int minute = Integer.parseInt(plateElement.get(0).substring(10, 11));
                    int second = Integer.parseInt(plateElement.get(0).substring(12, 13));
                    int millSecond = Integer.parseInt(plateElement.get(0).substring(14, 15));
                    LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);

                    vehicleRepository.save(Vehicle.builder()
                            .date(localDateTime)
                            .plateNumber(plateElement.get(1))
                            .name(s)
                            .build());

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
}
