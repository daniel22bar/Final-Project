package stock.action_executor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stock.action_executor.services.StockActionService;




@RestController
@RequestMapping("/stock/sell")
public class SellStock {

    @Autowired
    StockActionService stockActionService;

    @RequestMapping(value="/", method = RequestMethod.POST)
    @ResponseBody
    public String buyStock(@RequestBody String stockToSell) {
        stockActionService.sell(stockToSell);
        return "";
    }

    @RequestMapping(value="/bulk", method = RequestMethod.POST)
    @ResponseBody
    public String buyStockInBulk(@RequestBody String stockToSell) {
        stockActionService.sell(stockToSell);
        return "";
    }
}
// /home/naya/Project/projectFiles