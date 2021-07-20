package stock.action_executor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stock.action_executor.services.StockActionService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/stock/buy")
public class BuyStock {

    @Autowired
    StockActionService stockActionService;

    @RequestMapping(value="", method = RequestMethod.POST)
    @ResponseBody
    public String buyStock(@RequestBody String stockToBuy) {
        stockActionService.buy(stockToBuy);
        return "";
    }

    @RequestMapping(value="/bulk", method = RequestMethod.POST)
    @ResponseBody
    public String buyStockInBulk(@RequestBody String stockToBuy) {
        stockActionService.buy(stockToBuy);
        return "";
    }
}
