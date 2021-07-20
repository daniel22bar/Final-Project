package stock.report_provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stock.report_provider.report_service.ActionService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/report/action")
public class ActionController {

    @Autowired
    ActionService actionService;

    @GetMapping("All/{startDate}/{endDate}")
    @ResponseBody
    public String gatAllActionByDate(@PathVariable String startDate, @PathVariable String endDate) {

        startDate = startDate == null ? LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE):startDate;
        endDate = endDate == null ? LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE):endDate;
        return actionService.getAllActionByDateRange(startDate,endDate).toJSON().collectAsList().toString();
    }

    @GetMapping("All/{brokerId}")
    @ResponseBody
    public String gatAllActionByBrokerId(@PathVariable String brokerId) {
        return actionService.getAllActionBrokerId(brokerId).toJSON().collectAsList().toString();
    }

    @GetMapping("All/{brokerId}/{startDate}/{endDate}")
    @ResponseBody
    public String gatAllActionByBrokerIdAndDate(@PathVariable String brokerId,@PathVariable String startDate, @PathVariable String endDate) {
        startDate = startDate == null ? LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE):startDate;
        endDate = endDate == null ? LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE):endDate;
        return actionService.getAllActionByDateRangeAndBrokerId(startDate,endDate,brokerId).toJSON().collectAsList().toString();
    }
}

