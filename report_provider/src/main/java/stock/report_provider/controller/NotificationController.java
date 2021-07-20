package stock.report_provider.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stock.report_provider.report_service.NotificationService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/report/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("All/{startDate}/{endDate}")
    @ResponseBody
    public String gatAllNotificationByDate(@PathVariable String startDate, @PathVariable String endDate) {
      startDate = startDate == null ? LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE):startDate;
      endDate = endDate == null ? LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE):endDate;
      return notificationService.getAllNotificationByDateRange(startDate,endDate).toJSON().collectAsList().toString();
    }
    @GetMapping("All/{brokerId}")
    @ResponseBody
    public String gatAllNotificationByBrokerId(@PathVariable String brokerId) {
       return notificationService.getAllNotificationBrokerId(brokerId).toJSON().collectAsList().toString();
    }
    @GetMapping("All/{brokerId}/{startDate}/{endDate}")
    @ResponseBody
    public String gatAllNotificationByBrokerId(@PathVariable String brokerId,@PathVariable String startDate, @PathVariable String endDate) {
        startDate = startDate == null ? LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE):startDate;
        endDate = endDate == null ? LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE):endDate;
        return notificationService.getAllNotificationByDateRangeAndBrokerId(startDate,endDate,brokerId).toJSON().collectAsList().toString();
    }

}
