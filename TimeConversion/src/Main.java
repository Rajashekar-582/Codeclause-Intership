import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for date and time
        System.out.print("Enter date and time (yyyy-MM-dd HH:mm:ss): ");
        String inputDateTime = scanner.nextLine();

        // Parse the user input to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(inputDateTime, formatter);

        // Get source time zone
        System.out.print("Enter source time zone (e.g., America/New_York): ");
        String sourceTimeZoneId = scanner.nextLine();

        // Get target time zone
        System.out.print("Enter target time zone (e.g., Europe/London): ");
        String targetTimeZoneId = scanner.nextLine();

        // Convert the time from the source time zone to the target time zone
        ZoneId sourceZone = ZoneId.of(sourceTimeZoneId);
        ZoneId targetZone = ZoneId.of(targetTimeZoneId);
        ZonedDateTime sourceZonedDateTime = localDateTime.atZone(sourceZone);
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZone);

        // Format and display the converted time
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String convertedTime = targetZonedDateTime.format(outputFormatter);
        System.out.println("Converted time: " + convertedTime);

        scanner.close();
    }
}

