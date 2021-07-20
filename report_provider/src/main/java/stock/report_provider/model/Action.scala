package stock.report_provider.model

import stock.report_provider.model.BrokerAction.BrokerAction

case class Action(brokerId:String,
                  companyId:String,
                  activity:BrokerAction,
                  notificationId:String,
                  stockTicker:String,
                  amountOfStocks:Int,
                  stockPrice:Double,
                  totalPrice:Double,
                  timestamp:String)


